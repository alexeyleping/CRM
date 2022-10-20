package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.CustomerDto;
import com.alexeyleping.crm.controllers.dto.ReturnCustomerDto;
import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.repository.CustomerRepository;
import com.alexeyleping.crm.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private  final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public ReturnCustomerDto getCustomer(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        ReturnCustomerDto returnCustomerDto = new ReturnCustomerDto();
        returnCustomerDto.setName(customer.get().getName());
        return returnCustomerDto;
    }

    public String createCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setCity(customerDto.getCity());
        customer.setCountry(customerDto.getCountry());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        Date timeStamp = Calendar.getInstance().getTime();
        customer.setDateOfCreationCustomer(timeStamp);
        customerRepository.save(customer);
        return "200 OK";
    }

    public String updateCustomer(CustomerDto customerDto){
        Customer customer = customerRepository.getReferenceById(customerDto.getId());
        if(customerDto.getName() != null)
            customer.setName(customerDto.getName());
        if(customerDto.getDateOfChangeCustomer() != null)
            customer.setDateOfChangeCustomer(customerDto.getDateOfChangeCustomer());
        if(customerDto.getDateOfCreationCustomer() != null)
            customer.setDateOfCreationCustomer(customerDto.getDateOfCreationCustomer());
        if(customerDto.getAddress() != null)
            customer.setAddress(customerDto.getAddress());
        if(customerDto.getCity() != null)
            customer.setCity(customerDto.getCity());
        if(customerDto.getCountry() != null)
            customer.setCountry(customerDto.getCountry());
        if(customerDto.getPhoneNumber() != null)
            customer.setPhoneNumber(customerDto.getPhoneNumber());
        return "OK. OBJECT UPDATE.";
    }

    public String deleteCustomer(Long id){
        customerRepository.deleteById(id);
        return "OK. OBJECT DELETE.";
    }
}
