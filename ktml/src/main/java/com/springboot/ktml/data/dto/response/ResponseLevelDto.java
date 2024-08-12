package com.springboot.ktml.data.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ResponseLevelDto {
    private Long level_id;
    private Long uid;
    private String user_name;
    private LocalDateTime createdAt;
}
