package com.example.back_end.facade.impl;

import com.example.back_end.api.dto.request.LessonRequestDto;
import com.example.back_end.api.dto.response.LessonResponseDto;
import com.example.back_end.facade.LessonFacade;
import com.example.back_end.persistence.entity.Lesson;
import com.example.back_end.service.LessonService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LessonFacadeImpl implements LessonFacade {
    private final LessonService lessonService;

    public LessonFacadeImpl(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Override
    public void create(LessonRequestDto lessonRequestDto) {
        Lesson lesson = new Lesson();
        BeanUtils.copyProperties(lessonRequestDto, lesson);
        lessonService.create(lesson);
    }

    @Override
    public void update(Long id, LessonRequestDto lessonRequestDto) {
        Lesson lesson = lessonService.findById(id);
        BeanUtils.copyProperties(lessonRequestDto, lesson);
        lessonService.create(lesson);
    }

    @Override
    public void delete(Long id) {
        lessonService.delete(id);
    }

    @Override
    public LessonResponseDto findById(Long id) {
        return new LessonResponseDto(lessonService.findById(id));
    }

    @Override
    public List<LessonResponseDto> findAll() {
        return lessonService.findAll().stream().map(LessonResponseDto::new).collect(Collectors.toList());
    }
}
