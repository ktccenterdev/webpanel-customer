package net.ktc.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class PersonResponseDTO extends CustomerResponseDTO{
    private String id;
    private String lastName;
    private String sexe;
    private String CNI;
}
