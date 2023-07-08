package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.CustomerDto;
import com.alexeyleping.crm.controllers.dto.ReturnCustomerDto;
import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
public class CustomerService {
    private  final CustomerRepository customerRepository;

    ModelMapper mapper = new ModelMapper();

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public ReturnCustomerDto getCustomer(UUID id){
        Customer customer = customerRepository.findById(id).get();
        ReturnCustomerDto returnCustomerDto = mapper.map(customer, ReturnCustomerDto.class);
        return returnCustomerDto;
    }

    public String createCustomer(CustomerDto customerDto){
        Customer customer = mapper.map(customerDto, Customer.class);
        customer.setCreate(LocalDate.now());
        customer.setChange(LocalDate.now());
        customerRepository.save(customer);
        return "200 OK";
    }

    public String updateCustomer(CustomerDto customerDto){
        Customer customer = customerRepository.getReferenceById(customerDto.id());
        if(!customerDto.address().equals(customer.getAddress()))
            customer.setAddress(customerDto.address());
        if(!customerDto.city().equals(customer.getCity()))
            customer.setCity(customerDto.city());
        if(!customerDto.country().equals(customer.getCountry()))
            customer.setCountry(customerDto.country());
        if(!customerDto.phone().equals(customer.getPhone()))
            customer.setPhone(customerDto.phone());
        return "OK. OBJECT UPDATE.";
    }

    public String deleteCustomer(UUID id){
        customerRepository.deleteById(id);
        return "OK. OBJECT DELETE.";
    }
}
