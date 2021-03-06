package utn.cursojava.sistemabancario.models;

import java.util.Date;

public class Cliente extends Persona {

    private String domicilio;
    private Date altaCliente;

    private Integer idSucursal;


    /**
     * Constructor de la clase Persona.
     *
     * @param dni     DNI del cliente.
     * @param nombreApellido Nombre y apellido del cliente.
     * @param telefono Telefono del cliente.
     * @param email  Email del cliente.
     * @param domicilio Domicilio del cliente.
     * @param altaCliente Fecha de alta del cliente.
     * @param idSucursal Id de la sucursal del cliente.
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

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }
}
