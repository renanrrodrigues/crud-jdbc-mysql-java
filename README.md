# CRUD JAVA JDBC MYSQL 

## Objetivo do projeto
 - Criar um CRUD (Create, Read, Update, Delete) em Java com MySQL
 - Entender o funcionamento de um CRUD
 - Entender o funcionamento de uma ConnectionFactory
 - Entender o funcionamento de um DAO
 - Entender o funcionamento de um Model

## model - class Contato

#### class Contato
- Atributos
    - id (AUTO_INCREMENT)
    - nome
    - idade
    - dataCadastro

## dao - class ContatoDAO

#### Métodos da classe ContatoDAO

- Create
    - Criar um contato

- Read
    - Read All
    
- Update
    - Atualiza um contato
 
- Delete
    - Deleta um contato
    

## factory - class ConnectionFactory

#### class ConnectionFactory
- Atributos estáticos
    - USERNAME
    - PASSWORD
    - DATABASE_URL

- Métodos
    - createConnectionToMySQL() 
    - main() - Testa a conexão com o banco de dados

## Classes para testar os métodos do CRUD

- InsertContato - class InsertContato
    - Insere um contato no banco de dados

- ReadContatos - class ReadContatos
    - Lê todos os contatos do banco de dados

- UpdateContato - class UpdateContato
    - Atualiza um contato no banco de dados

- DeleteContato - class DeleteContato
    - Deleta um contato no banco de dados

## libraries - pom.xml gerenciador de dependências do Maven
    
     <dependencies>
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>
        <dependency>
            <groupId>net.datafaker</groupId>
            <artifactId>datafaker</artifactId>
            <version>1.9.0</version>
        </dependency>
    </dependencies>
    
- mysql-connector-java - Conexão com o banco de dados
- datafaker - Gera dados aleatórios

## MySQL - querys para criar o banco de dados e a tabela

    CREATE DATABASE agenda;

    CREATE TABLE contatos (
        id INT NOT NULL AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
        idade INT NOT NULL,
        dataCadastro DATETIME NOT NULL,
        PRIMARY KEY (id)
    );
