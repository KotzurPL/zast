package pl.kotzur.zast.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kotzur.zast.model.dto.ClassGroupCreateVirtualDto;
import pl.kotzur.zast.model.dto.ClassGroupForListDto;
import pl.kotzur.zast.model.dto.ClassGroupCreateDto;
import pl.kotzur.zast.model.dto.ClassGroupFullDto;
import pl.kotzur.zast.model.entity.ClassGroup;
import pl.kotzur.zast.service.ClassGroupService;

import java.util.List;

import static pl.kotzur.zast.mapper.ClassGroupMapper.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classes")
public class ClassGroupController {

    private final ClassGroupService classGroupService;

    @GetMapping
    public List<ClassGroupForListDto> getClassGroups(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.DESC;
        return toListDto(classGroupService.getClassGroups(pageNumber, sortDirection));
    }

    @GetMapping("/{id}")
    public ClassGroup getSingleClassGroup(@PathVariable Long id) {
        return classGroupService.getSingleClassGroup(id);
    }

    @PostMapping
    public ResponseEntity<ClassGroupFullDto> addClassGroup(@RequestBody @Valid ClassGroupCreateDto dto) {
        ClassGroupFullDto response = toDto(classGroupService.addClassGroup(toEntityCreate(dto)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/virtual")
    public ResponseEntity<ClassGroupFullDto> addVirtualClassGroup(@RequestBody @Valid ClassGroupCreateVirtualDto dto) {
        ClassGroupFullDto response = toDto(classGroupService.addClassGroup(toEntityCreateVirtual(dto)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ClassGroupFullDto editClassGroup(@RequestBody @Valid ClassGroupFullDto dto) {
        return toDto(classGroupService.editClassGroup(toEntityFull(dto)));
    }

    @DeleteMapping("/{id}")
    public void deleteClassGroup(@PathVariable Long id) {
        classGroupService.deleteClassGroup(id);
    }

}
