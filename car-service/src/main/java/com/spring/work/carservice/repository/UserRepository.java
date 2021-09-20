package com.spring.work.carservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.work.carservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

    public List<User> findByFirstName(String firstName);
}
