package com.example.back_end.service.impl;

import com.example.back_end.exeption.RestBadRequestException;
import com.example.back_end.persistence.entity.Role;
import com.example.back_end.persistence.entity.Roles;
import com.example.back_end.persistence.repository.RoleRepository;
import com.example.back_end.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(Roles roles) {
        if (repository.existsById(roles.getId())) {
            repository.save(roles);
        } else throw new RestBadRequestException("This role is already exist");
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(Roles roles) {
        if (repository.existsById(roles.getId())) {
            repository.save(roles);
        } else throw new RestBadRequestException("This role is not exist");
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new RestBadRequestException("This role is not exist");
    }

    @Override
    @Transactional(readOnly = true)
    public Roles findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestBadRequestException("This role is not exist"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Roles> findAll() {
        return repository.findAll();
    }

    @Override
    public Roles findByTitle(Role title) {
        return repository.findByTitle(title);
    }
}
