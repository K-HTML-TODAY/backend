package com.springboot.ktml.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCorrectDto {
    private Long review_id;
    private String title;
    private String content;
    private String writer;
}
