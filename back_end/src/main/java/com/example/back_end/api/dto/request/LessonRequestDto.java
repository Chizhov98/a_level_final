package com.example.back_end.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LessonRequestDto implements RequestDto {
    private Date startDate;
    private String title;
    private int hours;


}
