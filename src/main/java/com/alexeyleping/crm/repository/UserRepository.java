package com.alexeyleping.crm.repository;

import com.alexeyleping.crm.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<AppUser, UUID> {
    AppUser findByUsername(String username);
}
