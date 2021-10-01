package com.example.back_end.persistence.repository;

import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Roles;
import com.example.back_end.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    List<User> findAllByRole(Roles role);

    List<User> findAllByRoleAndCourse(Roles role, Course course);
}