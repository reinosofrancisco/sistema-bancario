package utn.cursojava.sistemabancario.models;

import java.util.List;

public class Banco {

    private Integer numeroBanco;
    private String nombreBanco;

    /**
     * Constructor de la clase Banco
     * @param numeroBanco numero del banco
     * @param nombreBanco nombre del banco
     */
    public Banco(Integer numeroBanco, String nombreBanco) {
        this.numeroBanco = numeroBanco;
        this.nombreBanco = nombreBanco;

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

}



