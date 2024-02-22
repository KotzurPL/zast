package pl.kotzur.zast.mapper;

import pl.kotzur.zast.model.dto.ClassGroupForListDto;
import pl.kotzur.zast.model.dto.HourForListDto;
import pl.kotzur.zast.model.entity.Hour;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class HourMapper {

    private HourMapper() {
    }

    public static List<HourForListDto> toListDto(List<Hour> hours) {
        return hours
                .stream()
                .map(hour -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    return new HourForListDto(
                            hour.getId(),
                            hour.getStartTime().format(formatter),
                            hour.getEndTime().format(formatter)
                    );
                })
                .collect(Collectors.toList());
    }

}
