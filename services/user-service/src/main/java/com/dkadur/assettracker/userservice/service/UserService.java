package com.dkadur.assettracker.userservice.service;

import com.dkadur.assettracker.userservice.entity.User;
import com.dkadur.assettracker.userservice.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.PreRemove;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private User authenticatedUser;

    private String hashPassword(String password) {
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }

    public User addUser(User user) {
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public User authenticateUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        List<User> matchedUsers = userRepository.findByUsername(username);
        String hashedInputPassword = hashPassword(password);
        for (User possibleUser : matchedUsers) {
            if (possibleUser.getPassword().equals(hashedInputPassword)) {
                //authenticatedUser = possibleUser;
                return possibleUser;
            }
        }

        throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                "Authentication failed: Invalid username and/or password");
    }

    public User updateUsername(User user, String newUsername) {
        User userToUpdate = authenticateUser(user);
        userToUpdate.setUsername(newUsername);
        return userRepository.save(userToUpdate);
    }

    public User updatePassword(User user, String newPassword) {
        User userToUpdate = authenticateUser(user);
        String hashedNewPassword = hashPassword(newPassword);
        userToUpdate.setPassword(hashedNewPassword);
        return userRepository.save(userToUpdate);
    }

    public ResponseEntity deleteUser(User user) {
        User userToDelete = authenticateUser(user);
        userRepository.delete(userToDelete);
        return ResponseEntity.status(HttpStatus.OK).body("User successfully deleted");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
