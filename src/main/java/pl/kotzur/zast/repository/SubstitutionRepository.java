package pl.kotzur.zast.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kotzur.zast.model.entity.ClassGroup;
import pl.kotzur.zast.model.entity.Substitution;

import java.util.List;

@Repository
public interface SubstitutionRepository extends JpaRepository<Substitution, Long> {

    @Query(value="SELECT * FROM substitution", nativeQuery = true)
    List<Substitution> findAllSubstitutions(Pageable pageable);

}
