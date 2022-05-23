package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ClienteDAO implements IClienteDAO {

    private final String INSERTAR_CLIENTE = "INSERT INTO CLIENTES (dni, domicilio, NOMBRE_APELLIDO) VALUES (?,?,?)";

    @Override
    public void addCliente(Cliente cliente) {
        // TODO - ADD CLIENTE TO DB
        /* Me conecto a la Base de Datos y guardo el Cliente! */
        try {
            /* Me conecto a la base de datos */
            JdbcConnection jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(INSERTAR_CLIENTE);
            preparedStatement.setInt(1, Integer.valueOf(cliente.getDni()));
            preparedStatement.setString(2, cliente.getDomicilio());
            preparedStatement.setString(3, cliente.getNombreApellido());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha agregado el Cliente Correctamente!");
            } else {
                System.out.println("No se ha agregado el cliente");
            }

            jdbcConnection.closeConnection();

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Ya existe un cliente con ese DNI!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
