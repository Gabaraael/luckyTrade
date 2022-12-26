package br.com.axolot.animal.Service;

import br.com.axolot.animal.dtos.UserRegister;
import br.com.axolot.animal.model.UserEntity;
import br.com.axolot.animal.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegister userRegister) {
        if(checkUsernameExist(userRegister.getUsername())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "This username is already in use"
            );
        }
        userRepository.save(buildUser(userRegister));
    }

    public Boolean checkUsernameExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }


    public Boolean login(UserRegister userRegister) {
        UserEntity user = userRepository.findByUsername(userRegister.getUsername()).get();
        return passwordEncoder.matches(userRegister.getPassword(), user.getPassword());
    }

    public UserEntity buildUser(UserRegister userRegister) {
        return UserEntity.builder()
                .username(userRegister.getUsername())
                .password(passwordEncoder.encode(userRegister.getPassword()))
                .build();
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
