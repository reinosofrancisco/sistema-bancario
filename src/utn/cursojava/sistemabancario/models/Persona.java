package utn.cursojava.sistemabancario.models;

public abstract class Persona {

    /* Atributos DNI, NombreApellido, Telefono, Email y NumeroDeSucursal a la que corresponde. */
    protected String dni;
    protected String nombreApellido;
    protected String telefono;
    protected String email;
//    protected Sucursal sucursalCliente;

    /** Constructor de la clase Persona.
     * @param dni
     * @param nombreApellido
     * @param telefono
     * @param email
     */
    public Persona(String dni, String nombreApellido, String telefono, String email) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.telefono = telefono;
        this.email = email;
    }

    /* Getters y Setters de los atributos de la clase Persona. */

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getNumeroDeSucursal() {
//        return numeroDeSucursal;
//    }

//    public void setNumeroDeSucursal(String numeroDeSucursal) {
//        this.numeroDeSucursal = numeroDeSucursal;
//    }


}
