package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.dao.ISucursalDAO;
import utn.cursojava.sistemabancario.dao.SucursalDAO;
import utn.cursojava.sistemabancario.models.Cliente;
import utn.cursojava.sistemabancario.models.Sucursal;

import java.util.List;

public class SucursalService implements ISucursalService {

    private final ISucursalDAO sucursalDAO;

    public SucursalService() {
        this.sucursalDAO = SucursalDAO.getInstance();
    }

    @Override
    public void addSucursal(Integer numeroSucursal, String nombreSucursal) {
        sucursalDAO.addSucursal(new Sucursal(numeroSucursal, nombreSucursal));
    }

    @Override
    public void printClientes(Integer numeroSucursal) {
        List<Cliente> listaClientes = sucursalDAO.getClientesBySucursal(numeroSucursal);
        System.out.println("Clientes Sucursal: " + numeroSucursal);
        listaClientes.forEach((Cliente cliente) -> {
            System.out.println("DNI: " + cliente.getDni());
        });
    }

    @Override
    public void printClientesAllSucursales() {
        sucursalDAO.getSucursales().forEach((Integer idSucursal) -> {
            printClientes(idSucursal);
        });
    }

    @Override
    public void eliminarSucursal(Integer numeroSucursal) {
        sucursalDAO.eliminarSucursal(numeroSucursal);
    }

    @Override
    public Sucursal getSucursal(Integer numeroSucursal) {
        return sucursalDAO.getSucursal(numeroSucursal);
    }
}
