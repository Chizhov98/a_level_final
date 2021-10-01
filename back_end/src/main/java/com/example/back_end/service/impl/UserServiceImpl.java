package com.example.back_end.service.impl;

import com.example.back_end.exeption.RestBadRequestException;
import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Roles;
import com.example.back_end.persistence.entity.User;
import com.example.back_end.persistence.repository.CourseRepository;
import com.example.back_end.persistence.repository.RoleRepository;
import com.example.back_end.persistence.repository.UserRepository;
import com.example.back_end.service.CourseService;
import com.example.back_end.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final CourseService courseService;

    public UserServiceImpl(UserRepository repository, CourseService courseService) {
        this.repository = repository;
        this.courseService = courseService;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(User user) {
        if (!repository.existsById(user.getId())) {
            repository.save(user);
        } else throw new RestBadRequestException("This user is already exist");
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(User user) {
        if (repository.existsById(user.getId())) {
            repository.save(user);
        } else throw new RestBadRequestException("This user not exist");
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new RestBadRequestException("This user not exist");
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestBadRequestException("This user not exist"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllByRole(Roles role) {
        return repository.findAllByRole(role);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllByRoleAndCourse(Roles role, Long course) {
        return repository.findAllByRoleAndCourse(role, courseService.findById(course));
    }
}
