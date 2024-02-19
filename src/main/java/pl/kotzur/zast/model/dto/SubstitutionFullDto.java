package pl.kotzur.zast.model.dto;

import java.time.LocalDate;

public record SubstitutionFullDto(

        Long id,

        LocalDate substitutionDate,

        Long absentTeacherId,

        Long hourId,

        Long classId,

        Long originalSubjectId,

        Long substituteTeacherId,

        Long targetSubjectId

) {
}
