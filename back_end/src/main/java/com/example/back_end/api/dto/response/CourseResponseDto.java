package com.example.back_end.api.dto.response;


import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Lesson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CourseResponseDto implements ResponseDto{
    private String title;
    private int durationInHours;
    List<Lesson> lessons;

    public CourseResponseDto(Course course) {
        BeanUtils.copyProperties(course, this);
    }
}
