package utn.cursojava.sistemabancario.models;

public class CuentaCorriente extends Cuenta {

    /**
     * Constructor de Cuenta Corriente!
     *
     * @param numCuenta numero de cuenta
     * @param saldo saldo de la cuenta
     * @param cbu cbu de la cuenta
     * @param idCliente id del cliente
     */
    public CuentaCorriente(Integer numCuenta, Double saldo, String cbu, Integer idCliente) {
        super(numCuenta, saldo, cbu, idCliente);
    }
}
