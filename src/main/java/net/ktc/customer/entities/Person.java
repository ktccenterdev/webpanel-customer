package net.ktc.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
//@PrimaryKeyJoinColumn(name = "id")
public class Person extends Customer{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    //@Column(nullable = false, unique = true)
    private String id;
    private String lastName;
    //@Column(nullable = false, length = 9)
    private String sexe;
    private String CNI;
}
