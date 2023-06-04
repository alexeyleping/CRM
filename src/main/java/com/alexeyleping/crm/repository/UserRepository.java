package com.alexeyleping.crm.repository;

import com.alexeyleping.crm.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<AppUser, UUID> {
    AppUser findByUsername(String username);
}
