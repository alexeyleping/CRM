package com.alexeyleping.crm.repository;

import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
