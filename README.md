# CRUD JAVA MYSQL 

## Objetivo do projeto
 - Criar um CRUD (Create, Read, Update, Delete) em Java com MySQL
 - Entender o funcionamento de um CRUD
 - Entender o funcionamento de uma Factory
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
    - main()

## InsertContato
    - Insere um contato no banco de dados

## ReadContatos
    - Lê todos os contatos do banco de dados

## UpdateContato
    - Atualiza um contato no banco de dados

## DeleteContato
    - Deleta um contato no banco de dados