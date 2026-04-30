# 🔐 API de Autenticação com Java e Spring Boot

Este projeto é uma **API REST de autenticação e autorização** desenvolvida em **Java com Spring Boot**, focada em **segurança**, **organização de código** e **boas práticas de desenvolvimento backend**.

A aplicação implementa **login seguro com JWT**, proteção de rotas e criptografia de senhas, servindo como uma **base sólida para sistemas backend modernos**.

---

## 🎯 Objetivo do Projeto

Demonstrar conhecimentos práticos em:

- Desenvolvimento de APIs REST
- Autenticação e autorização de usuários
- Segurança com Spring Security e JWT
- Estruturação de projetos backend em camadas

---

## 🚀 Funcionalidades

- Cadastro de usuários com validação de dados
- Login com autenticação segura
- Criptografia de senhas com **BCrypt**
- Geração e validação de **JWT (JSON Web Token)**
- Proteção de rotas autenticadas
- Tratamento global de exceções
- Padronização das respostas da API

---

## 🔄 Fluxo de Autenticação

1. Usuário realiza o cadastro
2. A senha é criptografada antes de ser salva no banco
3. Usuário realiza login com e-mail e senha
4. O sistema valida as credenciais
5. Um token JWT é gerado
6. O token é utilizado para acessar rotas protegidas

---

## 🧠 Decisões Técnicas

- **Spring Boot** para acelerar o desenvolvimento e padronizar a aplicação
- Autenticação **stateless** utilizando JWT
- Uso de **BCrypt** para segurança no armazenamento de senhas
- **Spring Security** para controle de acesso às rotas
- Separação da aplicação em camadas:
  - Controller
  - Service
  - Repository
- Centralização do tratamento de erros com `@ControllerAdvice`

---

## 📡 Endpoints Principais
