package com.example.back_end.persistence.repository;

import com.example.back_end.persistence.entity.AbstracktUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepository<E extends AbstracktUser> extends JpaRepository<E, Long> {
    boolean existByEmail(String email);
}