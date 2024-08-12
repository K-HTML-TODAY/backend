package com.springboot.ktml.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseMyPageDto {
    private Long uid;
    private String name;
    private String email;
    private String phone;
    private String account;
    private String nickname;
}
