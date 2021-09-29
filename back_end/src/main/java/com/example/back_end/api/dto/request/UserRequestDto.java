package com.example.back_end.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public abstract class UserRequestDto implements RequestDto{
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDay;
    private List<Long> courses_id;
    private String password;
}
