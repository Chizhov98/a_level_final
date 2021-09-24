package com.example.back_end.service.impl;

import com.example.back_end.exeptiom.RestBadRequestException;
import com.example.back_end.persistence.entity.Speaker;
import com.example.back_end.persistence.repository.ListenerRepository;
import com.example.back_end.persistence.repository.SpeakerRepository;
import com.example.back_end.service.SpeakerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {
    SpeakerRepository repository;
    ListenerRepository listenerRepository;

    public SpeakerServiceImpl(ListenerRepository listenerRepository, SpeakerRepository repository) {
        this.repository = repository;
        this.listenerRepository = listenerRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void create(Speaker speaker) {
        if (!repository.existByEmail(speaker.getEmail()) && !listenerRepository.existByEmail(speaker.getEmail()))
            repository.save(speaker);
        else throw new RestBadRequestException("User with this email is already exist ");
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(Speaker speaker) {
        repository.save(speaker);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Speaker findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestBadRequestException("This listener is not exist"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Speaker> findAll() {
        return repository.findAll();
    }
}
