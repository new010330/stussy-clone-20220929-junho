package com.stussy.stussclone20220929junho.dto.account;

import lombok.Data;

@Data
public class RegisterReqDto {
    private String lastName;
    private String firstName;
    private String email;
    private String password;
}
