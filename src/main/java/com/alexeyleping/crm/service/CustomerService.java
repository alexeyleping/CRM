package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.CustomerDto;
import com.alexeyleping.crm.controllers.dto.ReturnCustomerDto;
import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ReturnCustomerDto getCustomer(UUID id) {
        Customer customer = customerRepository.findById(id).get();
        ReturnCustomerDto returnCustomerDto = new ReturnCustomerDto(customer.getId(), customer.getName(), customer.getCreate(), customer.getChange(), customer.getEmail(),
                customer.getAddress(), customer.getCity(), customer.getCountry(), customer.getPhone());
        return returnCustomerDto;
    }

    public void createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.id(), customerDto.name(), customerDto.create(), customerDto.change(), customerDto.email(), customerDto.address(),
                customerDto.city(), customerDto.country(), customerDto.phone());
        customer.setCreate(LocalDate.now());
        customer.setChange(LocalDate.now());
        customerRepository.save(customer);
    }

    public void updateCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.getReferenceById(customerDto.id());
        if (!customerDto.address().equals(customer.getAddress()))
            customer.setAddress(customerDto.address());
        if (!customerDto.city().equals(customer.getCity()))
            customer.setCity(customerDto.city());
        if (!customerDto.country().equals(customer.getCountry()))
            customer.setCountry(customerDto.country());
        if (!customerDto.phone().equals(customer.getPhone()))
            customer.setPhone(customerDto.phone());
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }
}
