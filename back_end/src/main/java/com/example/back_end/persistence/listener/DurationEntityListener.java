package com.example.back_end.persistence.listener;

import com.example.back_end.persistence.entity.Course;
import com.example.back_end.persistence.entity.Lesson;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PreUpdate;

public class DurationEntityListener {
    @PostLoad
    @PostPersist
    @PreUpdate
    public void generateDuration(Course course) {
        course.setDurationInHours(course.getLessons()
                .stream().mapToInt(Lesson::getHours).sum());
    }
}
