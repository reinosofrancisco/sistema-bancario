package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Sucursal;

import java.sql.ResultSet;

public interface ISucursalDAO {

    public void addSucursal(Sucursal sucursal);

    void printClientes(Integer numeroSucursal);
}
