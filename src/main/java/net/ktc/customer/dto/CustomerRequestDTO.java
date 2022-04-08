package net.ktc.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CustomerRequestDTO {
    private String id;
    private String name;
    private String phoneHome;
    private String phoneWork;
    private String email;
    private String siteWeb;
    private String town;
    private String country;
    private String location;
    private String status;
}
