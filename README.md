# Papay 💳 - Banco Digital Simulado

O **Papay** é uma API REST para uma Fintech Simulada (Banco Digital), projetada com foco em arquitetura em camadas, consistência transacional e rastreabilidade financeira (Ledger). O objetivo principal é servir como um portfólio de backend de alto nível, demonstrando o tratamento correto de concorrência e precisão numérica em cenários bancários.

## 🚀 Tecnologias e Ferramentas
* **Java 21** (LTS)
* **Spring Boot 3.x** (Spring Data JPA, Spring Web)
* **PostgreSQL** (Banco de dados relacional para transações ACID)
* **Lombok** (Redução de boilerplate)

## 🛠️ O Que Foi Feito Até Agora

O projeto encontra-se com a fundação estrutural e a camada de dados totalmente estabelecidas:

1. **Configuração de Infraestrutura e Segurança:**
   * Conexão integrada com o banco **PostgreSQL**.
   * Isolamento de credenciais sensíveis no `application.yaml` utilizando a variável de ambiente `${DB_PASSWORD}` para evitar vazamento de senhas no controle de versão.

2. **Modelagem do Domínio (`model`):**
   * **`Account`**: Entidade mapeada para a tabela `tb_accounts`. Configurada com `BigDecimal` para o saldo (garantindo precisão decimal e evitando erros de arredondamento ponto flutuante) e `@Version` para implementar *Optimistic Locking* (Bloqueio Otimista), mitigando problemas de concorrência e *race conditions*.
   * **`Transaction`**: Entidade criada para suportar o modelo de extrato imutável (Ledger), garantindo que toda movimentação financeira possua rastreabilidade completa.

3. **Camada de Persistência (`repository`):**
   * **`AccountRepository`**: Interface que estende `JpaRepository`, fornecendo operações de CRUD automáticas e otimizadas para o banco de dados.
   * **`TransactionRepository`**: Interface responsável pela persistência e auditoria das movimentações financeiras.

## 🏗️ Arquitetura do Projeto

A estrutura segue o padrão de **Arquitetura em Camadas (Layered Architecture)**, garantindo a separação estrita de responsabilidades:
* `model`: Contém as entidades e regras de mapeamento do banco de dados.
* `repository`: Interfaces de abstração de acesso a dados (Spring Data JPA).
* `service` *(Próxima etapa)*: Onde residirão as regras de negócio e validações financeiras.
* `controller` *(Próxima etapa)*: Endpoints HTTP da API REST para consumo externo.

## 🗺️ Status do Roadmap

- [x] Inicialização do projeto e configuração do `application.yaml` seguro.
- [x] Criação da entidade `Account` (Precisão Monetária + Controle de Concorrência).
- [x] Criação da entidade `Transaction` (Rastreabilidade/Ledger).
- [x] Implementação de `AccountRepository` e `TransactionRepository`.
- [ ] Construção das regras de negócio em `AccountService` (Depósitos, Saques e Transferências).
- [ ] Exposição dos endpoints em `AccountController`.
- [ ] Integração com Interface Web (Frontend consumidor).

---
*Documentação atualizada em maio de 2026.*
