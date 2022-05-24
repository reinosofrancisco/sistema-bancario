package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.models.Cliente;

import java.sql.ResultSet;
import java.util.List;

public interface ISucursalService {

    void addSucursal(Integer numeroSucursal, String nombreSucursal);

    public void printClientes(Integer numeroSucursal);

    public void printClientesAllSucursales();

    public void eliminarSucursal(Integer numeroSucursal);

}
