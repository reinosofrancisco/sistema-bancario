package utn.cursojava.sistemabancario.services;

public interface ISucursalService {

    void addSucursal(Integer numeroSucursal, String nombreSucursal);

    void printClientes(Integer numeroSucursal);

    void printClientesAllSucursales();

    void eliminarSucursal(Integer numeroSucursal);

}
