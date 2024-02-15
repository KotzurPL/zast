package pl.kotzur.zast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.kotzur.zast.model.entity.Person;
import pl.kotzur.zast.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private static final int PAGE_SIZE = 8;
    private final PersonRepository personRepository;

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getSinglePerson(Long id) {
        return personRepository.getReferenceById(id);
    }

    public List<Person> getTeachers(int page, Sort.Direction sort) {

        return personRepository.findTeachers(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "last_name")));

    }
}
