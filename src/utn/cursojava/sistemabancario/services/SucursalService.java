package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.dao.ISucursalDAO;
import utn.cursojava.sistemabancario.dao.SucursalDAO;
import utn.cursojava.sistemabancario.models.Sucursal;

public class SucursalService implements ISucursalService {

    private final ISucursalDAO sucursalDAO;

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

    @Override
    public void printClientesAllSucursales() {
        sucursalDAO.printClientesAllSucursales();
    }

    @Override
    public void eliminarSucursal(Integer numeroSucursal) {
        sucursalDAO.eliminarSucursal(numeroSucursal);
    }
}
