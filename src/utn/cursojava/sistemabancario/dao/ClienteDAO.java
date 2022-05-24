package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    @Override
    public void addCliente(Cliente cliente) {
        /* ¡Me conecto a la Base de Datos y guardo el Cliente! */
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


    /** Updates ALL clients of IdSucursal with idSucursal = 0
     * @param idSucursal Sucursal de la cual queremos mudar los clientes
     * */
    public void updateClientesSucursal(Integer idSucursal) {
        int idSucursalVirtual = 0;

        JdbcConnection jdbcConnection = null;
        try {
            jdbcConnection = new JdbcConnection();
            String UPDATE_CLIENTE_SUCURSAL = "UPDATE CLIENTES SET numeroSucursal=? WHERE numeroSucursal=?";
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(UPDATE_CLIENTE_SUCURSAL);
            preparedStatement.setInt(1, idSucursalVirtual);
            preparedStatement.setInt(2, idSucursal);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha actualizado el Cliente Correctamente a idSucursal 0 (Virtual)! ");
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



    /** Devuelve la lista de DNIs de los clientes que corresponden a la sucursal
     * @param idSucursal sucursal de la cual devolver los dni de clientes.
     * */
    public List<Integer> getDniClientesBySucursal(Integer idSucursal) {
        List<Integer> dnis;
        JdbcConnection jdbcConnection = null;
        try {
            jdbcConnection = new JdbcConnection();
            String GET_DNI_CLIENTES_BY_SUCURSAL = "SELECT dni FROM CLIENTES WHERE numeroSucursal=?";
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(GET_DNI_CLIENTES_BY_SUCURSAL);
            preparedStatement.setInt(1, idSucursal);
            ResultSet resultSet = preparedStatement.executeQuery();
            dnis = new ArrayList<>();
            while (resultSet.next()) {
                dnis.add(resultSet.getInt("dni"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }
        return dnis;
    }

}
