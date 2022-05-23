package utn.cursojava.sistemabancario.models;

import java.util.List;

public class Sucursal {

    private int numeroSucursal;
    private String nombreSucursal;

    /** Constructor de Sucursal
     * @param numeroSucursal
     * @param nombreSucursal
     */
    public Sucursal(int numeroSucursal, String nombreSucursal) {
        this.numeroSucursal = numeroSucursal;
        this.nombreSucursal = nombreSucursal;
    }

    /* Getters y Setters para Sucursal*/

    public int getNumeroSucursal() {
        return numeroSucursal;
    }

    public void setNumeroSucursal(int numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

}
