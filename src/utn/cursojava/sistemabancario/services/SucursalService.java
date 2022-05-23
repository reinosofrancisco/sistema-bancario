package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.dao.ISucursalDAO;
import utn.cursojava.sistemabancario.dao.SucursalDAO;
import utn.cursojava.sistemabancario.models.Sucursal;

public class SucursalService implements ISucursalService {

    private ISucursalDAO sucursalDAO;

    public SucursalService() {
        this.sucursalDAO = new SucursalDAO();
    }

    @Override
    public void addSucursal(Integer numeroSucursal, String nombreSucursal) {
        sucursalDAO.addSucursal(new Sucursal(numeroSucursal, nombreSucursal));
    }
}
