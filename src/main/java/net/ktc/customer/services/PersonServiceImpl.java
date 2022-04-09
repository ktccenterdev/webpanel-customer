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
    public PersonResponseDTO save(PersonRequestDTO personRequestDTO) {
        try {
            Person person = personMapper.personRequestDTOPerson(personRequestDTO);
            Person personSaved = personRepository.save(person);

            PersonResponseDTO personResponseDTO = personMapper.personToPersonResponseDTO(personSaved);
            return personResponseDTO;
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public PersonResponseDTO getOne(String id) {
        try {
            Person person = personRepository.findById(id).get();
            return personMapper.personToPersonResponseDTO(person);
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }

    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personRequestDTO) {
        try {
            Person person = personMapper.personRequestDTOPerson(personRequestDTO);
            Person personUpdated = personRepository.save(person);
            return personMapper.personToPersonResponseDTO(personUpdated);
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }

    }

    @Override
    public List<PersonResponseDTO> getAll() {
        try {
            List<Person> persons = personRepository.findAll();
            List<PersonResponseDTO> personResponseDTOS = persons.stream()
                    .map(pers->personMapper.personToPersonResponseDTO(pers))
                    .collect(Collectors.toList());
            return personResponseDTOS;
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(String id){
        try {
            personRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
