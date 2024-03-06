package pl.kotzur.zast.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.kotzur.zast.model.entity.ClassGroup;
import pl.kotzur.zast.repository.ClassGroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassGroupService {

    private static final int PAGE_SIZE = 8;
    private final ClassGroupRepository classGroupRepository;

    public List<ClassGroup> getClassGroups() {
        return classGroupRepository.findAll();
    }

    public List<ClassGroup> getClassGroups(int page, Sort.Direction sort) {
        return classGroupRepository.findAllClassGroups(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    public ClassGroup getSingleClassGroup(Long id) {
        return classGroupRepository.getReferenceById(id);
    }

    public ClassGroup addClassGroup(ClassGroup classGroup) {

        return classGroupRepository.save(classGroup);

    }

    @Transactional
    public ClassGroup editClassGroup(ClassGroup classGroup) {
        ClassGroup editedClassGroup = classGroupRepository.findById(classGroup.getId()).orElseThrow();
        editedClassGroup.setLevel(classGroup.getLevel());
        editedClassGroup.setSymbol(classGroup.getSymbol());
        editedClassGroup.setType(classGroup.getType());
        editedClassGroup.setActive(classGroup.isActive());
        editedClassGroup.setDuration(classGroup.getDuration());
        return editedClassGroup;
    }

    public void deleteClassGroup(Long id) {
        classGroupRepository.deleteById(id);
    }
}
