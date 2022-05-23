package utn.cursojava.sistemabancario.main;
import utn.cursojava.sistemabancario.dao.JdbcConnection;

import java.io.IOException;
import java.sql.*;


public class JdbcLogin {

    public static void main(String[] args) {
        try {
            JdbcLogin jdbcLogin = new JdbcLogin();
            jdbcLogin.StartBdd();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void StartBdd() throws SQLException, ClassNotFoundException, IOException {

        JdbcConnection jdbcConnection = new JdbcConnection();
        // Make a connection to the database
        Connection connection = jdbcConnection.getConnection();

        Statement statement = connection.createStatement();

        /* Codigo de prueba para guardar clientes */
        statement.executeUpdate("INSERT INTO `sistema_bancario`.`CLIENTES` (`NRO_CLIENTE`, `CUIL`, `NOMBRE_APELLIDO`) VALUES ('9', '4', 'Lucas Mamani');");


        /* Codigo de prueba para lectura de Clientes*/
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CLIENTES");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("NOMBRE_APELLIDO"));
        }

        // Close the connection to the database. Equivalente a connection.close();
        jdbcConnection.closeConnection();
    }
}
