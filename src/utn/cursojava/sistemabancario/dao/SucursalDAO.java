package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Sucursal;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO implements ISucursalDAO {

    private final String INSERTAR_SUCURSAL = "INSERT INTO SUCURSALES (numeroSucursal, nombreSucursal) VALUES (?,?)";

    private final String GET_SUCURSALES = "SELECT * FROM SUCURSALES";
    private final String GET_CLIENTES = "SELECT * FROM CLIENTES WHERE numeroSucursal = ?";

    private final String DELETE_SUCURSAL = "DELETE FROM SUCURSALES WHERE numeroSucursal = ?";

    @Override
    public void addSucursal(Sucursal sucursal) {
        /* Logica para agregar la sucursal a la BD */
        /* Me conecto a la Base de Datos y guardo la Sucursal! */
        try {
            /* Me conecto a la base de datos */
            JdbcConnection jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(INSERTAR_SUCURSAL);
            preparedStatement.setInt(1, sucursal.getNumeroSucursal());
            preparedStatement.setString(2, sucursal.getNombreSucursal());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha agregado la sucursal correctamente");
            } else {
                System.out.println("No se ha agregado la sucursal");
            }

            jdbcConnection.closeConnection();

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Ya existe una sucursal con ese numero");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** Prints all clients of Sucursal
     * @param numeroSucursal
     */
    @Override
    public void printClientes(Integer numeroSucursal) {
        /* Logica para obtener los clientes de la sucursal */
        /* Me conecto a la Base de Datos y obtengo los clientes! */

        /* Logica para agregar la sucursal a la BD */
        /* Me conecto a la Base de Datos y guardo la Sucursal! */
        ResultSet resultSet = null;
        try {
            /* Me conecto a la base de datos */
            JdbcConnection jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(GET_CLIENTES);
            preparedStatement.setInt(1, numeroSucursal);

            resultSet = preparedStatement.executeQuery();

            System.out.println("Clientes Sucursal " + numeroSucursal);
            while(resultSet.next()) {
                System.out.println("DNI = " + resultSet.getString("dni"));
            }


            jdbcConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void printClientesAllSucursales() {
        List<Integer> list = getSucursales();
        for (Integer numeroSucursal : list) {
            printClientes(numeroSucursal);
        }

    }

    @Override
    public List<Integer> getSucursales() {
        /* Logica para obtener las sucursales */
        List<Integer> list = new ArrayList<>();
        try {
            /* Me conecto a la base de datos */
            JdbcConnection jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(GET_SUCURSALES);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                list.add(Integer.valueOf(resultSet.getString("numeroSucursal")));
            }

            jdbcConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void eliminarSucursal(Integer numeroSucursal) {
        //GET SUCURSALES. IF SUCURSALES > 1 THEN DELETE ELIMINAR SUCURSAL
        //BEFORE, UPDATE CLIENTES TO SUCURSAL 0
        //TODO: Implementar - Por ahora solo eliminas la sucursal
        IClienteDAO clientedao = new ClienteDAO();
        clientedao.updateClientesSucursal(numeroSucursal);
        try {
            /* Me conecto a la base de datos */
            JdbcConnection jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(DELETE_SUCURSAL);
            preparedStatement.setInt(1, numeroSucursal);

            int result = preparedStatement.executeUpdate();

            if (result == 1) {
                System.out.println("Se ha eliminado la sucursal correctamente");
            } else {
                System.out.println("No se ha eliminado la sucursal");
            }

            jdbcConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
