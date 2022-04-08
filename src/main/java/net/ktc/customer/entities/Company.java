package net.ktc.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
//@PrimaryKeyJoinColumn(name = "id")
public class Company extends Customer{
    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String raisonSocial;
    private String registreCommerce;
    private String slogan;
}
