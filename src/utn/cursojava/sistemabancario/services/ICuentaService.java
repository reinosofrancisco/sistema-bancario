package utn.cursojava.sistemabancario.services;

public interface ICuentaService<T> {
    /** metodo para agregar una cuenta a la base de datos
     * @param cuenta
     */
    void addCuenta(T cuenta);

    /** metodo para eliminar una cuenta de la base de datos
     * @param cuenta
     */
    void removeCuenta(T cuenta);

    /** metodo para depositar en una cuenta de la base de datos
     * @param cuenta
     * @param monto
     */
    void depositar(Integer cuenta, double monto);

    /** metodo para retirar de una cuenta de la base de datos
     * @param cuenta
     * @param monto
     */
    void retirar(Integer cuenta, double monto);

    /** metodo para transferir el saldo de una cuenta a otra
     * @param cuentaOrigen
     * @param cuentaDestino
     * @param monto
     */
    void transferir(Integer cuentaOrigen, Integer cuentaDestino, double monto);

    /** metodo para consultar el saldo de una cuenta
     * @param cuenta
     * @return
     */
    double getSaldo(Integer cuenta);

}
