package com.springboot.ktml.controller;


import com.springboot.ktml.data.dto.request.RequestChatGPT;
import com.springboot.ktml.data.dto.response.ResponseChatGPT;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ChatGPTController {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    private final RestTemplate template;
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatGPTController.class);

    @GetMapping("/api/v1/main/getGptApi")
    public ResponseEntity<Map<String, String>> getGptApi(@RequestParam(name = "prompt") String prompt) {
        RequestChatGPT request = new RequestChatGPT(model, prompt);
        ResponseChatGPT response = template.postForObject(apiURL, request, ResponseChatGPT.class);

        if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
            String content = response.getChoices().get(0).getMessage().getContent();
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("content", content);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        } else {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", "No response from GPT API");
            return new ResponseEntity<>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



