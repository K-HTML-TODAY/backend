package com.springboot.ktml.data.repository;

import com.springboot.ktml.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByAccount(String account);
}
