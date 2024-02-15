package pl.kotzur.zast.model.dto;

public record PersonForListDto(

        Long id,

        String lastName,

        String firstName,

        String shortName

) {
}
