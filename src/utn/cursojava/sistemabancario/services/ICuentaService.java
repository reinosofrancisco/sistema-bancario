package utn.cursojava.sistemabancario.services;

public interface ICuentaService<T> {
    public void addCuenta(T cuenta);
    public void removeCuenta(T cuenta);
    public void depositar(T cuenta, double monto);
    public void retirar(T cuenta, double monto);
    public void transferir(T cuentaOrigen, T cuentaDestino, double monto);

    public double getSaldo(T cuenta);

}
