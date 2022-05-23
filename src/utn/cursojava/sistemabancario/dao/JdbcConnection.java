package utn.cursojava.sistemabancario.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

    private Connection connection;

    /** Establece una conexion con la base de Datos MySQL establecida en db.properties.
     * @return Connection
     * */
    public Connection getConnection() {

        connection = null;
        try {
            // create a reader object on the properties file
            FileReader reader = new FileReader("src/db.properties");

            // create properties object
            Properties db = new Properties();

            // Add a wrapper around reader object
            db.load(reader);

            // Access properties file
            String username = db.getProperty("username");
            String password = db.getProperty("password");
            String jdbcURL = db.getProperty("URL");
            jdbcURL = jdbcURL + db.getProperty("database");

            Class.forName(db.getProperty("driver"));

            connection = DriverManager.getConnection(jdbcURL, username, password);

        } catch (ClassNotFoundException | IOException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /** Cierra la conexion con la base de datos de la instancia de JdbcConnection. */
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
