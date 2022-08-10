package com.alexeyleping.crm.service;

import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.filters.CustomerDataBaseFilter;
import com.alexeyleping.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CustomerService {
    private  final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
}
