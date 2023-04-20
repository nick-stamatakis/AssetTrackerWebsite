package com.dkadur.assettracker.userservice.controller;

import com.dkadur.assettracker.userservice.entity.User;
import com.dkadur.assettracker.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add/")
    public User addUser (@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/update/username/")
    public User updateUsername(@RequestBody HashMap<String, User> newUsernameMap) {
        String newUsername = newUsernameMap.keySet().iterator().next();
        User user = newUsernameMap.get(newUsername);
        return userService.updateUsername(user, newUsername);
    }

    @PostMapping("/update/password/")
    public User updatePassword(@RequestBody HashMap<String, User> newPasswordMap) {
        String newPassword = newPasswordMap.keySet().iterator().next();
        User user = newPasswordMap.get(newPassword);
        return userService.updatePassword(user, newPassword);
    }

    @PostMapping("/get/token/")
    public int getToken(@RequestBody User user) {
        return userService.getTenantId(user);
    }

    @PostMapping("/login-check/")
    public boolean isValidLogin(@RequestBody User user) {
        return userService.isValidLogin(user);
    }

    @GetMapping("/get/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/get/all/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete/")
    public ResponseEntity deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

}
