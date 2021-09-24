package com.example.back_end.persistence.repository;

import com.example.back_end.persistence.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
