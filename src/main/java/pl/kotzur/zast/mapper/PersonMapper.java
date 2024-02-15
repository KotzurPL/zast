package pl.kotzur.zast.mapper;

import pl.kotzur.zast.model.dto.PersonForListDto;
import pl.kotzur.zast.model.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {

    private PersonMapper() {
    }

    public static List<PersonForListDto> toListDto(List<Person> persons) {
        return persons
                .stream()
                .map(person -> new PersonForListDto(
                        person.getId(),
                        person.getLastName(),
                        person.getFirstName(),
                        person.getShortName()
                ))
                .collect(Collectors.toList());
    }

}
