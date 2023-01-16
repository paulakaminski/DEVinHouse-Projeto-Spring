# DEVinHouse-Projeto-Spring
## DEVinPharmacy - PharmacyManagement - Gerenciamento de Medicamentos e Farmácias
O quarto projeto avaliativo do curso DEVinHouse - Senai/SC - Turma CLAMED teve como proposta criação do back-end de um sistema online, para gerenciamento de medicamentos e farmácias, complementando o front-end desenvolvido no terceiro projeto do curso.
O objetivo do sistema é a realização de cadastros de farmácias e medicamentos, com armazenamento dos dados em banco de dados SQL.

A aplicação foi codificada utilizando o framework Spring Boot, juntamente com a linguagem de programação Java, e o banco de dados PostgreSQL, retornando os dados no formato JSON.

O sistema possui os seguintes principais endpoints:
- usuario: com a busca e validação dos usuáros cadastrados para login, e cadastro de novos usuarios, salvando os dados na tabela de usuarios;
- farmacia: com todas as funcionalidades de CRUD, salvando os dados na tabela de farmácia e endereço;
- medicamentos: tom todas as funcionalidades de CRUD, salvando os dados na tabela de medicamentos.

A aplicação foi construída utilizando a plataforma Postman, a qual pode ser utilizada para testes e simulações, e há um script disponível para criação das tabelas (endereco, farmacia, medicamento e usuario) no PostgreSQL.

### Conhecimentos utilizados no desenvolvimento do projeto:
-	Java: 
Introdução ao Java (instalação, sintaxe básica, compilação e execução);
Estruturas de Controle de Fluxo (condicional, repetição);
Arrays e ArrayList;
Documentação de Código;
Conceitos de POO: classes, objetos, métodos, atributos, construtores;
Modificadores (private, public, static, final), encapsulamento e sobrecarga;
Herança e Polimorfismo (extends, implements, protected, sobrescrita);
Tratamento de Exceções.

- SQL:
Configuração do ambiente PostgreSQL e comandos DDL (CREATE, ALTER, DROP);
Modelo relacional e comandos DML (INSERT, UPDATE, DELETE, SELECT).

- Spring:
Java Servlets, Spring Boot, Spring Core (injeção de dependências);
Spring Data;
CRUD REST API: GET, POST, PUT, DELETE.

-	API:
○	Criação de APIs funcionais e de qualidade.
