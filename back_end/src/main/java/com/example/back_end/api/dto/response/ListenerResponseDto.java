package com.example.back_end.api.dto.response;

import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Listener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListenerResponseDto extends UserResponseDto {
    private List<Course> course;

    public ListenerResponseDto(Listener listener) {
        BeanUtils.copyProperties(listener, this);
    }
}
