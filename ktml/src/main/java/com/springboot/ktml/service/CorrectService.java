package com.springboot.ktml.service;

import com.springboot.ktml.data.dto.request.RequestCorrectDto;
import com.springboot.ktml.data.dto.response.ResponseCorrectDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CorrectService {

    ResponseCorrectDto saveCorrect(RequestCorrectDto requestCorrectDto,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse);
}
