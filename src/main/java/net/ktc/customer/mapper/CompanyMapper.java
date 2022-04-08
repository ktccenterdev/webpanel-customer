package net.ktc.customer.mapper;

import net.ktc.customer.dto.CompanyRequestDTO;
import net.ktc.customer.dto.CompanyResponseDTO;
import net.ktc.customer.entities.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyResponseDTO companyToCompanyResponseDTO(Company company);
    Company companyRequestDTOCompany(CompanyRequestDTO companyRequestDTO);
}
