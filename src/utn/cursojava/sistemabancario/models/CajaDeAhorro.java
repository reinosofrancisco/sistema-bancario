package utn.cursojava.sistemabancario.models;

public class CajaDeAhorro extends Cuenta {

    private String tipoMoneda;


    /**
     * Constructor de Caja de Ahorro.
     *
     * @param numCuenta Numero de cuenta.
     * @param saldo Saldo de la cuenta.
     * @param cbu CBU de la cuenta.
     * @param idCliente DNI del cliente asociado a la cuenta.
     * @param tipoMoneda ARS, USD, EUR
     */
    public CajaDeAhorro(Integer numCuenta, Double saldo, String cbu, Integer idCliente, String tipoMoneda) {
        super(numCuenta, saldo, cbu, idCliente);
        this.tipoMoneda = tipoMoneda;
    }

    /* Getters y Setters de Caja de Ahorro */

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    /* Metodos especificos de Caja de Ahorro */
    @Override
    public String toString() {
        return "CajaDeAhorro { " +
                "tipoMoneda='" + tipoMoneda + '\'' +
                ", numCuenta=" + numCuenta +
                ", saldo=" + saldo +
                ", cbu='" + cbu + '\'' +
                ", Dni Asociado='" + idCliente + '\'' +
                " }";
    }
}
