package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.CustomerDto;
import com.alexeyleping.crm.controllers.dto.ReturnCustomerDto;
import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private  final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public ReturnCustomerDto getCustomer(UUID id){
        Optional<Customer> customer = customerRepository.findById(id);
        ReturnCustomerDto returnCustomerDto = new ReturnCustomerDto(
                customer.get().getId(),
                customer.get().getName(),
                customer.get().getCreate(),
                customer.get().getChange(),
                customer.get().getEmail(),
                customer.get().getAddress(),
                customer.get().getCity(),
                customer.get().getCountry(),
                customer.get().getPhone());
        returnCustomerDto.name();
        return returnCustomerDto;
    }

    public String createCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setName(customerDto.name());
        customer.setAddress(customerDto.address());
        customer.setCity(customerDto.city());
        customer.setCountry(customerDto.country());
        customer.setEmail(customerDto.email());
        customer.setPhone(customerDto.phone());
        customer.setCreate(LocalDate.now());
        customerRepository.save(customer);
        return "200 OK";
    }

    public String updateCustomer(CustomerDto customerDto){
        Customer customer = customerRepository.getReferenceById(customerDto.id());
        if(customerDto.name() != null)
            customer.setName(customerDto.name());
        if(customerDto.change() != null)
            customer.setChange(customerDto.change());
        if(customerDto.create() != null)
            customer.setCreate(customerDto.create());
        if(customerDto.address() != null)
            customer.setAddress(customerDto.address());
        if(customerDto.city() != null)
            customer.setCity(customerDto.city());
        if(customerDto.country() != null)
            customer.setCountry(customerDto.country());
        if(customerDto.phone() != null)
            customer.setPhone(customerDto.phone());
        return "OK. OBJECT UPDATE.";
    }

    public String deleteCustomer(UUID id){
        customerRepository.deleteById(id);
        return "OK. OBJECT DELETE.";
    }
}
