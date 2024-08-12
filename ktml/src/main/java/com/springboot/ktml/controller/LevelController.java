package com.springboot.ktml.controller;

import com.springboot.ktml.data.dto.request.RequestLevelDto;
import com.springboot.ktml.data.dto.response.ResponseLevelListDto;
import com.springboot.ktml.data.entity.User;
import com.springboot.ktml.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/level")
public class LevelController {

    private final LevelService levelService;

    @PostMapping("/levelUp")
    public ResponseEntity<String> createLevel(Long uid, HttpServletRequest servletRequest) throws Exception {
        boolean isLevelAdd = levelService.addLevel(uid,servletRequest);
        if (isLevelAdd) {
            return ResponseEntity.status(HttpStatus.OK).body("levelUp!!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to level up");
        }
    }

    @GetMapping("/countLevel/{uid}")
    public ResponseEntity<Long> countLevelForUser(@PathVariable Long uid) {
        long count = levelService.countLevelForUser(uid);
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }


    @GetMapping("/top3")
    public List<User> getTop3UsersByLevel() {
        List<User> user = levelService.getTop3UsersByLevel();
        return ResponseEntity.status(HttpStatus.OK).body(user).getBody();
    }

}
