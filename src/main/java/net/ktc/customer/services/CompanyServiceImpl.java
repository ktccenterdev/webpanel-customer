package net.ktc.customer.services;

import net.ktc.customer.dto.CompanyRequestDTO;
import net.ktc.customer.dto.CompanyResponseDTO;
import net.ktc.customer.entities.Company;
import net.ktc.customer.mapper.CompanyMapper;
import net.ktc.customer.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
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
    public CompanyResponseDTO save(CompanyRequestDTO companyRequestDTO) {
        try {
            Company company = companyMapper.companyRequestDTOCompany(companyRequestDTO);
            company.setId(UUID.randomUUID().toString());

            Company savedCompany = companyRepository.save(company);

            CompanyResponseDTO companyResponseDTO = companyMapper.companyToCompanyResponseDTO(savedCompany);
            return companyResponseDTO;
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }

    }

    @Override
    public CompanyResponseDTO getOne(String id) {
        try {
            return companyMapper.companyToCompanyResponseDTO(companyRepository.findById(id).get());
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public CompanyResponseDTO update(CompanyRequestDTO companyRequestDTO) {
        try {
            Company company = companyMapper.companyRequestDTOCompany(companyRequestDTO);
            Company updatedCompany = companyRepository.save(company);
            return companyMapper.companyToCompanyResponseDTO(updatedCompany);
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }

    }

    @Override
    public List<CompanyResponseDTO> getAll() {
        try {
            List<Company> companys = companyRepository.findAll();
            List<CompanyResponseDTO> companyResponseDTOS=
                    companys.stream()
                            .map(comp->companyMapper.companyToCompanyResponseDTO(comp))
                            .collect(Collectors.toList());
            return companyResponseDTOS;
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(String id){
        try {
            companyRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }

    }
}
