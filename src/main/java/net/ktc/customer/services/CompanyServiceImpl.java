package net.ktc.customer.services;

import net.ktc.customer.dto.CompanyRequestDTO;
import net.ktc.customer.dto.CompanyResponseDTO;
import net.ktc.customer.dto.CustomerRequestDTO;
import net.ktc.customer.entities.Company;
import net.ktc.customer.mapper.CompanyMapper;
import net.ktc.customer.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public CompanyResponseDTO saveCompany(CompanyRequestDTO companyRequestDTO) {
        Company company = companyMapper.companyRequestDTOCompany(companyRequestDTO);
        Company savedCompany = companyRepository.save(company);

        CompanyResponseDTO companyResponseDTO = companyMapper.companyToCompanyResponseDTO(savedCompany);
        return companyResponseDTO;
    }

    @Override
    public CompanyResponseDTO getCompany(String id) {
        Company company = companyRepository.findById(id).get();

        return companyMapper.companyToCompanyResponseDTO(company);
    }

    @Override
    public CompanyResponseDTO updateCompany(CompanyRequestDTO companyRequestDTO) {
        Company company = companyMapper.companyRequestDTOCompany(companyRequestDTO);
        Company updatedCompany = companyRepository.save(company);
        return companyMapper.companyToCompanyResponseDTO(updatedCompany);
    }

    @Override
    public List<CompanyResponseDTO> listCompany() {
        List<Company> companys = companyRepository.findAll();
        List<CompanyResponseDTO> companyResponseDTOS=
                companys.stream()
                        .map(comp->companyMapper.companyToCompanyResponseDTO(comp))
                        .collect(Collectors.toList());
        return companyResponseDTOS;
    }
}
