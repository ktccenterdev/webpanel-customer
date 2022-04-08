package net.ktc.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CompanyRequestDTO extends CustomerRequestDTO{
    private String id;
    private String raisonSocial;
    private String registreCommerce;
    private String slogan;
}
