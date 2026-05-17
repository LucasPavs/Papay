package dev.lucaspavs.papay.database.repository;

import dev.lucaspavs.papay.database.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // O Spring Data JPA já fornece save(), findById(), findAll(), deleteById(), etc.
}
