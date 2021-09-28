package com.example.back_end.facade.impl;

import com.example.back_end.api.dto.request.CourseRequestDto;
import com.example.back_end.api.dto.response.CourseResponseDto;
import com.example.back_end.facade.CourseFacade;
import com.example.back_end.persistence.entity.Course;
import com.example.back_end.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseFacadeImpl implements CourseFacade {
    private final CourseService courseService;

    public CourseFacadeImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public List<Course> findAllByTitleIsLike(String title) {
        return courseService.findAllByTitleIsLike(title);
    }

    @Override
    public void create(CourseRequestDto courseRequestDto) {
        Course course = new Course();
        BeanUtils.copyProperties(courseRequestDto, course);
        courseService.create(course);
    }

    @Override
    public void update(Long id, CourseRequestDto courseRequestDto) {
        Course course = courseService.findById(id);
        BeanUtils.copyProperties(courseRequestDto, course);
        courseService.update(course);
    }

    @Override
    public void delete(Long id) {
        courseService.delete(id);
    }

    @Override
    public CourseResponseDto findById(Long id) {
        return new CourseResponseDto(courseService.findById(id));
    }

    @Override
    public List<CourseResponseDto> findAll() {
        return courseService.findAll().stream().map(CourseResponseDto::new).collect(Collectors.toList());
    }
}
