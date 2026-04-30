🔐 API de Autenticação com Java e Spring Boot

Este projeto é uma API REST de autenticação e autorização desenvolvida em Java com Spring Boot, focada em segurança, organização de código e boas práticas de desenvolvimento backend.

A aplicação implementa login seguro com JWT, proteção de rotas e criptografia de senhas, sendo uma base sólida para sistemas backend modernos.

🎯 Objetivo do Projeto

Demonstrar conhecimentos práticos em:

Desenvolvimento de APIs REST
Autenticação e autorização de usuários
Segurança com Spring Security e JWT
Estruturação de projetos backend em camadas
🚀 Funcionalidades
Cadastro de usuários com validação de dados
Login com autenticação segura
Criptografia de senhas com BCrypt
Geração e validação de JWT (JSON Web Token)
Proteção de rotas autenticadas
Tratamento global de exceções
Padronização das respostas da API
🔄 Fluxo de Autenticação
Usuário realiza o cadastro
A senha é criptografada antes de ser salva no banco
Usuário realiza login com e-mail e senha
O sistema valida as credenciais
Um token JWT é gerado
O token é utilizado para acessar rotas protegidas
🧠 Decisões Técnicas
Spring Boot para acelerar o desenvolvimento e padronizar a aplicação
Autenticação stateless utilizando JWT
Uso de BCrypt para segurança no armazenamento de senhas
Spring Security para controle de acesso às rotas
Separação da aplicação em camadas:
Controller
Service
Repository
Centralização do tratamento de erros com @ControllerAdvice
📡 Endpoints Principais
POST /auth/login
POST /auth/cadastro
PUT  /auth/atualizar/role
🛠️ Tecnologias Utilizadas
Java
Spring Boot
Spring Security
JWT
BCrypt
JPA / Hibernate
Maven
▶️ Como Executar o Projeto
Clone este repositório
Configure o banco de dados no application.yml
Execute a aplicação
Acesse a API em http://localhost:8080
📁 Estrutura do Projeto
src/main/java
├── controller
├── service
├── repository
├── security
├── dto
├── entity
├── projection
├── exception
└── util
✅ O que este projeto demonstra
Implementação correta de autenticação com JWT
Boas práticas de segurança no backend
Código organizado e de fácil manutenção
Base reutilizável para outros projetos
Conhecimento inicial sólido em Spring Security
📌 Observações Finais

Este projeto foi desenvolvido com foco em aprendizado prático e boas práticas de mercado, sendo ideal como projeto de portfólio para desenvolvedores Java Júnior.

👩‍💻 Desenvolvido por

Bruna Prudencio
Java Backend Developer
