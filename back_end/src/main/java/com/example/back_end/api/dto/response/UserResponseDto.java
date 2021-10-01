package com.example.back_end.api.dto.response;

import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Roles;
import com.example.back_end.persistence.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserResponseDto implements ResponseDto {
    private Date created;
    private Date updated;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDay;
    private String fullName;
    private Integer age;
    private String password;
    private List<Course> course;
    private Roles role;

    public UserResponseDto(User user) {
        BeanUtils.copyProperties(user, this);
    }
}
