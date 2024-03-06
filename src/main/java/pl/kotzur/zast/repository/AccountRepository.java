package pl.kotzur.zast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kotzur.zast.model.entity.Account;
import pl.kotzur.zast.model.entity.Person;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);

    Optional<Account> findAccountByPerson(Person person);

    @Query(value="SELECT a.id_person " +
            "FROM account a " +
            "WHERE a.email = ?1", nativeQuery = true)
    Long findPersonIdByEmail(String email);
}
