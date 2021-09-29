package com.example.back_end.persistence.entity;

import com.example.back_end.persistence.listener.AgeEntityListener;
import com.example.back_end.persistence.listener.FullNameEntityListener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({
        FullNameEntityListener.class,
        AgeEntityListener.class
})
public abstract class AbstracktUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", nullable = false, updatable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time", nullable = false)
    private Date updated;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "birth_day")
    private Date birthDay;
    @Column(nullable = false)
    private String password;
    @Transient
    private String fullName;

    @Transient
    private Integer age;

    public AbstracktUser() {
        this.created = new Date();
        this.updated = new Date();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updated = new Date();
    }

}
