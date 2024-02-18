package pl.kotzur.zast.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kotzur.zast.model.dto.SubstitutionForListDto;
import pl.kotzur.zast.service.SubstitutionService;

import java.util.List;

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

}
