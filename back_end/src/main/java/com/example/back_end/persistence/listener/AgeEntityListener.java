package com.example.back_end.persistence.listener;
import com.example.back_end.persistence.entity.User;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PreUpdate;

public class AgeEntityListener {

    @PostLoad
    @PostPersist
    @PreUpdate
    public void generateAge( User user) {
        if (user.getBirthDay() != null) {
            Years years = Years.yearsBetween(new LocalDate(user.getBirthDay()), new LocalDate());
            user.setAge(years.getYears());
        }
    }
}

