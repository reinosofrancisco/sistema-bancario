package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.CajaDeAhorro;
import utn.cursojava.sistemabancario.models.Cliente;

public interface ICuentaDAO<T> {
    public void addCuenta(T cuenta);
    public void removeCuenta(T cuenta);
    public void depositar(T cuenta, double monto);
    public void retirar(T cuenta, double monto);
    public void transferir(T cuentaOrigen, T cuentaDestino, double monto);
    public CajaDeAhorro getCuenta(int numCuenta);

}
