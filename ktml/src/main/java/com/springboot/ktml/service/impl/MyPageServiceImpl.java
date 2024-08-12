package com.springboot.ktml.service.impl;

import com.springboot.ktml.config.security.JwtTokenProvider;
import com.springboot.ktml.data.dto.response.ResponseMyPageDto;
import com.springboot.ktml.data.entity.User;
import com.springboot.ktml.data.repository.UserRepository;
import com.springboot.ktml.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class MyPageServiceImpl implements MyPageService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    @Autowired
    public MyPageServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public ResponseMyPageDto getUser(HttpServletRequest servletRequest) {
        String token = jwtTokenProvider.resolveToken(servletRequest);
        String account = jwtTokenProvider.getUsername(token);

        ResponseMyPageDto responseMyPageDto = new ResponseMyPageDto();
        if (jwtTokenProvider.validationToken(token)) {
            User user = userRepository.getByAccount(account);
            responseMyPageDto.setAccount(user.getAccount());
            responseMyPageDto.setName(user.getName());
            responseMyPageDto.setPhone(user.getPhone());
            responseMyPageDto.setEmail(user.getEmail());
            responseMyPageDto.setUid(user.getUid());
            responseMyPageDto.setNickname(user.getNickname());
        }
        return responseMyPageDto;
    }
}
