package com.alexeyleping.crm.service;

import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.repository.CustomerRepository;
import com.alexeyleping.crm.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CustomerService {
    private  final CustomerRepository customerRepository;
    private  final UserRepository userRepository;
    public CustomerService(CustomerRepository customerRepository, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

}
