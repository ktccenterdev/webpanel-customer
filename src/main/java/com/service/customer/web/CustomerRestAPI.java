package com.service.customer.web;

import com.service.customer.dto.CustomerRequestDTO;
import com.service.customer.dto.CustomerResponseDTO;
import com.service.customer.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/api")
public class CustomerRestAPI {
    private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {

        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return  customerService.listCustomer();
    }

    @GetMapping(path="/customers/{id}")
    public CustomerResponseDTO getOneCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }


    @PutMapping(path="/customers")
    public CustomerResponseDTO update(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.update(customerRequestDTO);
    }

    @PostMapping(path="/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }
    @DeleteMapping(path="/customers")
    public void  delete(@PathVariable String id){
        customerService.delete(id);
    }

}
