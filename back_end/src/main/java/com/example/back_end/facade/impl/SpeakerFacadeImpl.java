package com.example.back_end.facade.impl;

import com.example.back_end.api.dto.request.SpeakerRequestDto;
import com.example.back_end.api.dto.response.SpeakerResponseDto;
import com.example.back_end.facade.SpeakerFacade;
import com.example.back_end.persistence.entity.Speaker;
import com.example.back_end.service.SpeakerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class SpeakerFacadeImpl implements SpeakerFacade {
    private final SpeakerService speakerService;

    public SpeakerFacadeImpl(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @Override
    public void create(SpeakerRequestDto speakerRequestDto) {
        Speaker speaker = new Speaker();
        BeanUtils.copyProperties(speakerRequestDto, speaker);
        speakerService.create(speaker);
    }

    @Override
    public void update(Long id, SpeakerRequestDto speakerRequestDto) {
        Speaker speaker = speakerService.findById(id);
        BeanUtils.copyProperties(speakerRequestDto, speaker);
        speakerService.update(speaker);
    }

    @Override
    public void delete(Long id) {
        speakerService.delete(id);
    }

    @Override
    public SpeakerResponseDto findById(Long id) {
        return new SpeakerResponseDto(speakerService.findById(id));
    }

    @Override
    public List<SpeakerResponseDto> findAll() {
        return speakerService.findAll().stream().map(SpeakerResponseDto::new).collect(Collectors.toList());
    }
}
