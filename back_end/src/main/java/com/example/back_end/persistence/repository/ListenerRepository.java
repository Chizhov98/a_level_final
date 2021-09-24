package com.example.back_end.persistence.repository;

import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Listener;

import java.util.List;

public interface ListenerRepository extends UserRepository<Listener> {
    List<Listener> findAllByCourse(Course course);
}
