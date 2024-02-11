package pl.kotzur.zast.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kotzur.zast.model.entity.Person;
import pl.kotzur.zast.model.entity.Role;
import pl.kotzur.zast.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    public Person getSinglePerson(@PathVariable Long id) {
        return personService.getSinglePerson(id);
    }

}
