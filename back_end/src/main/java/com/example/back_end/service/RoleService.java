package com.example.back_end.service;

import com.example.back_end.persistence.entity.Role;
import com.example.back_end.persistence.entity.Roles;

public interface RoleService extends CrudService<Roles> {
    Roles findByTitle(Role title);
}
