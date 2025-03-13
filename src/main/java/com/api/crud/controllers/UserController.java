package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") long id) {
        return this.userService.getUserById(id);
    }

    @PutMapping(path = "/{id}")
    public Optional<UserModel> updateUserById(@PathVariable("id") long id, @RequestBody UserModel user) {
        return this.userService.updateUserById(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        boolean ok = this.userService.deleteUserById(id);
        if (ok) {
            return "User deleted with success";
        } else {
            return null;
        }
    }

}
