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

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    //private User adminUser = userRepository.findById(Long.valueOf(1)).orElse(null);

    private String hashPassword(String password) {
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }

    public User addUser(User user) {
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        user.setUserId(Math.abs(new Random().nextLong()));
        return userRepository.save(user);
    }

    /*public boolean authenticateAdminUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        List<User> matchedUsers = userRepository.findByUsername(username);
        String hashedInputPassword = hashPassword(password);
        return adminUser.getPassword().equals(hashedInputPassword);
    }*/

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

        /*throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                "Authentication failed: Invalid username and/or password");*/
        return null;
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

    public Optional<User> getUserById(Long deviceId) {
        return userRepository.findById(deviceId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public int getTenantId(User user) {
        return authenticateUser(user).getTenantId();
    }

    public boolean isValidLogin(User user) {
        return authenticateUser(user) != null;
    }

    public ResponseEntity deleteUser(User user) {
        User userToDelete = authenticateUser(user);
        userRepository.delete(userToDelete);
        return ResponseEntity.status(HttpStatus.OK).body("User successfully deleted");
    }
}
