package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.CajaDeAhorro;

public interface ICuentaDAO<T> {
    void addCuenta(T cuenta);
    void removeCuenta(T cuenta);
    void depositar(T cuenta, double monto);
    void retirar(T cuenta, double monto);
    void transferir(T cuentaOrigen, T cuentaDestino, double monto);
    CajaDeAhorro getCuenta(int numCuenta);

}
