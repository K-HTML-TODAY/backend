package com.springboot.ktml.controller;

import com.springboot.ktml.data.dto.request.RequestCorrectDto;
import com.springboot.ktml.data.dto.response.ResponseCorrectDto;
import com.springboot.ktml.service.CorrectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/correct")
public class CorrectController {

    private final CorrectService correctService;

    @PostMapping("/createCorrect")
    public ResponseEntity<ResponseCorrectDto> saveCorrect(
            @RequestBody RequestCorrectDto requestCorrectDto,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse
    ) {
        ResponseCorrectDto responseCorrectDto = correctService.saveCorrect(requestCorrectDto, servletRequest, servletResponse);
        return ResponseEntity.status(HttpStatus.OK).body(responseCorrectDto);
    }
}