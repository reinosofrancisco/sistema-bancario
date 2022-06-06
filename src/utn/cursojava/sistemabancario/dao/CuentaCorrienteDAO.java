package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.CajaDeAhorro;
import utn.cursojava.sistemabancario.models.CuentaCorriente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class CuentaCorrienteDAO implements ICuentaDAO<CuentaCorriente> {

    private final String UPDATE_SALDO_CUENTA_CORRIENTE = "UPDATE CUENTA_CORRIENTE SET saldo = ? WHERE numCuenta = ?";

    private static CuentaCorrienteDAO instance = null;

    private CuentaCorrienteDAO() {
    }

    /** Retorna la instancia de la clase Singleton
     * @return CuentaCorrienteDAO Instancia de la clase */
    public static CuentaCorrienteDAO getInstance() {
        if (instance == null) {
            instance = new CuentaCorrienteDAO();
        }
        return instance;
    }


    @Override
    public void addCuenta(CuentaCorriente cuenta) {
        /* Me conecto a la Base de Datos y guardo la Cuenta! */
        JdbcConnection jdbcConnection = null;
        try {
            /* Me conecto a la base de datos */
            jdbcConnection = new JdbcConnection();
            String INSERTAR_CUENTA_CORRIENTE = "INSERT INTO CUENTA_CORRIENTE (numCuenta, saldo, cbu, dniCliente) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(INSERTAR_CUENTA_CORRIENTE);
            preparedStatement.setInt(1, cuenta.getNumCuenta());
            preparedStatement.setDouble(2, cuenta.getSaldo());
            preparedStatement.setString(3, cuenta.getCbu());
            preparedStatement.setInt(4, cuenta.getCliente());

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
    public void removeCuenta(CuentaCorriente cuenta) {

    }

    @Override
    public void depositar(Integer cuenta, double monto) {
        JdbcConnection jdbcConnection = null;
        try {
            Double saldoActual = getCuenta(cuenta).getSaldo();
            /* Me conecto a la base de datos */
            jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(UPDATE_SALDO_CUENTA_CORRIENTE);
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

    @Override
    public void retirar(Integer cuenta, double monto) {
        JdbcConnection jdbcConnection = null;
        try {
            Double saldoActual = getCuenta(cuenta).getSaldo();
            /* Me conecto a la base de datos */
            jdbcConnection = new JdbcConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(UPDATE_SALDO_CUENTA_CORRIENTE);
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

    @Override
    public CuentaCorriente getCuenta(int numCuenta) {
        CuentaCorriente cuentaCorriente = null;
        JdbcConnection jdbcConnection = null;
        try {
            jdbcConnection = new JdbcConnection();
            String GET_CAJA_DE_AHORRO = "SELECT * FROM CUENTA_AHORRO WHERE numCuenta = ?";
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareCall(GET_CAJA_DE_AHORRO);
            preparedStatement.setInt(1, numCuenta);

            ResultSet resultSet = preparedStatement.executeQuery();
            /* Should only return one. */
            if (resultSet.next()) {
                cuentaCorriente = new CuentaCorriente(
                        resultSet.getInt("numCuenta"),
                        resultSet.getDouble("saldo"),
                        resultSet.getString("cbu"),
                        resultSet.getInt("dniCliente")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (jdbcConnection != null) {
                jdbcConnection.closeConnection();
            }
        }
        return cuentaCorriente;
    }
}
