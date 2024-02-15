package pl.kotzur.zast.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kotzur.zast.model.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findAllByFirstNameAndLastName(String firstName, String lastName);

    @Query(value="SELECT * " +
                 "FROM person p " +
                    "left join person_role pr on pr.id_person = p.id " +
                 "WHERE id_role = 4", nativeQuery = true)
    List<Person> findTeachers(Pageable pageable);
}
