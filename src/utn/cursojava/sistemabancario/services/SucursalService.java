package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.dao.ISucursalDAO;
import utn.cursojava.sistemabancario.dao.SucursalDAO;
import utn.cursojava.sistemabancario.models.Cliente;
import utn.cursojava.sistemabancario.models.Sucursal;

import java.sql.ResultSet;
import java.util.List;

public class SucursalService implements ISucursalService {

    private ISucursalDAO sucursalDAO;

    public SucursalService() {
        this.sucursalDAO = new SucursalDAO();
    }

    @Override
    public void addSucursal(Integer numeroSucursal, String nombreSucursal) {
        sucursalDAO.addSucursal(new Sucursal(numeroSucursal, nombreSucursal));
    }

    @Override
    public void printClientes(Integer numeroSucursal) {
        sucursalDAO.printClientes(numeroSucursal);
    }
}
