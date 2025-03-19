package com.api.crud.domain.use_cases;

import com.api.crud.models.UserModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IUserUseCase {
//    public UserModel findByEmailYegemito(String email);
    ArrayList<UserModel> getUsers();
    UserModel saveUser(UserModel user);
    Optional<UserModel> getUserById(long id);
    Optional<UserModel> updateUserById(long id, UserModel request);
    UserModel findById(long id);
    Boolean deleteUserById(long id);

}

