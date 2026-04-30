Web Services com Spring Boot + JPA / Hibernate
API RESTful desenvolvida em Java utilizando o ecossistema Spring, com foco em arquitetura em camadas, persistência de dados e boas práticas de desenvolvimento backend.

📌 Sobre o projeto
Este projeto foi construído com o objetivo de demonstrar a criação de um sistema backend completo utilizando:

Spring Boot
JPA / Hibernate
Banco de dados H2 (testes)
PostgreSQL (produção)
Arquitetura em camadas
A aplicação implementa operações de CRUD (Create, Read, Update, Delete), além de tratamento de exceções e relacionamento entre entidades.

🧠 Conceitos aplicados
Arquitetura em camadas:
Resource (Controller)
Service
Repository
Mapeamento objeto-relacional (ORM)
Injeção de dependência
Banco de dados em memória (H2)
Persistência com JPA
Tratamento de exceções customizadas


API REST

🛠️ Tecnologias utilizadas
Java
Spring Boot
Spring Data JPA
Hibernate
H2 Database
PostgreSQL
Maven

🗄️ Modelo de domínio
O sistema contém as seguintes entidades:

User
Order
Product
Category
OrderItem
Payment

Com relacionamentos como:

One-to-Many
Many-to-Many
One-to-One

