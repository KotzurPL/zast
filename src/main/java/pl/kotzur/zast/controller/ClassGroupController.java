package pl.kotzur.zast.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kotzur.zast.model.entity.ClassGroup;
import pl.kotzur.zast.model.entity.Person;
import pl.kotzur.zast.service.ClassGroupService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classes")
public class ClassGroupController {

    private final ClassGroupService classGroupService;

    @GetMapping
    public List<ClassGroup> getClassGroups() {
        return classGroupService.getClassGroup();
    }

    @GetMapping("/{id}")
    public ClassGroup getSingleClassGroup(@PathVariable Long id) {
        return classGroupService.getSingleClassGroup(id);
    }

}
