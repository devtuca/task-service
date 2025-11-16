# Task Service

Uma API REST simples em **Spring Boot** para gerenciamento de tarefas (Tasks), realizada como desafio técnico.

---

## ✨ Funcionalidades

- Criar uma nova task (`POST /task`)  
- Listar todas as tasks (`GET /tasks`)  
- Buscar task por ID (`GET /task/{id}`)  
- Atualizar título e descrição de uma task (`PUT /task/{id}`)  
- Marcar uma task como completa (`PATCH /task/{id}/complete`)  
- Deletar uma task (`DELETE /task/{id}`)  

---

## 🧰 Tecnologias

- Java 17+  
- Spring Boot  
- Spring Data JPA  
- Hibernate (JPA)  
- H2 Database
- Lombok  
- Bean Validation (`jakarta.validation`)  
- OpenAPI / Swagger (usando `springdoc-openapi`)  


## 🚀 Como executar

1. Clone o repositório:  
   ```bash
   git clone https://github.com/devtuca/task-service.git
