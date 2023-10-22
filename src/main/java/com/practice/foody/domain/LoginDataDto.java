package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class LoginDataDto {
    private String email;
    private String password;

    public LoginDataDto() {
    }
}
