package com.tabeldata.bootcamp.services.auth;

import com.tabeldata.bootcamp.Dto.SignupRequest;
import com.tabeldata.bootcamp.Dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);

}
