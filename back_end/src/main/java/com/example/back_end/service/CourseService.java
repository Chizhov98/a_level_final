package com.example.back_end.service;

import com.example.back_end.persistence.entity.Course;

import java.util.List;

public interface CourseService extends CrudService<Course> {
    List<Course> findAllByTitleIsLike(String title);
}
