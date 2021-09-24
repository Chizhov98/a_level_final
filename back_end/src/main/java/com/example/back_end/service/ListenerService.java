package com.example.back_end.service;

import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Listener;

import java.util.List;

public interface ListenerService extends CrudService<Listener> {
    List<Listener> findAllByCourse(Course course);
}
