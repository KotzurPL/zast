package pl.kotzur.zast.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import pl.kotzur.zast.util.ClassGroupTypeEnum;

public record ClassGroupCreateDto(

        @Min(1)
        @Max(4)
        int level,

        @NotEmpty
        @Length(min = 1, max = 10)
        String symbol,

        ClassGroupTypeEnum type,

        boolean active,

        @Min(1)
        @Max(8)
        int duration

) {
}
