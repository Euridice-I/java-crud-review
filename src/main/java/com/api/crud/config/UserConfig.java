package com.api.crud.config;

import com.api.crud.controllers.UserController;
import com.api.crud.domain.repositories.IUserRepository;
import com.api.crud.domain.use_cases.IUserUseCase;
import com.api.crud.use_cases.UserUseCaseImp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

//    @Bean
//    public IUserRepository userRepository(IUserRepository userRepository){
//        return new UserRepositoryImp() {
//        };
//    }

    @Bean
    public IUserUseCase userUseCase(@Qualifier("IUserRepository") IUserRepository userRepository) {
        return new UserUseCaseImp(userRepository);
    }

    @Bean
    public UserController userController(IUserUseCase userUseCase){
        return new UserController(userUseCase);
    }
}
