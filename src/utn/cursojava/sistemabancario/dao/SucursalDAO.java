package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Cliente;
import utn.cursojava.sistemabancario.models.Sucursal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO implements ISucursalDAO {

    private static SucursalDAO instance = null;
    private SucursalDAO() {}

    /** Retorna la instancia de la clase Singleton
     * @return SucursalDAO Instancia de la clase */
    public static SucursalDAO getInstance() {
        if (instance == null) {
            instance = new SucursalDAO();
        }
        return instance;
    }

    @Override
    public void addSucursal(Sucursal sucursal) {
        /* Logica para agregar la sucursal a la BD */
        /* Me conecto a la Base de Datos y guardo la Sucursal! */
        JdbcConnection jdbcConnection = null;
        try {
            /* Me conecto a la base de datos */
            jdbcConnection = new JdbcConnection();
            String INSERTAR_SUCURSAL = "INSERT INTO SUCURSALES (numeroSucursal, nombreSucursal) VALUES (?,?)";
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(INSERTAR_SUCURSAL);
            preparedStatement.setInt(1, sucursal.getNumeroSucursal());
            preparedStatement.setString(2, sucursal.getNombreSucursal());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha agregado la sucursal correctamente");
            } else {
                System.out.println("No se ha agregado la sucursal");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Ya existe una sucursal con ese numero");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }
    }


    /** Returns all clients of Sucursal
     * @param numeroSucursal numeroSucursal de la sucursal a obtener los clientes.
     * @return Lista de clientes de la sucursal
     */
    public List<Cliente> getClientesBySucursal(Integer numeroSucursal){
        /* Logica para obtener los clientes de la sucursal */
        /* Me conecto a la Base de Datos y obtengo los clientes! */

        /* Logica para agregar la sucursal a la BD */
        /* Me conecto a la Base de Datos y guardo la Sucursal! */
        List<Cliente> clientesSucursal = new ArrayList<>();
        ResultSet resultSet;
        JdbcConnection jdbcConnection = null;
        try {
            /* Me conecto a la base de datos */
            jdbcConnection = new JdbcConnection();
            String GET_CLIENTES = "SELECT * FROM CLIENTES WHERE numeroSucursal = ?";
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(GET_CLIENTES);
            preparedStatement.setInt(1, numeroSucursal);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cliente clienteTemporal = new Cliente(resultSet.getString("dni"),
                        resultSet.getString("NOMBRE_APELLIDO"),
                        null,null, resultSet.getString("domicilio"),
                        null, Integer.valueOf(resultSet.getString("numeroSucursal")));
                clientesSucursal.add(clienteTemporal);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }
        return clientesSucursal;
    }

    @Override
    public List<Integer> getSucursales() {
        /* Logica para obtener las sucursales */
        List<Integer> list = new ArrayList<>();
        JdbcConnection jdbcConnection = null;
        try {
            /* Me conecto a la base de datos */
            jdbcConnection = new JdbcConnection();
            String GET_SUCURSALES = "SELECT * FROM SUCURSALES";
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(GET_SUCURSALES);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(Integer.valueOf(resultSet.getString("numeroSucursal")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }
        return list;
    }

    @Override
    public void eliminarSucursal(Integer numeroSucursal) {

        /* Mientras la Sucursal no sea ID = 0 (Es decir, la Sucursal Virtual). */
        if (numeroSucursal != 0) {
            /* Primero actualizo los Clientes de la sucursal que voy a borrar a SucursalNumero -> 0 */
            IClienteDAO clientedao = ClienteDAO.getInstance();
            clientedao.updateClientesSucursal(numeroSucursal);

            /* Luego elimino la Sucursal */
            JdbcConnection jdbcConnection = null;
            try {
                /* Me conecto a la base de datos */
                jdbcConnection = new JdbcConnection();
                String DELETE_SUCURSAL = "DELETE FROM SUCURSALES WHERE numeroSucursal = ?";
                PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(DELETE_SUCURSAL);
                preparedStatement.setInt(1, numeroSucursal);

                int result = preparedStatement.executeUpdate();

                if (result == 1) {
                    System.out.println("Se ha eliminado la sucursal correctamente");
                } else {
                    System.out.println("No se ha eliminado la sucursal");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if (jdbcConnection != null) {
                    jdbcConnection.closeConnection();
                }
            }
        } else {
            System.out.println("No se puede eliminar la sucursal virtual (ID = 0)");
        }
    }

    @Override
    public Sucursal getSucursal(Integer numeroSucursal) {
        Sucursal sucursal = null;

        JdbcConnection jdbcConnection = null;
        try {
            jdbcConnection = new JdbcConnection();
            String GET_SUCURSAL_BY_NUMERO_SUCURSAL = "SELECT * FROM SUCURSALES WHERE numeroSucursal=?";
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(GET_SUCURSAL_BY_NUMERO_SUCURSAL);
            preparedStatement.setInt(1, numeroSucursal);

            ResultSet resultSet = preparedStatement.executeQuery();
            /* Should only return one. */

            if (resultSet.next()) {
                sucursal = new Sucursal(resultSet.getInt("numeroSucursal"),
                        resultSet.getString("nombreSucursal"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }

        return sucursal;
    }


}
