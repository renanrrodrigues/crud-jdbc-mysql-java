package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    // DAO = Data Access Object (Objeto de acesso a dados)
    // CRUD = Create, Read, Update, Delete
    /*
    * Create = INSERT INTO contatos (nome, idade, dataCadastro) VALUES (?, ?, ?)
    * Read = SELECT * FROM contatos WHERE id = ? (id) OR nome = ? (nome) OR idade = ? (idade) OR dataCadastro = ? (dataCadastro)
    * Update = UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ? WHERE id = ? (id) OR nome = ? (nome) OR idade = ? (idade) OR dataCadastro = ? (dataCadastro)
    * Delete = DELETE FROM contatos WHERE id = ? (id) OR nome = ? (nome) OR idade = ? (idade) OR dataCadastro = ? (dataCadastro)
     */

    // Create
    public void save(Contato contato){

        //
        String sql = "INSERT INTO contatos (nome, idade, dataCadastro) VALUES (?, ?, ?)"; // SQL para inserir um contato no banco
        //

        Connection conn = null; // Conexão com o banco
        PreparedStatement pstm = null; // Statement para executar a query

        try{
            // Criar uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL(); // Conexão com o banco

            // Criar um statement para executar a query
            assert conn != null;
            pstm = conn.prepareStatement(sql); // Statement para executar a query

            // Adicionar os valores do contato
            pstm.setString(1, contato.getNome()); // Adicionando o nome do contato
            pstm.setInt(2, contato.getIdade()); // Adicionando a idade do contato
            pstm.setDate(3, new java.sql.Date(contato.getDataCadastro().getTime())); // Adicionando a data de cadastro do contato

            pstm.execute(); // Executando a query

            //System.out.println("Contato salvo com sucesso! \uD83D\uDE80");
        }
        catch (Exception e){
            e.printStackTrace(); // Imprimindo o erro
        }
        finally {
            try{
                if (pstm != null){
                    pstm.close(); // Fechando o statement
                }
                if (conn != null){
                    conn.close(); // Fechando a conexão com o banco
                }
            }
            catch (Exception e){
                e.printStackTrace(); // Imprimindo o erro
            }
        }
    }

    // Read
    public List<Contato> getContatos(){ // Método para retornar todos os contatos do banco

        String sql = "SELECT * FROM contatos"; // SQL para selecionar todos os contatos do banco

        List<Contato> contatos = new ArrayList<Contato>(); // Lista de contatos

        Connection conn = null; // Conexão com o banco

        PreparedStatement pstm = null; // Statement para executar a query

        ResultSet rset = null; // Resultado da query

        try{
            conn = ConnectionFactory.createConnectionToMySQL(); // Conexão com o banco


            assert conn != null;

            pstm = conn.prepareStatement(sql); // Statement para executar a query

            rset = pstm.executeQuery(); // Executando a query e armazenando o resultado 'rows'

            while (rset.next()){ //  Itera enquanto houver um próximo contato
                Contato contato = new Contato(); // Instanciando Contato

                contato.setId(rset.getInt("id")); // Pega o id do contato
                contato.setNome(rset.getString("nome")); // Pega o nome do contato
                contato.setIdade(rset.getInt("idade")); // Pega a idade do contato
                contato.setDataCadastro(rset.getDate("dataCadastro")); // Pega a data de cadastro do contato

                contatos.add(contato); // Adicionando o contato na lista de contatos
            }




        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                if (rset != null){
                    rset.close(); // Fechando o resultado da query
                }
                if (pstm != null){
                    pstm.close(); // Fechando o statement
                }
                if (conn != null){
                    conn.close(); // Fechando a conexão com o banco
                }
            }
            catch (Exception e){
                e.printStackTrace(); // Imprimindo o erro
            }
        }

        return contatos; // Retornando a lista de contatos
    }

    // Update
    public void update(Contato contato){ // Método para atualizar um contato no banco
        String sql = "UPDATE contatos SET nome = ?, idade = ? WHERE id = ?"; // SQL para atualizar um contato no banco

        Connection conn = null; // Conexão com o banco
        PreparedStatement pstm = null; // Statement para executar a query

        try{
            // Criar uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL(); // Conexão com o banco

            // Criar um statement para executar a query
            assert conn != null;
            pstm = conn.prepareStatement(sql); // Statement para executar a query

            // Adicionar os valores ao contato que serão atualizados
            pstm.setString(1, contato.getNome()); // nome do contato que será atualizado
            pstm.setInt(2, contato.getIdade()); // idade do contato que será atualizado
            pstm.setInt(3, contato.getId()); // id do contato que será atualizado

            pstm.execute(); // Executando a query

            System.out.println("Contato atualizado com sucesso!");
        }
        catch (Exception e){
            e.printStackTrace(); // Imprimindo o erro
        }
        finally {
            try{
                if (pstm != null){
                    pstm.close(); // Fechando o statement
                }
                if (conn != null){
                    conn.close(); // Fechando a conexão com o banco
                }
            }
            catch (Exception e){
                e.printStackTrace(); // Imprimindo o erro
            }
        }
    }

    // Delete
    public void delete(Contato contato){ // Método para deletar um contato no banco

        String sql = "DELETE FROM contatos WHERE id = ?"; // SQL para deletar um contato no banco

        Connection conn = null; // Conexão com o banco
        PreparedStatement pstm = null; // Statement para executar a query

        try{
            // Criar uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL(); // Conexão com o banco

            // Criar um statement para executar a query
            assert conn != null;
            pstm = conn.prepareStatement(sql); // Statement para executar a query

            // Adicionar o id do contato que será deletado
            pstm.setInt(1, contato.getId()); // id do contato que será deletado

            pstm.execute(); // Executando a query

            System.out.println("Contato deletado com sucesso!");
        }
        catch (Exception e){
            e.printStackTrace(); // Imprimindo o erro
        }
        finally {
            try{
                if (pstm != null){
                    pstm.close(); // Fechando o statement
                }
                if (conn != null){
                    conn.close(); // Fechando a conexão com o banco
                }
            }
            catch (Exception e){
                e.printStackTrace(); // Imprimindo o erro
            }
        }
    }
}
