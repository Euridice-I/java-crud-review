package com.api.crud.use_cases;

import com.api.crud.domain.use_cases.IUserUseCase;
import com.api.crud.models.UserModel;
import com.api.crud.domain.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.Optional;

public class UserUseCaseImp implements IUserUseCase {
    private final IUserRepository userRepository;

    public UserUseCaseImp(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    public UserModel findById(long id) {
        return  userRepository.findById(id).orElse(null);
    }
}
