package com.api.crud.domain.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
//    UserModel findByEmailYegemito(String email);
}

