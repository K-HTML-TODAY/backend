package com.springboot.ktml.service.impl;

import com.springboot.ktml.config.security.JwtTokenProvider;
import com.springboot.ktml.data.dto.response.ResponseLevelListDto;
import com.springboot.ktml.data.entity.Level;
import com.springboot.ktml.data.entity.User;
import com.springboot.ktml.data.repository.LevelRepository;
import com.springboot.ktml.data.repository.UserRepository;
import com.springboot.ktml.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    @Autowired
    public LevelServiceImpl(LevelRepository levelRepository, JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
        this.levelRepository = levelRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
    }

    @Override
    public boolean addLevel(Long uid,HttpServletRequest servletRequest) throws Exception {
        /*String token = jwtTokenProvider.resolveToken(servletRequest);
        String account = jwtTokenProvider.getUsername(token);
        User user = userRepository.getByAccount(account);

        Level levelup = levelRepository.findByUser(user);
        Level level = new Level();
        level.setUser(user);
        level.setCreatedAt(LocalDateTime.now());
        levelRepository.save(level);

        return true;*/
        String token = jwtTokenProvider.resolveToken(servletRequest);
        if (token == null || !jwtTokenProvider.validationToken(token)) {
            throw new Exception("Invalid or missing token");
        }

        String account = jwtTokenProvider.getUsername(token);
        User user = userRepository.getByAccount(account);

        if (user == null) {
            throw new Exception("User not found");
        }
        Level level = new Level();
        level.setUser(user);
        level.setCreatedAt(LocalDateTime.now());
        levelRepository.save(level);

        return true;
    }

    @Override
    public long countLevelForUser(Long uid) {
        Optional<User> user = userRepository.findById(uid);
        return levelRepository.countByUser(user);
    }

    @Override
    public ResponseLevelListDto getTop3UsersWithHighestLevel(HttpServletResponse servletResponse) {
        return null;
    }

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
    @Override
    public List<User> getTop3UsersByLevel() {
        List<Object[]> results = levelRepository.findUsersWithLevelCount();

        return results.stream()
                .limit(3)  // 상위 3명만 가져오기
                .map(result -> (User) result[0])  // 결과에서 사용자 추출
                .collect(Collectors.toList());
    }

}
