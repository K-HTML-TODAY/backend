package com.springboot.ktml.data.repository;

import com.springboot.ktml.data.entity.Level;
import com.springboot.ktml.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level,Long> {
    Level findByUser(User user);
    long countByUser(Optional<User> user);

    @Query("SELECT l.user, COUNT(l) FROM Level l GROUP BY l.user ORDER BY COUNT(l) DESC")
    List<Object[]> findUsersWithLevelCount();
}
