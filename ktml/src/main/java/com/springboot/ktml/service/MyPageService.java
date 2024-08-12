package com.springboot.ktml.service;

import com.springboot.ktml.data.dto.response.ResponseMyPageDto;

import javax.servlet.http.HttpServletRequest;

public interface MyPageService {
    ResponseMyPageDto getUser(HttpServletRequest servletRequest);
}
