package com.dkadur.assettracker.userservice.controller;

import com.dkadur.assettracker.userservice.entity.User;
import com.dkadur.assettracker.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/add/", produces = "application/json")
    public User addUser (@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping(value = "/update/username/", produces = "application/json")
    public User updateUsername(@RequestBody HashMap<String, User> newUsernameMap) {
        String newUsername = newUsernameMap.keySet().iterator().next();
        User user = newUsernameMap.get(newUsername);
        return userService.updateUsername(user, newUsername);
    }

    @PostMapping(value = "/update/password/", produces = "application/json")
    public User updatePassword(@RequestBody HashMap<String, User> newPasswordMap) {
        String newPassword = newPasswordMap.keySet().iterator().next();
        User user = newPasswordMap.get(newPassword);
        return userService.updatePassword(user, newPassword);
    }

    @DeleteMapping(value = "/delete/", produces = "application/json")
    public ResponseEntity deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    @GetMapping(value = "/get-all/", produces = "application/json")
    public List<User> getAllUsers(@RequestBody String adminPassword) {
        return userService.getAllUsers(adminPassword);
    }

}
