package dev.lucaspavs.papay.repository;

import dev.lucaspavs.papay.model.Transaction; // O IntelliJ vai grifar isso de vermelho
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

