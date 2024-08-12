package com.springboot.ktml.service;

import com.springboot.ktml.data.dto.request.RequestLevelDto;
import com.springboot.ktml.data.dto.response.ResponseLevelListDto;
import com.springboot.ktml.data.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface LevelService {
    boolean addLevel(Long uid, HttpServletRequest servletRequest) throws Exception;
   long countLevelForUser(Long uid);


    ResponseLevelListDto getTop3UsersWithHighestLevel(HttpServletResponse servletResponse);

    /*
            @Override
            public ResponseLevelListDto getTop3UsersWithHighestLevel(HttpServletResponse servletResponse) {
                ModelMapper mapper = new ModelMapper();
                List<ResponseLevelDto> responseLevelDtoList = new ArrayList<>();
                ResponseLevelListDto responseLevelListDto = new ResponseLevelListDto();

                // 상위 3명의 레벨을 가진 유저를 조회
                List<Level> topLevels = levelRepository.findTop3ByOrderByLevelDesc();
                for (Level level : topLevels) {

                    ResponseLevelDto responseLevelDto = mapper.map(level, ResponseLevelDto.class);
                    responseLevelDto.setUser_name(level.getUser().getName());
                    responseLevelDtoList.add(responseLevelDto);
                }
                responseLevelListDto.setItem(responseLevelDtoList);
                return responseLevelListDto;
            }*/
    List<User> getTop3UsersByLevel();
}
