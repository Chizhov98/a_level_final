package com.example.back_end.facade;

import com.example.back_end.api.dto.request.RequestDto;
import com.example.back_end.api.dto.response.ResponseDto;

import java.util.List;

public interface CrudFacade<REQUEST extends RequestDto, RESPONSE extends ResponseDto> {
    void create(REQUEST request);
    void update(Long id, REQUEST request);
    void delete(Long id);
    RESPONSE findById(Long id);
    List<RESPONSE> findAll();
}
