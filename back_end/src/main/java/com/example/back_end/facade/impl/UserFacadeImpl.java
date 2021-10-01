package com.example.back_end.facade.impl;

import com.example.back_end.api.dto.request.UserRequestDto;
import com.example.back_end.api.dto.response.UserResponseDto;
import com.example.back_end.facade.UserFacade;
import com.example.back_end.persistence.entity.Role;
import com.example.back_end.persistence.entity.User;
import com.example.back_end.service.RoleService;
import com.example.back_end.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFacadeImpl implements UserFacade {
    private final UserService service;
    private final RoleService roleService;

    public UserFacadeImpl(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @Override
    public void create(UserRequestDto userRequestDto) {
        User user = new User();
        BeanUtils.copyProperties(userRequestDto, user);
        service.create(user);
    }

    @Override
    public void update(Long id, UserRequestDto userRequestDto) {
        User user = new User();
        BeanUtils.copyProperties(userRequestDto, user);
        service.update(user);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public UserResponseDto findById(Long id) {
        return new UserResponseDto(service.findById(id));
    }

    @Override
    public List<UserResponseDto> findAll() {
        return service.findAll().stream().map(UserResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public List<UserResponseDto> findAllSpeakers() {
        return service.findAllByRole(roleService.findByTitle(Role.SPEAKER)).stream().map(UserResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public List<UserResponseDto> findAllListeners(Long course_id) {
        return service.findAllByRoleAndCourse(roleService.findByTitle(Role.SPEAKER), course_id).stream().map(UserResponseDto::new).collect(Collectors.toList());
    }
}
