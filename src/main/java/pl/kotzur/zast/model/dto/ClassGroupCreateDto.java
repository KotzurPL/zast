package pl.kotzur.zast.model.dto;

import pl.kotzur.zast.util.ClassGroupTypeEnum;

public record ClassGroupCreateDto(int level, String symbol, ClassGroupTypeEnum type) {
}
