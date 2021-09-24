package com.example.back_end.service.impl;

import com.example.back_end.exeptiom.RestBadRequestException;
import com.example.back_end.persistence.entity.Lesson;
import com.example.back_end.persistence.repository.LessonRepository;
import com.example.back_end.service.LessonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LessonServiceImpl implements LessonService {
    private LessonRepository repository;

    public LessonServiceImpl(LessonRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(Lesson lesson) {
        repository.save(lesson);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(Lesson lesson) {
    repository.save(lesson);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Lesson findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestBadRequestException("This lesson not exist"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lesson> findAll() {
        return repository.findAll();
    }
}
