package br.com.axolot.animal.dtos;

import lombok.Data;
@Data
public class UserRegister {
    private String username;
    private String password;
    private String email;
    private String age;
    private String nickname;
}
