package com.example.back_end.persistence.entity;

import com.example.back_end.persistence.listener.DurationEntityListener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@EntityListeners({
        DurationEntityListener.class
})
@Table(name = "corse")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Transient
    private int durationInHours;

    @OneToMany
    List<Lesson> lessons;
}
