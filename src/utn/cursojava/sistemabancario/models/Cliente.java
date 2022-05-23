package utn.cursojava.sistemabancario.models;

import java.util.Date;
import java.util.List;

public class Cliente extends Persona {

    private String domicilio;
    private Date altaCliente;

    private Integer idSucursal;


    /**
     * Constructor de la clase Persona.
     *
     * @param dni
     * @param nombreApellido
     * @param telefono
     * @param email
     * @param domicilio
     * @param altaCliente
     * @param idSucursal
     */
    public Cliente(String dni, String nombreApellido, String telefono, String email, String domicilio, Date altaCliente, Integer idSucursal) {
        super(dni, nombreApellido, telefono, email);
        this.domicilio = domicilio;
        this.altaCliente = altaCliente;
        this.idSucursal = idSucursal;
    }

    /* Getters y Setter de clase Cliente.
    Heredo los Getters/Setter de Persona para DNI, NombreApellido, Telefono e Email.
    */

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Date getAltaCliente() {
        return altaCliente;
    }

    public void setAltaCliente(Date altaCliente) {
        this.altaCliente = altaCliente;
    }
}
