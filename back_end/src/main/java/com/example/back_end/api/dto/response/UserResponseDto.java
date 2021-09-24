package com.example.back_end.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class UserResponseDto implements ResponseDto {
    private Date created;
    private Date updated;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDay;
    private String fullName;
    private Integer age;
}
