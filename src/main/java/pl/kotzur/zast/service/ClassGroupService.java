package pl.kotzur.zast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kotzur.zast.model.entity.ClassGroup;
import pl.kotzur.zast.repository.ClassGroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassGroupService {

    private final ClassGroupRepository classGroupRepository;

    public List<ClassGroup> getClassGroup() {
        return classGroupRepository.findAll();
    }

    public ClassGroup getSingleClassGroup(Long id) {
        return classGroupRepository.getReferenceById(id);
    }

}
