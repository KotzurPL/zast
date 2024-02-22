package pl.kotzur.zast.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kotzur.zast.model.dto.HourForListDto;
import pl.kotzur.zast.model.entity.Hour;
import pl.kotzur.zast.service.HourService;

import java.util.List;

import static pl.kotzur.zast.mapper.HourMapper.toListDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hours")
public class HourController {

    private final HourService hourService;

    @GetMapping
    public List<HourForListDto> getHours() {
        return toListDto(hourService.getHours());
    }

    @GetMapping("/{id}")
    public Hour getSingleHour(@PathVariable Long id) {
        return hourService.getSingleHour(id);
    }

}
