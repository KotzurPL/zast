package pl.kotzur.zast.model.dto;

import pl.kotzur.zast.util.ClassGroupTypeEnum;

public record ClassGroupFullDto(Long id, int level, String symbol, ClassGroupTypeEnum type, boolean active, int duration) {
}
