package com.example.back_end.persistence.entity;

import com.example.back_end.persistence.listener.AgeEntityListener;
import com.example.back_end.persistence.listener.FullNameEntityListener;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@EntityListeners({
        FullNameEntityListener.class,
        AgeEntityListener.class
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "birth_day")
    private Date birthDay;

    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    private String fullName;

    @Transient
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    private Roles role;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> course;

    public User() {
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updated = new Date();
    }
}
