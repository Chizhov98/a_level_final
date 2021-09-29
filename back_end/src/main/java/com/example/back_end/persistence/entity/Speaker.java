package com.example.back_end.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "speaker")
public class Speaker extends AbstracktUser{
    @OneToMany(fetch = FetchType.EAGER)
    private List<Course> course;
}
