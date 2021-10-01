package com.example.back_end.persistence.repository;

import com.example.back_end.persistence.entity.Role;
import com.example.back_end.persistence.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByTitle(Role title);
}
