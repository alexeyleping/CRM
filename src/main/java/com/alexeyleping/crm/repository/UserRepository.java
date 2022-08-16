package com.alexeyleping.crm.repository;

import com.alexeyleping.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
