package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.CajaDeAhorro;

public interface ICuentaDAO<T> {
    /** Metodo para agregar una cuenta a la Base de Datos.
     * @param cuenta cuenta a agregar*/
    void addCuenta(T cuenta);

    /** Metodo para eliminar una cuenta de la Base de Datos.
     * @param cuenta cuenta a eliminar
     */
    void removeCuenta(T cuenta);

    /** Metodo para depositar dinero en una cuenta.
     * @param cuenta cuenta a la cual deposito
     * @param monto monto a depositar
     */
    void depositar(Integer cuenta, double monto);

    /** Metodo para retirar dinero de una cuenta
     * @param cuenta cuenta de la cual retiro
     * @param monto monto a retirar
     */
    void retirar(Integer cuenta, double monto);

    /** Metodo para trasnferir dinero de una cuenta a otra
     * @param cuentaOrigen Cuenta de la cual transfiero
     * @param cuentaDestino Cuenta que recibe el dinero
     * @param monto Monto que sera transferido*/
    void transferir(Integer cuentaOrigen, Integer cuentaDestino, double monto);

    /** Metodo para obtener una cuenta
     * @param numCuenta identificador de la cuenta que quiero obtener*/
    CajaDeAhorro getCuenta(int numCuenta);

}
