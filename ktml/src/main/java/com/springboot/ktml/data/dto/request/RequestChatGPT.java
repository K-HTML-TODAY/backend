package com.springboot.ktml.data.dto.request;


import com.springboot.ktml.data.entity.Message;
import lombok.Data;

import java.util.List;

@Data
public class RequestChatGPT {
    private String model;
    private List<Message> messages;

//    일회성 질문
    public RequestChatGPT(String model, String prompt) {
        this.model = model;
        this.messages = List.of(new Message("user", prompt));
    }


}
