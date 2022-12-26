package br.com.axolot.animal.controller;

import br.com.axolot.animal.Service.UserService;
import br.com.axolot.animal.dtos.UserRegister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> registerUser( UserRegister userRegister) {
        userService.register(userRegister);
        return ResponseEntity.ok().body(true);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser( UserRegister userRegister) {
        return ResponseEntity.ok().body(userService.login(userRegister));
    }
}
