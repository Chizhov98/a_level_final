package com.example.back_end.persistence.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "listener")
public class Listener extends AbstracktUser{
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> course;
}
