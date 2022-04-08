package net.ktc.customer.controller;

import net.ktc.customer.dto.PersonRequestDTO;
import net.ktc.customer.dto.PersonResponseDTO;
import net.ktc.customer.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class PersonRestController {
    private PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping(path = "/persons")
    public List<PersonResponseDTO> allPersons(){
        return personService.listPerson();
    }

    @PostMapping(path = "/person")
    public PersonResponseDTO save(PersonRequestDTO personRequestDTO){
        return personService.savePerson(personRequestDTO);
    }
    @PutMapping(path = "/person")
    public PersonResponseDTO updatePerson(PersonRequestDTO personRequestDTO){
        return personService.updatePerson(personRequestDTO);
    }

    @GetMapping(path = "/person/{id}")
    public PersonResponseDTO getPerson(@PathVariable String id){
        return personService.getPerson(id);
    }

}
