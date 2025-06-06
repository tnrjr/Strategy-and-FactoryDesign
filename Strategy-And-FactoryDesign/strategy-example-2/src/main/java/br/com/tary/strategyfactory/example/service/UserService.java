package br.com.tary.strategyfactory.example.service;

import br.com.tary.strategyfactory.example.database.DatabaseSingleton;
import br.com.tary.strategyfactory.example.dto.NewUserRequest;
import br.com.tary.strategyfactory.example.model.UserEntity;
import br.com.tary.strategyfactory.example.strategy.NewAccountValidationStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final List<NewAccountValidationStrategy> newAccountValidationStrategy;
    private final DatabaseSingleton database;

    public UserService(List<NewAccountValidationStrategy> newAccountValidationStrategy) {
        this.newAccountValidationStrategy = newAccountValidationStrategy;
        this.database = DatabaseSingleton.getInstance();
    }

    public void createNewAccount(NewUserRequest request) {
        newAccountValidationStrategy.forEach(validation -> validation.execute(request));

        database.save(UserEntity.builder()
                .id(UUID.randomUUID())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .registrationTime(LocalDateTime.now())
                .build());
    }
}
