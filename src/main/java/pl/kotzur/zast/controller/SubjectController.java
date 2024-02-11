package pl.kotzur.zast.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kotzur.zast.model.entity.Role;
import pl.kotzur.zast.model.entity.Subject;
import pl.kotzur.zast.service.SubjectService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSingleSubject(@PathVariable Long id) {
        return subjectService.getSingleSubject(id);
    }

}
