package net.ktc.customer.controller;

import net.ktc.customer.dto.CompanyRequestDTO;
import net.ktc.customer.dto.CompanyResponseDTO;
import net.ktc.customer.dto.CustomerResponseDTO;
import net.ktc.customer.services.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class CompanyRestController {
    private CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(path = "/company")
    public CompanyResponseDTO save(@RequestBody CompanyRequestDTO companyRequestDTO){
        return companyService.save(companyRequestDTO);
    }
    @GetMapping(path = "/company/{id}")
    public CompanyResponseDTO getCompany(@PathVariable(name = "id") String id) {
        return companyService.getOne(id);
    }

    @GetMapping(path = "/company")
    public List<CompanyResponseDTO> allCompany(){
        return companyService.getAll();
    }

    @PutMapping(path = "/company/{id}")
    public CustomerResponseDTO updatedCustomer(@RequestBody CompanyRequestDTO companyRequestDTO){
        return companyService.update(companyRequestDTO);
    }
    @DeleteMapping(path = "/company/{id}")
    public void delete(@PathVariable(name = "id") String id){
        companyService.delete(id);
    }
}
