package test;

import br.com.agenda.factory.ConnectionFactory;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) throws Exception {

        Connection conn = ConnectionFactory.createConnectionToMySQL();

    }
}
