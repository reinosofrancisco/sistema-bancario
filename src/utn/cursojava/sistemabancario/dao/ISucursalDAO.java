package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Sucursal;

import java.sql.ResultSet;
import java.util.List;

public interface ISucursalDAO {

    public void addSucursal(Sucursal sucursal);

    void printClientes(Integer numeroSucursal);

    public void printClientesAllSucursales();

    public List<Integer> getSucursales();

    public void eliminarSucursal(Integer numeroSucursal);
}
