package com.service.customer.services;

import com.service.customer.dto.CustomerRequestDTO;
import com.service.customer.dto.CustomerResponseDTO;
import com.service.customer.entities.Customer;
import com.service.customer.mappers.CustomerMapper;
import com.service.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        customer.setId(UUID.randomUUID().toString());
        Customer customerSaved = customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(customerSaved);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer customerUpdated = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(customerUpdated);
    }

    @Override
    public void delete(String id) {
        try {
            Customer deleteCustomer = customerRepository.findById(id).get();
            customerRepository.delete(deleteCustomer);
        }catch (Exception e){
            System.out.println(e.getCause());
        }

    }

    @Override
    public List<CustomerResponseDTO> listCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOList =
                customers.stream()
                        .map(customer -> customerMapper.customerToCustomerResponseDTO(customer))
                        .collect(Collectors.toList());
        return customerResponseDTOList;
    }
}
