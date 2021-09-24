package com.example.back_end.api.dto.response;

import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Speaker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class SpeakerResponseDto extends UserResponseDto{
    private List<Course> course;

    SpeakerResponseDto(Speaker speaker){
        BeanUtils.copyProperties(speaker,this);
    }
}
