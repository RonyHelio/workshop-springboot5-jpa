# Web Services com Spring Boot + JPA / Hibernate
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

## Testes Unitários e Cobertura

O projeto conta com uma suíte de testes unitários abrangente (utilizando JUnit 5 e Mockito) que cobre as camadas de Entidades, Controladores e Serviços.

**Meta Atingida**: A cobertura de código atual do projeto é de **89.94%**, superando a meta estabelecida de 85%.

### Como rodar os testes localmente

Para executar todos os testes da aplicação e gerar um novo relatório de cobertura, abra o terminal na pasta raiz do projeto e execute o comando abaixo (se estiver utilizando Windows):

```bash
.\mvnw.cmd clean test
```

*(Se estiver no Linux ou macOS, utilize: `./mvnw clean test`)*

### Como visualizar o relatório de cobertura

A ferramenta **Jacoco** está configurada no projeto. Assim que o comando de teste acima finalizar com sucesso, o relatório completo em HTML será gerado automaticamente.

Para visualizar, basta abrir o seguinte arquivo no seu navegador preferido:

```text
target/site/jacoco/index.html
```

Lá você encontrará a porcentagem exata de linhas testadas, instruções e complexidade ciclomática de cada classe do projeto.
