package com.example.back_end.persistence.entity;

import lombok.Getter;


@Getter
public enum Role {
    SPEAKER("Speaker"),
    LISTENER("Listener");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }
}
