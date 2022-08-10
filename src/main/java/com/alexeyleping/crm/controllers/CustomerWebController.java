package com.alexeyleping.crm.controllers;


import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.repository.CustomerRepository;
import com.alexeyleping.crm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerWebController {
    private  final CustomerService customerService;

    public CustomerWebController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customers", customerService.getAllCustomer());
        model.addAttribute("customer", customer);
        return "index";
    }
}