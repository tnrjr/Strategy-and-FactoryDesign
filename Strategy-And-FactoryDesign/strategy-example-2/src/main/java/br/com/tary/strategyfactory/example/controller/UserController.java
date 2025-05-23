package br.com.tary.strategyfactory.example.controller;

import br.com.tary.strategyfactory.example.dto.NewUserRequest;
import br.com.tary.strategyfactory.example.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/account")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNewAccount(@Valid @RequestBody NewUserRequest request) throws Exception {
        userService.createNewAccount(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
