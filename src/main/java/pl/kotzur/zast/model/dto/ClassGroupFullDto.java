package pl.kotzur.zast.model.dto;

import org.hibernate.validator.constraints.Length;
import pl.kotzur.zast.util.ClassGroupTypeEnum;

public record ClassGroupFullDto(

        Long id,

        int level,

        @Length(min = 1, max = 10)
        String symbol,

        ClassGroupTypeEnum type,

        boolean active,

        int duration

) {
}
