package pl.kotzur.zast.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kotzur.zast.model.entity.ClassGroup;

import java.util.List;

@Repository
public interface ClassGroupRepository extends JpaRepository<ClassGroup, Long> {

    @Query(value="SELECT * FROM class", nativeQuery = true)
    List<ClassGroup> findAllClassGroups(Pageable pageable);

}
