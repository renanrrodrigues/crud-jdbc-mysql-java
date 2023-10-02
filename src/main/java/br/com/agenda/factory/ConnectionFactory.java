package br.com.agenda.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// todos os comentários é apenas para fins didáticos.
public class ConnectionFactory {

    private static final String USERNAME = "root"; // Usuário do banco de dados
    private static final String PASSWORD = "t00r"; // Senha do banco de dados
    private static final String DATABASE_URL = "jdbc:mysql://192.168.79.128:3306/agenda"; // URL do banco de dados

    static Connection conn = null; // Conexão com o banco de dados

    public static Connection createConnectionToMySQL() throws Exception { // Criando uma conexão com o banco de dados

        Class.forName("com.mysql.cj.jdbc.Driver"); // Registrando o driver do MySQL

        try {
            if (conn == null) // Verificando se a conexão não está fechada
                return conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD); // Retornando a conexão com o banco de dados
            else if (conn.isClosed()) {
                conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD); // Criando uma nova conexão com o banco de dados
                return conn; // Retornando a conexão com o banco de dados
            }
            else // Caso a conexão não esteja fechada
                return conn; // Retornando a conexão com o banco de dados
        }
        catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados: --> "+ e);
            return null;
        }

    }

    public static void main(String[] args) throws Exception { // Método main para testar a conexão com o banco de dados
        try{
            conn = ConnectionFactory.createConnectionToMySQL(); // Criando uma conexão com o banco de dados

            if (conn != null){ // Verificando se a conexão foi criada
                System.out.println("Connection successfully\n"); // Imprimindo a mensagem de sucesso
                System.out.println("Closing connection..."); // Imprimindo a mensagem de fechamento da conexão
                conn.close(); // Fechando a conexão com o banco de dados
            }
            else {
                System.out.println("Connection failed\n"); // Imprimindo a mensagem de falha
            }
        }
        catch (SQLException e){
            e.printStackTrace(); // Imprimindo o erro
        }
    }

}
