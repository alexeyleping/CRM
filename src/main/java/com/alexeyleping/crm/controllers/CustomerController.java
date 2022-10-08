package com.alexeyleping.crm.controllers;


import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private  final CustomerService webService;

    public CustomerController(CustomerService webService) {
        this.webService = webService;
    }

    @GetMapping("/")
    public String welcome() {
        return "Hello!";
    }

    @GetMapping("/getCustomerId{id}")
    public List<Customer> showCustomerList() {
        return webService.getAllCustomer();
    }

}