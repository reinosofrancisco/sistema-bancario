package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Sucursal;

import java.util.List;

public interface ISucursalDAO {

    void addSucursal(Sucursal sucursal);

    void printClientes(Integer numeroSucursal);

    void printClientesAllSucursales();

    List<Integer> getSucursales();

    void eliminarSucursal(Integer numeroSucursal);
}
