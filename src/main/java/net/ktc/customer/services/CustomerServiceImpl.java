package net.ktc.customer.services;

import net.ktc.customer.dto.CustomerRequestDTO;
import net.ktc.customer.dto.CustomerResponseDTO;
import net.ktc.customer.entities.Customer;
import net.ktc.customer.mapper.CustomerMapper;
import net.ktc.customer.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        try {
            Customer customer = customerMapper.customerRequesteDTOCustomer(customerRequestDTO);
            customer.setId(UUID.randomUUID().toString());

            Customer saveCustomer = customerRepository.save(customer);
            CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(saveCustomer);

            return customerResponseDTO;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Erreur lors de la Création du Client",e);
        }
    }

    @Override
    public CustomerResponseDTO getOne(String id) {
        try {
            Customer customer = customerRepository.findById(id).get();
            return customerMapper.customerToCustomerResponseDTO(customer);
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        try {
            Customer customer=customerMapper.customerRequesteDTOCustomer(customerRequestDTO);
            Customer updatedCustomer = customerRepository.save(customer);
            return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }

    }

    @Override
    public List<CustomerResponseDTO> getAll() {
        try {
            List<Customer> customers=customerRepository.findAll();
            List<CustomerResponseDTO> customerResponseDTOS =
                    customers.stream()
                            .map(cust->customerMapper.customerToCustomerResponseDTO(cust))
                            .collect(Collectors.toList());
            return customerResponseDTOS;
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }

    }

    @Override
    public void delete(String id) throws ResponseStatusException {
        try {
            customerRepository.deleteById(id);

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Erreur lors de la suppression",e);
        }
    }
}
