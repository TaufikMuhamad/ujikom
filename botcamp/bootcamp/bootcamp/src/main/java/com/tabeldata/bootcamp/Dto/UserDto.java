package com.tabeldata.bootcamp.Dto;

import com.tabeldata.bootcamp.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private UserRole userRole;
}
