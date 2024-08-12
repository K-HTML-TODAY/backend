package com.springboot.ktml.service;


import com.springboot.ktml.data.dto.SignDto.SignInResultDto;
import com.springboot.ktml.data.dto.SignDto.SignUpDto;
import com.springboot.ktml.data.dto.SignDto.SignUpResultDto;

public interface SignService {
    SignUpResultDto SignUp(SignUpDto signUpDto, String roles);
    SignInResultDto SignIn(String account, String password) throws RuntimeException;
}
