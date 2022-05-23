package utn.cursojava.sistemabancario.models;

public abstract class Cuenta {

    protected Integer numCuenta;
    protected Double saldo;
    protected String cbu;
    protected Integer idCliente;

    /** Constructor de Cuenta para que hereden los Hijos! */
    public Cuenta (Integer numCuenta, Double saldo, String cbu, Integer idCliente) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.cbu = cbu;
        this.idCliente = idCliente;
    }

    /* Getters y Setters para Heredar. */

    public Integer getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(Integer numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public Integer getCliente() {
        return idCliente;
    }

    public void setCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /* Metodos para Heredar. */

    @Override
    public String toString() {
        return "Cuenta { " +
                "numCuenta=" + numCuenta +
                ", saldo=" + saldo +
                ", cbu='" + cbu + '\'' +
                ", idCliente ='" + idCliente + '\'' +
                " }";
    }


}
