package pl.kotzur.zast.mapper;

import pl.kotzur.zast.model.dto.SubstitutionCreateDto;
import pl.kotzur.zast.model.dto.SubstitutionForListDto;
import pl.kotzur.zast.model.dto.SubstitutionFullDto;
import pl.kotzur.zast.model.entity.Substitution;

import java.util.List;
import java.util.stream.Collectors;

public class SubstitutionMapper {

    private SubstitutionMapper() {
    }

    public static List<SubstitutionForListDto> toListDto(List<Substitution> substitutions) {

        return substitutions
                .stream()
                .map(substitution -> new SubstitutionForListDto(
                            substitution.getId(),
                            substitution.getSubstitutionDate(),
                            substitution.getHour().toStringForList(),
                            substitution.getClassGroup().nameToString(),
                            teachersToString(substitution),
                            subjectsToString(substitution)
                    )
                )
                .collect(Collectors.toList());
    }

    public static SubstitutionFullDto toFullDto(Substitution substitution) {
        return new SubstitutionFullDto(
                substitution.getId(),
                substitution.getSubstitutionDate(),
                substitution.getAbsentTeacher().getId(),
                substitution.getHour().getId(),
                substitution.getClassGroup().getId(),
                substitution.getOriginalSubject().getId(),
                substitution.getSubstituteTeacher().getId(),
                substitution.getTargetSubject().getId()
        );
    }

    public static Substitution toEntityCreate(SubstitutionCreateDto dto) {
        Substitution newSubstitution = new Substitution();

        return newSubstitution;
    }

    private static String teachersToString(Substitution substitution) {
        String result = "";
        result += substitution.getAbsentTeacher().getShortName();
        result += " -> ";
        result += substitution.getSubstituteTeacher().getShortName();
        return result;
    }

    private static String subjectsToString(Substitution substitution) {
        String originalSubject = substitution.getOriginalSubject().getShortName();
        String targetSubject = substitution.getTargetSubject().getShortName();
        String result = "";
        if (originalSubject.equals(targetSubject)) {
            result += "bez zmian";
        } else {
            result += substitution.getOriginalSubject().getShortName();
            result += " -> ";
            result += substitution.getTargetSubject().getShortName();
        }
        return result;
    }

}
