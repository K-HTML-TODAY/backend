package com.springboot.ktml.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLevelListDto {
    private List<ResponseLevelDto> item;


}
