package net.ktc.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    //@Column(length = 50, nullable = false)
    private String name;
    //@Column(unique = true, nullable = false)
    private String phoneHome;
    //@Column(unique = true)
    private String phoneWork;
    //@Column(unique = true)
    private String email;
    private String siteWeb;
    //@Column(nullable = false)
    private String town;
    private String country;
    private String location;
    private String status;


}
