package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.CajaDeAhorro;

public interface ICuentaDAO<T> {
    void addCuenta(T cuenta);
    void removeCuenta(T cuenta);
    void depositar(Integer cuenta, double monto);
    void retirar(Integer cuenta, double monto);
    void transferir(Integer cuentaOrigen, Integer cuentaDestino, double monto);
    CajaDeAhorro getCuenta(int numCuenta);

}
