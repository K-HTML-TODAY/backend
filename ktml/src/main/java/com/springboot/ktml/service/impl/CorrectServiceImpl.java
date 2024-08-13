package com.springboot.ktml.service.impl;

import com.springboot.ktml.config.security.JwtTokenProvider;
import com.springboot.ktml.data.dto.request.RequestCorrectDto;
import com.springboot.ktml.data.dto.response.ResponseCorrectDto;
import com.springboot.ktml.data.entity.Correct;
import com.springboot.ktml.data.entity.User;
import com.springboot.ktml.data.repository.CorrectRepository;
import com.springboot.ktml.data.repository.UserRepository;
import com.springboot.ktml.service.CorrectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CorrectServiceImpl implements CorrectService {
    private final CorrectRepository correctRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public CorrectServiceImpl(CorrectRepository correctRepository, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.correctRepository = correctRepository;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public ResponseCorrectDto saveCorrect(RequestCorrectDto requestCorrectDto, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        String token = jwtTokenProvider.resolveToken(httpServletRequest);
        String account = jwtTokenProvider.getUsername(token);

        User user = userRepository.getByAccount(account);

        Correct correct = new Correct();
        correct.setUser(user);
        correct.setTitle(requestCorrectDto.getTitle());
        correct.setContent(requestCorrectDto.getContent());
        Correct savedCorrect = correctRepository.save(correct);

        ResponseCorrectDto responseCorrectDto = new ResponseCorrectDto();
        responseCorrectDto.setReview_id(savedCorrect.getCorrect_id());
        responseCorrectDto.setTitle(savedCorrect.getTitle());
        responseCorrectDto.setContent(savedCorrect.getContent());
        responseCorrectDto.setWriter(correct.getUser().getName());

        return responseCorrectDto;
    }
}
