package pl.kotzur.zast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.kotzur.zast.model.entity.Substitution;
import pl.kotzur.zast.repository.SubstitutionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubstitutionService {

    private static final int PAGE_SIZE = 8;
    private final SubstitutionRepository substitutionRepository;

    public List<Substitution> getSubstitutions(int page, Sort.Direction sort) {
        return substitutionRepository.findAllSubstitutions(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    public Substitution getSingleSubstitution(Long id) {
        return substitutionRepository.findById(id).orElseThrow();
    }

    public Substitution addSubstitution(Substitution substitution) {
        return substitutionRepository.save(substitution);
    }
}
