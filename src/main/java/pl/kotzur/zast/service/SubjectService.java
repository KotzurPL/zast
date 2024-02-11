package pl.kotzur.zast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kotzur.zast.model.entity.Role;
import pl.kotzur.zast.model.entity.Subject;
import pl.kotzur.zast.repository.SubjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSingleSubject(Long id) {
        return subjectRepository.getReferenceById(id);
    }

}
