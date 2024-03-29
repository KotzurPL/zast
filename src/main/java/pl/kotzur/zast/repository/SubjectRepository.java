package pl.kotzur.zast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kotzur.zast.model.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
