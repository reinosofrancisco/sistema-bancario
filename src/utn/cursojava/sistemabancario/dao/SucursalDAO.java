package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Sucursal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class SucursalDAO implements ISucursalDAO {

    private final String INSERTAR_SUCURSAL = "INSERT INTO SUCURSALES (numeroSucursal, nombreSucursal) VALUES (?,?)";

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
//        cajasDeAhorro.add(cuenta);
    }
}
