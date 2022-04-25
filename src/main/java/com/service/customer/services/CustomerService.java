package com.service.customer.services;

import com.service.customer.dto.CustomerRequestDTO;
import com.service.customer.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    void delete(String id);
    List<CustomerResponseDTO> listCustomer();
}
