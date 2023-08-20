package com.alexeyleping.crm.controllers;


import com.alexeyleping.crm.controllers.dto.CustomerDto;
import com.alexeyleping.crm.controllers.dto.ReturnCustomerDto;
import com.alexeyleping.crm.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private  final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ReturnCustomerDto getCustomer(@PathVariable UUID id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/create")
    public void createCustomer (@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
    }
    @PutMapping("/{id}")
    public void updateCustomer(@RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable UUID id) {
       customerService.deleteCustomer(id);
    }
}