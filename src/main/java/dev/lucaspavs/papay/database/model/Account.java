package dev.lucaspavs.papay.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_accounts") // Boa prática: usar prefixo tb_ e plural
@Data // Gera Getters, Setters, Equals, HashCode e ToString via Lombok
@NoArgsConstructor // Construtor padrão exigido pelo JPA
@AllArgsConstructor // Construtor com todos os campos
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String holder; // Titular

    @Column(nullable = false)
    private BigDecimal balance; // Saldo Sempre usar BigDecimal para dinheiro

    @Version
    private Integer version; // Controle de concorrência otimista (Estudar)
}
