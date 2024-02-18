package pl.kotzur.zast.model.dto;

import java.time.LocalDate;

public record SubstitutionForListDto(

        Long id,

        LocalDate substitutionDate,

        String hour,

        String classGroup,

        String teacher,

        String subject

) {
}
