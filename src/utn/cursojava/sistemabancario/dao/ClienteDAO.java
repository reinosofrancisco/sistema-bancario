package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ClienteDAO implements IClienteDAO {

    @Override
    public void addCliente(Cliente cliente) {
        // TODO - ADD CLIENTE TO DB
        /* Me conecto a la Base de Datos y guardo el Cliente! */
        JdbcConnection jdbcConnection = null;
        try {
            /* Me conecto a la base de datos */
            jdbcConnection = new JdbcConnection();
            String INSERTAR_CLIENTE = "INSERT INTO CLIENTES (dni, domicilio, NOMBRE_APELLIDO, numeroSucursal) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(INSERTAR_CLIENTE);
            preparedStatement.setInt(1, Integer.parseInt(cliente.getDni()));
            preparedStatement.setString(2, cliente.getDomicilio());
            preparedStatement.setString(3, cliente.getNombreApellido());
            preparedStatement.setInt(4, cliente.getIdSucursal());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha agregado el Cliente Correctamente!");
            } else {
                System.out.println("No se ha agregado el cliente");
            }


        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Ya existe un cliente con ese DNI!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }
    }

    public void updateClientesSucursal(Integer idSucursal) {
        JdbcConnection jdbcConnection = null;
        try {
            jdbcConnection = new JdbcConnection();
            String UPDATE_CLIENTE_SUCURSAL = "UPDATE CLIENTES SET numeroSucursal=? WHERE numeroSucursal=?";
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(UPDATE_CLIENTE_SUCURSAL);
            preparedStatement.setInt(1, idSucursal);
            preparedStatement.setInt(2, idSucursal);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha actualizado el Cliente Correctamente! -> Excepto que no... no actualiza el numeroSucursal? ");
            } else {
                System.out.println("No se ha actualizado el cliente");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }
    }

}
