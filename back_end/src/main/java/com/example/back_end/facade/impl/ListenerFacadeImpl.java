package com.example.back_end.facade.impl;

import com.example.back_end.api.dto.request.ListenerRequestDto;
import com.example.back_end.api.dto.response.ListenerResponseDto;
import com.example.back_end.facade.ListenerFacade;
import com.example.back_end.persistence.entity.Listener;
import com.example.back_end.service.ListenerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListenerFacadeImpl implements ListenerFacade {
    private final ListenerService listenerService;

    public ListenerFacadeImpl(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @Override
    public void create(ListenerRequestDto listenerRequestDto) {
        Listener listener = new Listener();
        BeanUtils.copyProperties(listenerRequestDto, listener);
        listenerService.create(listener);
    }

    @Override
    public void update(Long id, ListenerRequestDto listenerRequestDto) {

        Listener listener = listenerService.findById(id);
        BeanUtils.copyProperties(listenerRequestDto, listener);
        listenerService.update(listener);
    }

    @Override
    public void delete(Long id) {
        listenerService.delete(id);
    }

    @Override
    public ListenerResponseDto findById(Long id) {
        return new ListenerResponseDto(listenerService.findById(id));
    }

    @Override
    public List<ListenerResponseDto> findAll() {
        return listenerService.findAll().stream().map(ListenerResponseDto::new).collect(Collectors.toList());
    }
}
