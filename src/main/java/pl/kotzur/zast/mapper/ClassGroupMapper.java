package pl.kotzur.zast.mapper;

import pl.kotzur.zast.model.dto.ClassGroupCreateVirtualDto;
import pl.kotzur.zast.model.dto.ClassGroupForListDto;
import pl.kotzur.zast.model.dto.ClassGroupCreateDto;
import pl.kotzur.zast.model.dto.ClassGroupFullDto;
import pl.kotzur.zast.model.entity.ClassGroup;
import pl.kotzur.zast.util.ClassGroupTypeEnum;

import java.util.List;
import java.util.stream.Collectors;

public class ClassGroupMapper {

    private ClassGroupMapper() {
    }

    public static List<ClassGroupForListDto> toListDto(List<ClassGroup> classes) {
        return classes
                .stream()
                .map(classGroup -> new ClassGroupForListDto(classGroup.getId(), classGroup.nameToString()))
                .collect(Collectors.toList());
    }

    public static ClassGroup toEntityCreate(ClassGroupCreateDto dto) {
        ClassGroup newClassGroup = new ClassGroup();
        newClassGroup.setLevel(dto.level());
        newClassGroup.setSymbol(dto.symbol());
        newClassGroup.setType(dto.type());
        newClassGroup.setActive(dto.active());
        newClassGroup.setDuration(dto.duration());
        return newClassGroup;
    }

    public static ClassGroup toEntityCreateVirtual(ClassGroupCreateVirtualDto dto) {
        ClassGroup newClassGroup = new ClassGroup();
        newClassGroup.setLevel(dto.level());
        newClassGroup.setSymbol(dto.symbol());
        newClassGroup.setType(ClassGroupTypeEnum.W);
        newClassGroup.setActive(true);
        newClassGroup.setDuration(4);
        return newClassGroup;
    }

    public static ClassGroup toEntityFull(ClassGroupFullDto dto) {
        ClassGroup newClassGroup = new ClassGroup();
        newClassGroup.setId(dto.id());
        newClassGroup.setLevel(dto.level());
        newClassGroup.setSymbol(dto.symbol());
        newClassGroup.setType(dto.type());
        newClassGroup.setActive(dto.active());
        newClassGroup.setDuration(dto.duration());
        return newClassGroup;
    }

    public static ClassGroupFullDto toFullDto(ClassGroup classGroup) {
        return new ClassGroupFullDto(
                classGroup.getId(),
                classGroup.getLevel(),
                classGroup.getSymbol(),
                classGroup.getType(),
                classGroup.isActive(),
                classGroup.getDuration()
                );
    }

}
