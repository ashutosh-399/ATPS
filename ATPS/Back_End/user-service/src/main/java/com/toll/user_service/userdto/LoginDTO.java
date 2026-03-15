package com.toll.user_service.userdto;

import lombok.Data;

@Data
public class LoginDTO {
    private String email;
    private String password;
}
