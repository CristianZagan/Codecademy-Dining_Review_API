package com.portfolio.codecademy.controller;


import com.portfolio.codecademy.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.portfolio.codecademy.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{displayName}")
    public ResponseEntity<UserDto> getUserByDisplayName(@PathVariable String displayName) {
        UserDto userDto = userService.getUserByDisplayName(displayName);
        if (userDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/users/" + createdUser.getDisplayName())).body(createdUser);
    }

    @PutMapping("/{displayName}")
    public ResponseEntity<UserDto> updateUserByDisplayName(@PathVariable String displayName, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUserByDisplayName(displayName, userDto);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{displayName}")
    public ResponseEntity<Void> deleteUserByDisplayName(@PathVariable String displayName) {
        userService.deleteUserByDisplayName(displayName);
        return ResponseEntity.noContent().build();
    }

}
