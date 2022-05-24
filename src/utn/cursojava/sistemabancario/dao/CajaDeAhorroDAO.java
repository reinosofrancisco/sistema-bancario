package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.CajaDeAhorro;

import java.sql.*;
import java.util.List;

public class CajaDeAhorroDAO implements ICuentaDAO<CajaDeAhorro> {

    private final String INSERTAR_CAJA_DE_AHORRO = "INSERT INTO CUENTA_AHORRO (numCuenta, saldo, cbu, tipoMoneda, dniCliente) VALUES (?,?,?,?,?)";
    private final String GET_CAJA_DE_AHORRO = "SELECT * FROM CUENTA_AHORRO WHERE numCuenta = ?";
    private final String UPDATE_SALDO_CAJA_DE_AHORRO = "UPDATE CUENTA_AHORRO SET saldo = ? WHERE numCuenta = ?";



    public CajaDeAhorroDAO() {

    }

    @Override
    public void addCuenta(CajaDeAhorro cuenta) {
        /* Me conecto a la Base de Datos y guardo la Cuenta! */
        try {
            /* Me conecto a la base de datos */
            JdbcConnection jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(INSERTAR_CAJA_DE_AHORRO);
            preparedStatement.setInt(1, cuenta.getNumCuenta());
            preparedStatement.setDouble(2, cuenta.getSaldo());
            preparedStatement.setString(3, cuenta.getCbu());
            preparedStatement.setString(4, cuenta.getTipoMoneda());
            preparedStatement.setInt(5, cuenta.getCliente());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha agregado la cuenta correctamente");
            } else {
                System.out.println("No se ha agregado la cuenta");
            }

            jdbcConnection.closeConnection();

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Ya existe una cuenta con ese numero de cuenta");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        cajasDeAhorro.add(cuenta);
    }

    @Override
    public void removeCuenta(CajaDeAhorro cuenta) {

    }

    @Override
    public void depositar(CajaDeAhorro cuenta, double monto) {
        Double saldoActual = getCuenta(cuenta.getNumCuenta()).getSaldo();

        try {
            /* Me conecto a la base de datos */
            JdbcConnection jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(UPDATE_SALDO_CAJA_DE_AHORRO);
            preparedStatement.setDouble(1, saldoActual + monto);
            preparedStatement.setInt(2, cuenta.getNumCuenta());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha depositado correctamente");
            } else {
                System.out.println("No se ha depositado");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public CajaDeAhorro getCuenta(int numCuenta) {
        CajaDeAhorro cajaDeAhorro = null;
        try {
            JdbcConnection jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(GET_CAJA_DE_AHORRO);
            preparedStatement.setInt(1, numCuenta);

            ResultSet resultSet = preparedStatement.executeQuery();
            /* Should only return one. */
            if (resultSet.next()) {
                cajaDeAhorro = new CajaDeAhorro(resultSet.getInt("numCuenta"),
                        resultSet.getDouble("saldo"),
                        resultSet.getString("cbu"),
                        resultSet.getInt("dniCliente"),
                        resultSet.getString("tipoMoneda"));
            }

            jdbcConnection.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cajaDeAhorro;
    }

    @Override
    public void retirar(CajaDeAhorro cuenta, double monto) {
        Double saldoActual = getCuenta(cuenta.getNumCuenta()).getSaldo();

        try {
            /* Me conecto a la base de datos */
            JdbcConnection jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(UPDATE_SALDO_CAJA_DE_AHORRO);
            preparedStatement.setDouble(1, saldoActual - monto);
            preparedStatement.setInt(2, cuenta.getNumCuenta());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha retirado correctamente");
            } else {
                System.out.println("No se ha podido retirar");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void transferir(CajaDeAhorro cuentaOrigen, CajaDeAhorro cuentaDestino, double monto) {
        retirar(cuentaOrigen, monto);
        depositar(cuentaDestino, monto);

    }
}
