package net.ktc.customer.services;

import net.ktc.customer.dto.PersonRequestDTO;
import net.ktc.customer.dto.PersonResponseDTO;

import java.util.List;

public interface PersonService{
    PersonResponseDTO savePerson(PersonRequestDTO personRequestDTO);
    PersonResponseDTO getPerson(String id);
    PersonResponseDTO updatePerson(PersonRequestDTO personRequestDTO);
    List<PersonResponseDTO> listPerson();
}
