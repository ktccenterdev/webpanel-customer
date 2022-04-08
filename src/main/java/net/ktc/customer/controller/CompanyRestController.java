package net.ktc.customer.controller;

import net.ktc.customer.dto.CompanyRequestDTO;
import net.ktc.customer.dto.CompanyResponseDTO;
import net.ktc.customer.dto.CustomerRequestDTO;
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

    @GetMapping(path = "/companies")
    public List<CompanyResponseDTO> allCompany(){
        return companyService.listCompany();
    }

    @PostMapping(path = "/company")
    public CompanyResponseDTO save(CompanyRequestDTO companyRequestDTO){
        return companyService.saveCompany(companyRequestDTO);
    }
    @GetMapping(path = "/company/{id}")
    public CompanyResponseDTO getCompany(@PathVariable String id) {
        return companyService.getCompany(id);
    }
    @PutMapping(path = "/company/{id}")
    public CustomerResponseDTO updatedCustomer(CompanyRequestDTO companyRequestDTO){
        return companyService.updateCompany(companyRequestDTO);
    }
}
