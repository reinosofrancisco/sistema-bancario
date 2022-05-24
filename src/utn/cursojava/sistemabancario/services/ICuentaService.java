package utn.cursojava.sistemabancario.services;

public interface ICuentaService<T> {
    void addCuenta(T cuenta);
    void removeCuenta(T cuenta);
    void depositar(T cuenta, double monto);
    void retirar(T cuenta, double monto);
    void transferir(T cuentaOrigen, T cuentaDestino, double monto);

    double getSaldo(T cuenta);

}
