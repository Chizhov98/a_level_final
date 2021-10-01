package com.example.back_end.persistence.listener;

import com.example.back_end.persistence.entity.User;
import org.apache.commons.lang.StringUtils;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PreUpdate;

public class FullNameEntityListener {

    @PostLoad
    @PostPersist
    @PreUpdate
    public void generateFullName(User user) {
        if (StringUtils.isNotBlank(user.getFirstName()) && StringUtils.isNotBlank(user.getLastName())) {
            user.setFullName(user.getFirstName() + " " + user.getLastName());
        }
    }
}