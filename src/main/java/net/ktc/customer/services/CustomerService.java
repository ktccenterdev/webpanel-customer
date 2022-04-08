package net.ktc.customer.services;

import net.ktc.customer.dto.CustomerRequestDTO;
import net.ktc.customer.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();
}
