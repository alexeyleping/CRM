package com.alexeyleping.crm.repository;

import com.alexeyleping.crm.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
