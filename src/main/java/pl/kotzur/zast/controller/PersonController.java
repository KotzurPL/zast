package pl.kotzur.zast.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.kotzur.zast.model.dto.PersonForListDto;
import pl.kotzur.zast.model.entity.Person;
import pl.kotzur.zast.service.PersonService;

import java.util.List;

import static pl.kotzur.zast.mapper.PersonMapper.toListDto;

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

    @GetMapping("/teachers")
    public List<PersonForListDto> getTeachers(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return toListDto(personService.getTeachers(pageNumber, sortDirection));
    }

}
