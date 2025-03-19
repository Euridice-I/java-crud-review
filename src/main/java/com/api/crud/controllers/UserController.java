package com.api.crud.controllers;

import com.api.crud.domain.use_cases.IUserUseCase;
import com.api.crud.models.UserModel;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final IUserUseCase userUseCase;

    public UserController(IUserUseCase userUseCase){
        this.userUseCase=userUseCase;
    }

//    @GetMapping(path = "/{id}")
//    public UserModel getUsers(@PathVariable("id") long id) {
//        return this.userUseCase.findById(id);
//    }

    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return this.userUseCase.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userUseCase.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") long id) {
        return this.userUseCase.getUserById(id);
    }

    @PutMapping(path = "/{id}")
    public Optional<UserModel> updateUserById(@PathVariable("id") long id, @RequestBody UserModel user) {
        return this.userUseCase.updateUserById(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        boolean ok = this.userUseCase.deleteUserById(id);
        if (ok) {
            return "User deleted with success";
        } else {
            return null;
        }
    }

}
