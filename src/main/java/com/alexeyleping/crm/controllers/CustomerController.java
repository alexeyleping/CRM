package com.alexeyleping.crm.controllers;


import com.alexeyleping.crm.controllers.dto.CustomerDto;
import com.alexeyleping.crm.controllers.dto.ReturnCustomerDto;
import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private  final CustomerService customerService;

    public CustomerController(CustomerService webService) {
        this.customerService = webService;
    }

    @GetMapping("/")
    public String welcome() {
        return "Hello!";
    }

    @GetMapping("/getCustomerId{id}")
    public ReturnCustomerDto getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public String createCustomer (@RequestBody CustomerDto customerDto){
        return  customerService.createCustomer(customerDto);
    }
    @PutMapping
    public void updateCustomer(@RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}