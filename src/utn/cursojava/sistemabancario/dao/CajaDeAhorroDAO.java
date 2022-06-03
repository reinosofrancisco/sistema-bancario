package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.CajaDeAhorro;

import java.sql.*;

public class CajaDeAhorroDAO implements ICuentaDAO<CajaDeAhorro> {

    private final String UPDATE_SALDO_CAJA_DE_AHORRO = "UPDATE CUENTA_AHORRO SET saldo = ? WHERE numCuenta = ?";

    //make CajaDeAhorroDAO a singleton
    private static CajaDeAhorroDAO instance = null;

    private CajaDeAhorroDAO() {
    }

    public static CajaDeAhorroDAO getInstance() {
        if (instance == null) {
            instance = new CajaDeAhorroDAO();
        }
        return instance;
    }

    @Override
    public void addCuenta(CajaDeAhorro cuenta) {
        /* Me conecto a la Base de Datos y guardo la Cuenta! */
        JdbcConnection jdbcConnection = null;
        try {
            /* Me conecto a la base de datos */
            jdbcConnection = new JdbcConnection();
            String INSERTAR_CAJA_DE_AHORRO = "INSERT INTO CUENTA_AHORRO (numCuenta, saldo, cbu, tipoMoneda, dniCliente) VALUES (?,?,?,?,?)";
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


        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Ya existe una cuenta con ese numero de cuenta");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }
    }

    @Override
    public void removeCuenta(CajaDeAhorro cuenta) {

    }

    @Override
    public void depositar(Integer cuenta, double monto) {


        JdbcConnection jdbcConnection = null;
        try {
            Double saldoActual = getCuenta(cuenta).getSaldo();
            /* Me conecto a la base de datos */
            jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(UPDATE_SALDO_CAJA_DE_AHORRO);
            preparedStatement.setDouble(1, saldoActual + monto);
            preparedStatement.setInt(2, cuenta);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha depositado correctamente");
            } else {
                System.out.println("No se ha depositado");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            System.out.println("No existe una cuenta con ese numero de cuenta para depositar");
        }
        finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }

    }

    public CajaDeAhorro getCuenta(int numCuenta) {
        CajaDeAhorro cajaDeAhorro = null;
        JdbcConnection jdbcConnection = null;
        try {
            jdbcConnection = new JdbcConnection();
            String GET_CAJA_DE_AHORRO = "SELECT * FROM CUENTA_AHORRO WHERE numCuenta = ?";
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }

        return cajaDeAhorro;
    }

    @Override
    public void retirar(Integer cuenta, double monto) {


        JdbcConnection jdbcConnection = null;
        try {
            Double saldoActual = getCuenta(cuenta).getSaldo();
            /* Me conecto a la base de datos */
            jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(UPDATE_SALDO_CAJA_DE_AHORRO);
            preparedStatement.setDouble(1, saldoActual - monto);
            preparedStatement.setInt(2, cuenta);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se ha retirado correctamente");
            } else {
                System.out.println("No se ha podido retirar");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            System.out.println("No existe una cuenta con ese numero de cuenta para retirar");
        }
        finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }

    }

    @Override
    public void transferir(Integer cuentaOrigen, Integer cuentaDestino, double monto) {
        retirar(cuentaOrigen, monto);
        depositar(cuentaDestino, monto);
    }
}
