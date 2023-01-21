package br.com.axolot.animal.dtos;

import lombok.Data;

@Data
public class UserChangePassword {
    private String username;
    private String newPassword;
    private String oldPassword;
}
