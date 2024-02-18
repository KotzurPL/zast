package pl.kotzur.zast.mapper;

import pl.kotzur.zast.model.dto.SubstitutionForListDto;
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
                            substitution.getHour().toStringForSubstitutionList(),
                            substitution.getClassGroup().nameToString(),
                            teachersToString(substitution),
                            subjectsToString(substitution)
                    )
                )
                .collect(Collectors.toList());
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
