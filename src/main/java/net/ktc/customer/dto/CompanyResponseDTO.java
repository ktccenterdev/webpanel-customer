package net.ktc.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CompanyResponseDTO extends CustomerResponseDTO{
    private String id;
    private String raisonSocial;
    private String registreCommerce;
    private String slogan;
}
