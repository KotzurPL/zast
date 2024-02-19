package pl.kotzur.zast.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kotzur.zast.mapper.ClassGroupMapper;
import pl.kotzur.zast.mapper.SubstitutionMapper;
import pl.kotzur.zast.model.dto.*;
import pl.kotzur.zast.service.SubstitutionService;

import java.util.List;

import static pl.kotzur.zast.mapper.SubstitutionMapper.toEntityCreate;
import static pl.kotzur.zast.mapper.SubstitutionMapper.toFullDto;
import static pl.kotzur.zast.mapper.SubstitutionMapper.toListDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/substitutions")
public class SubstitutionController {

    private final SubstitutionService substitutionService;

    @GetMapping
    public List<SubstitutionForListDto> getSubstitutions(@RequestParam(required = false) Integer page, @RequestParam(required = false) Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.DESC;
        return toListDto(substitutionService.getSubstitutions(pageNumber, sortDirection));
    }

    @GetMapping("/{id}")
    public SubstitutionFullDto getSingleSubstitution(@PathVariable Long id) {
        return toFullDto(substitutionService.getSingleSubstitution(id));
    }

    @PostMapping
    public ResponseEntity<SubstitutionFullDto> addSubstitution(@RequestBody @Valid SubstitutionCreateDto dto) {
        SubstitutionFullDto response = SubstitutionMapper.toFullDto(substitutionService.addSubstitution(toEntityCreate(dto)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
