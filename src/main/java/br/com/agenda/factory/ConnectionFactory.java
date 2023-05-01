package br.com.agenda.factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String USERNAME = "root"; // Usuário do banco de dados
    private static final String PASSWORD = "t00r"; // Senha do banco de dados
    private static final String DATABASE_URL = "jdbc:mysql://172.17.0.2:3306/agenda"; // URL do banco de dados

    public static Connection createConnectionToMySQL() throws Exception { // Criando uma conexão com o banco de dados

        Class.forName("com.mysql.cj.jdbc.Driver"); // Registrando o driver do MySQL

        try {
            return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD); // Retornando a conexão com o banco de dados
        }
        catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados: --> "+ e);
            return null;
        }

    }

    public static void main(String[] args) { // Método main para testar a conexão com o banco de dados
        try{
            Connection conn = createConnectionToMySQL(); // Criando uma conexão com o banco de dados

            if (conn != null) {
                System.out.println("Connection successfully closed!"); // Imprimindo a mensagem de sucesso
                conn.close(); // Fechando a conexão com o banco de dados
            }
        }
        catch (Exception e){
            e.printStackTrace(); // Imprimindo o erro
        }

    }

}
