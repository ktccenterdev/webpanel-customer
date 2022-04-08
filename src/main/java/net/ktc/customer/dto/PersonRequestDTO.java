package net.ktc.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor @AllArgsConstructor
public class PersonRequestDTO extends CustomerRequestDTO{
    private String id;
    private String lastName;
    private String sexe;
    private String CNI;
}
