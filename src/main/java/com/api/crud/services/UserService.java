package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserById(long id) {
        return userRepository.findById(id);
    }

    public Optional<UserModel> updateUserById(long id, UserModel request) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserModel userToUpdate = user.get();
            userToUpdate.setFirstName(request.getFirstName());
            userToUpdate.setLastName(request.getLastName());
            userToUpdate.setEmail(request.getEmail());
            userRepository.save(userToUpdate);
        }
        return user;
    }

    public Boolean deleteUserById(long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
