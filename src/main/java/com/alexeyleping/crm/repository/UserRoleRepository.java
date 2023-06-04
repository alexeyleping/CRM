package com.alexeyleping.crm.repository;

import com.alexeyleping.crm.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<AppRole, Long> {
}
