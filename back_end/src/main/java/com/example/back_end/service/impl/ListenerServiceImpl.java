package com.example.back_end.service.impl;

import com.example.back_end.exeptiom.RestBadRequestException;
import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Listener;
import com.example.back_end.persistence.repository.ListenerRepository;
import com.example.back_end.persistence.repository.SpeakerRepository;
import com.example.back_end.service.ListenerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListenerServiceImpl implements ListenerService {
    ListenerRepository repository;
    SpeakerRepository speakerRepository;

    public ListenerServiceImpl(SpeakerRepository speakerRepository, ListenerRepository repository) {
        this.repository = repository;
        this.speakerRepository = speakerRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void create(Listener listener) {
        if (!repository.existByEmail(listener.getEmail()) && !speakerRepository.existByEmail(listener.getEmail()))
            repository.save(listener);
        else throw new RestBadRequestException("User with this email is already exist ");
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(Listener listener) {
        repository.save(listener);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public Listener findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestBadRequestException("This listener is not exist"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Listener> findAll() {
        return repository.findAll();
    }


    @Transactional(readOnly = true)
    @Override
    public List<Listener> findAllByCourse(Course course) {
        return null;
    }
}
