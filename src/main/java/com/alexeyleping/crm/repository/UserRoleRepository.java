package com.alexeyleping.crm.repository;

import com.alexeyleping.crm.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<AppRole, UUID> {
}
