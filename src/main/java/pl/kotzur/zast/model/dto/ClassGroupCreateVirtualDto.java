package pl.kotzur.zast.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;

public record ClassGroupCreateVirtualDto(

        @Min(1)
        @Max(8)
        int level,

        @Length(min = 1, max = 10)
        String symbol

) {
}
