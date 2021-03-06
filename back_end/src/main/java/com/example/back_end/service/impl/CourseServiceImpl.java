package com.example.back_end.service.impl;

import com.example.back_end.exeption.RestBadRequestException;
import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.repository.CourseRepository;
import com.example.back_end.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public List<Course> findAllByTitleIsLike(String title) {
        return repository.findAllByTitleIsLike(title);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(Course course) {
        if (!repository.existsById(course.getId())) {
            repository.save(course);
        } else throw new RestBadRequestException("This course is already exist");
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void update(Course course) {
        if (repository.existsById(course.getId())) {
            repository.save(course);
        } else throw new RestBadRequestException("This course is already exist");
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new RestBadRequestException("This course is not exist");
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestBadRequestException("This course is not exist"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return repository.findAll();
    }
}
