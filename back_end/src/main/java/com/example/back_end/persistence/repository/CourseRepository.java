package com.example.back_end.persistence.repository;

import com.example.back_end.persistence.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByTitleIsLike(String title);
}
