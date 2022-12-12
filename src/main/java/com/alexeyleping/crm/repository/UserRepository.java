package com.alexeyleping.crm.repository;

import com.alexeyleping.crm.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByLogin(String login);
}
