package pl.kotzur.zast.model.dto;

import pl.kotzur.zast.model.entity.Role;

import java.util.Collection;

public record PersonFullDto(

        Long id,

        String lastName,

        String firstName,

        String secondName,

        String shortName,

        Collection<Role> roles

) {
}
