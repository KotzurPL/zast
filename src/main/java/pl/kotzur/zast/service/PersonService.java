package pl.kotzur.zast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kotzur.zast.model.entity.Person;
import pl.kotzur.zast.model.entity.Subject;
import pl.kotzur.zast.repository.PersonRepository;
import pl.kotzur.zast.repository.SubjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getSinglePerson(Long id) {
        return personRepository.getReferenceById(id);
    }

}
