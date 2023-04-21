# CRUD JAVA MYSQL

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