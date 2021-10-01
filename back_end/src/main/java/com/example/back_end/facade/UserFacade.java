package com.example.back_end.facade;

import com.example.back_end.api.dto.request.UserRequestDto;
import com.example.back_end.api.dto.response.UserResponseDto;

import java.util.List;

public interface UserFacade extends CrudFacade<UserRequestDto, UserResponseDto> {
    List<UserResponseDto> findAllSpeakers();

    List<UserResponseDto> findAllListeners(Long course_id);
}
