package pl.kotzur.zast.model.dto;

import java.time.LocalTime;

public record HourForListDto(

        Long id,

        String startTime,

        String endTime

) {
}
