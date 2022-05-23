package utn.cursojava.sistemabancario.models;

public class CuentaCorriente extends Cuenta {

    /**
     * Constructor de Cuenta Corriente!
     *
     * @param numCuenta
     * @param saldo
     * @param cbu
     * @param idCliente
     */
    public CuentaCorriente(Integer numCuenta, Double saldo, String cbu, Integer idCliente) {
        super(numCuenta, saldo, cbu, idCliente);
    }
}
