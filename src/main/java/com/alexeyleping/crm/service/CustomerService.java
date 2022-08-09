package com.alexeyleping.crm.service;

import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.filters.CustomerDataBaseFilter;
import com.alexeyleping.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Page<Customer> getCustomersForDatatable(String queryString, Pageable pageable) {
        CustomerDataBaseFilter customerDatatableFilter = new CustomerDataBaseFilter(queryString);
        return customerRepository.findAll(customerDatatableFilter, pageable);
    }
}
