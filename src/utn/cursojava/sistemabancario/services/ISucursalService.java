package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.models.Sucursal;

public interface ISucursalService {

    void addSucursal(Integer numeroSucursal, String nombreSucursal);

    void printClientes(Integer numeroSucursal);

    void printClientesAllSucursales();

    void eliminarSucursal(Integer numeroSucursal);

    Sucursal getSucursal(Integer numeroSucursal);

}
