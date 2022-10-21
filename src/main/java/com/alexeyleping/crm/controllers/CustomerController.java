package com.alexeyleping.crm.controllers;


import com.alexeyleping.crm.controllers.dto.CustomerDto;
import com.alexeyleping.crm.controllers.dto.ReturnCustomerDto;
import com.alexeyleping.crm.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private  final CustomerService customerService;

    public CustomerController(CustomerService webService) {
        this.customerService = webService;
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
    public String updateCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }
}