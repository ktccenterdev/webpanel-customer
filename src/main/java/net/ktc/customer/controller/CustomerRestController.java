package net.ktc.customer.controller;

import net.ktc.customer.dto.CustomerRequestDTO;
import net.ktc.customer.dto.CustomerResponseDTO;
import net.ktc.customer.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class CustomerRestController {
    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
    }

    @PostMapping(path = "/customer")
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO){
        System.out.print("========================================\n");
        System.out.println(customerRequestDTO);
        System.out.print("========================================\n");
        return customerService.save(customerRequestDTO);
    }

    @GetMapping(path = "/customer/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @PutMapping(path = "/customer/{id}")
    public CustomerResponseDTO updatedCustomer(CustomerRequestDTO customerRequestDTO){
        return customerService.updateCustomer(customerRequestDTO);
    }
}
