package com.example.back_end.facade;

import com.example.back_end.api.dto.request.CourseRequestDto;
import com.example.back_end.api.dto.response.CourseResponseDto;
import com.example.back_end.persistence.entity.Course;

import java.util.List;

public interface CourseFacade extends CrudFacade<CourseRequestDto, CourseResponseDto> {
    List<Course> findAllByTitleIsLike(String title);
}
