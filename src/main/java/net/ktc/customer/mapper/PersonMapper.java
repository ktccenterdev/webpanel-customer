package net.ktc.customer.mapper;

import net.ktc.customer.dto.PersonRequestDTO;
import net.ktc.customer.dto.PersonResponseDTO;
import net.ktc.customer.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonResponseDTO personToPersonResponseDTO(Person person);
    Person personRequestDTOPerson(PersonRequestDTO personRequestDTO);
}
