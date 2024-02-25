package com.tabeldata.bootcamp.Dto;

import com.tabeldata.bootcamp.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;

    private UserRole userRole;

    private Long userId;

}
