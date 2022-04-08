package net.ktc.customer.services;

import net.ktc.customer.dto.PersonRequestDTO;
import net.ktc.customer.dto.PersonResponseDTO;
import net.ktc.customer.entities.Person;
import net.ktc.customer.mapper.PersonMapper;
import net.ktc.customer.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private PersonMapper personMapper;
    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public PersonResponseDTO savePerson(PersonRequestDTO personRequestDTO) {
        Person person = personMapper.personRequestDTOPerson(personRequestDTO);
        Person personSaved = personRepository.save(person);

        PersonResponseDTO personResponseDTO = personMapper.personToPersonResponseDTO(personSaved);
        return personResponseDTO;
    }

    @Override
    public PersonResponseDTO getPerson(String id) {
        Person person = personRepository.findById(id).get();
        return personMapper.personToPersonResponseDTO(person);
    }

    @Override
    public PersonResponseDTO updatePerson(PersonRequestDTO personRequestDTO) {
        Person person = personMapper.personRequestDTOPerson(personRequestDTO);
        Person personUpdated = personRepository.save(person);
        return personMapper.personToPersonResponseDTO(personUpdated);
    }

    @Override
    public List<PersonResponseDTO> listPerson() {
        List<Person> persons = personRepository.findAll();
        List<PersonResponseDTO> personResponseDTOS = persons.stream()
                .map(pers->personMapper.personToPersonResponseDTO(pers))
                .collect(Collectors.toList());
        return personResponseDTOS;
    }
}
