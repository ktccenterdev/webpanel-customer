package net.ktc.customer.services;

import net.ktc.customer.dto.CompanyRequestDTO;
import net.ktc.customer.dto.CompanyResponseDTO;

import java.util.List;

public interface CompanyService {
    CompanyResponseDTO saveCompany(CompanyRequestDTO companyRequestDTO);
    CompanyResponseDTO getCompany(String id);
    CompanyResponseDTO updateCompany(CompanyRequestDTO companyRequestDTO);
    List<CompanyResponseDTO> listCompany();
}
