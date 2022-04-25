package net.ktc.customer.mapper;

import net.ktc.customer.dto.CustomerRequestDTO;
import net.ktc.customer.dto.CustomerResponseDTO;
import net.ktc.customer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequesteDTOCustomer(CustomerRequestDTO customerRequestDTO);
}
