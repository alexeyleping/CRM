package com.alexeyleping.crm.controllers;


import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.entity.User;
import com.alexeyleping.crm.service.WebService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerWebController {
    private  final WebService webService;

    public CustomerWebController(WebService webService) {
        this.webService = webService;
    }

    @GetMapping("/")
    public String welcome() {
        return "Hello!";
    }

    @GetMapping("/showCustomer")
    public List<Customer> showCustomerList() {
        return webService.getAllCustomer();
    }

    @GetMapping("/showUsers")
    public List<User> showUsersList() {
        return webService.getAllUser();
    }

    @GetMapping("/createApplication{id, owner}")
    public void createApplication() {}

}