package com.example.back_end.service;

import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Roles;
import com.example.back_end.persistence.entity.User;

import java.util.List;

public interface UserService extends CrudService<User> {
    List<User> findAllByRole(Roles role);

    List<User> findAllByRoleAndCourse(Roles role, Long curse_id);
}
