package utn.cursojava.sistemabancario.models;

import java.util.List;

public class Banco {

    private Integer numeroBanco;
    private String nombreBanco;
    private List<Integer> idSucursales;
    private List<Integer> idCuentas;


    /**
     * Constructor de la clase Banco
     * @param numeroBanco
     * @param nombreBanco
     * @param idSucursal
     * @param idCuenta
     */
    public Banco(Integer numeroBanco, String nombreBanco, Integer idSucursal, Integer idCuenta) {
        this.numeroBanco = numeroBanco;
        this.nombreBanco = nombreBanco;
        this.idSucursales.add(idSucursal);
        this.idCuentas.add(idCuenta);
    }

    /* Getters y Setters de la Clase Banco. */

    public Integer getNumeroBanco() {
        return numeroBanco;
    }

    public void setNumeroBanco(Integer numeroBanco) {
        this.numeroBanco = numeroBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public List<Integer> getSucursales() {
        return idSucursales;
    }

    public void setSucursales(List<Integer> sucursales) {
        this.idSucursales = sucursales;
    }

    public List<Integer> getCuentas() {
        return idCuentas;
    }

    public void setCuentas(List<Integer> cuentas) {
        this.idCuentas = cuentas;
    }
}



