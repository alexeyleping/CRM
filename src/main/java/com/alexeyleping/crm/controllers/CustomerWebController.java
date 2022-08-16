package com.alexeyleping.crm.controllers;


import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.repository.CustomerRepository;
import com.alexeyleping.crm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerWebController {
    private  final CustomerService customerService;

    public CustomerWebController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String welcome() {
        return "Hello!";
    }

    @GetMapping("/show")
    public List<Customer> showCustomerList() {
        return customerService.getAllCustomer();
    }


}