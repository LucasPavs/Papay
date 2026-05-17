package dev.lucaspavs.papay.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "transactions")
    @Data // Gera getters, setters, toString, etc.
    public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // Muitas transações podem partir de uma mesma conta de origem
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "source_account_id", nullable = false)
        private Account sourceAccount;

        // Muitas transações podem ir para uma mesma conta de destino
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "destination_account_id", nullable = false)
        private Account destinationAccount;

        @Column(nullable = false)
        private BigDecimal amount;

        @Column(nullable = false)
        private LocalDateTime createdAt;
}
