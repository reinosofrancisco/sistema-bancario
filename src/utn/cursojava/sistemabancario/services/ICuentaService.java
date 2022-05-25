package utn.cursojava.sistemabancario.services;

public interface ICuentaService<T> {
    void addCuenta(T cuenta);
    void removeCuenta(T cuenta);
    void depositar(Integer cuenta, double monto);
    void retirar(Integer cuenta, double monto);
    void transferir(Integer cuentaOrigen, Integer cuentaDestino, double monto);

    double getSaldo(Integer cuenta);

}
