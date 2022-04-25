package com.service.customer.mappers;

import com.service.customer.dto.CustomerRequestDTO;
import com.service.customer.dto.CustomerResponseDTO;
import com.service.customer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
