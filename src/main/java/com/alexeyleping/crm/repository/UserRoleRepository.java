package com.alexeyleping.crm.repository;

import com.alexeyleping.crm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String name);
}
