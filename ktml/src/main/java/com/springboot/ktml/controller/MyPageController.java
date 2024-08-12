package com.springboot.ktml.controller;

import com.springboot.ktml.data.dto.response.ResponseMyPageDto;
import com.springboot.ktml.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/mypage")
public class MyPageController {
    private final MyPageService myPageService;
    @Autowired
    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    @GetMapping("/getUser")
    public ResponseEntity<ResponseMyPageDto> getUser(HttpServletRequest httpServletRequest) {
        ResponseMyPageDto user = myPageService.getUser(httpServletRequest);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
