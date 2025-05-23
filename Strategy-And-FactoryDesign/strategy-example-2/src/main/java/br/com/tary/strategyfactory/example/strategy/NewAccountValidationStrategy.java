package br.com.tary.strategyfactory.example.strategy;

import br.com.tary.strategyfactory.example.dto.NewUserRequest;

public interface NewAccountValidationStrategy {

    void execute(NewUserRequest request);
}
