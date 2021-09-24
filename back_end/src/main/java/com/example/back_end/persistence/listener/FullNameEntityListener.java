package com.example.back_end.persistence.listener;

import com.example.back_end.persistence.entity.AbstracktUser;
import org.apache.commons.lang.StringUtils;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PreUpdate;

public class FullNameEntityListener {

    @PostLoad
    @PostPersist
    @PreUpdate
    public void generateFullName(AbstracktUser user) {
        if (StringUtils.isNotBlank(user.getFirstName()) && StringUtils.isNotBlank(user.getLastName())) {
            user.setFullName(user.getFirstName() + " " + user.getLastName());
        }
    }
}