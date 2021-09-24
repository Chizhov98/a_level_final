package com.example.back_end.api.dto.response;

import com.example.back_end.persistence.entity.Lesson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class LessonResponseDto implements ResponseDto{
    private Date startDate;
    private String title;
    private int hours;

    public LessonResponseDto(Lesson lesson) {
        BeanUtils.copyProperties(lesson, this);
    }
}
