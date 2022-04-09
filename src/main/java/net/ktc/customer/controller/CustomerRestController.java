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

    @PostMapping(path = "/customer")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
    }

    @GetMapping(path = "/customer/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable(name = "id") String id){
        return customerService.getOne(id);
    }

    @GetMapping(path = "/customer")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.getAll();
    }
    @PutMapping(path = "/customer/{id}")
    public CustomerResponseDTO updatedCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.update(customerRequestDTO);
    }

    @DeleteMapping(path = "/customer/{id}")
    public void delete(@PathVariable(name = "id") String id){
        customerService.delete(id);
    }
}
