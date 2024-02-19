package pl.kotzur.zast.model.dto;

import java.time.LocalDate;

public record SubstitutionCreateDto(

        LocalDate substitutionDate,

        Long absentTeacherId,

        Long hourId,

        Long classId,

        Long substituteTeacherId,

        Long originalSubjectId,

        Long targetSubjectId

) {
}
