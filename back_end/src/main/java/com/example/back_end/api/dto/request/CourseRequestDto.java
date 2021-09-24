package com.example.back_end.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseRequestDto  implements RequestDto{
    private String title;
    List<Long> lessons_id;
}
