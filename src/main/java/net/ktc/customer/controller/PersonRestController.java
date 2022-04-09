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

    @PostMapping(path = "/person")
    public PersonResponseDTO save(@RequestBody PersonRequestDTO personRequestDTO){
        return personService.save(personRequestDTO);
    }

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping(path = "/person")
    public List<PersonResponseDTO> allPersons(){
        return personService.getAll();
    }

    @GetMapping(path = "/person/{id}")
    public PersonResponseDTO getPerson(@PathVariable(name = "id") String id){
        return personService.getOne(id);
    }

    @PutMapping(path = "/person")
    public PersonResponseDTO updatePerson(@RequestBody PersonRequestDTO personRequestDTO){
        return personService.update(personRequestDTO);
    }

    @DeleteMapping(path = "/person/{id}")
    public void delete(@PathVariable(name = "id") String id){
        personService.delete(id);
    }
}
