package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.dao.CajaDeAhorroDAO;
import utn.cursojava.sistemabancario.dao.ICuentaDAO;
import utn.cursojava.sistemabancario.models.CajaDeAhorro;

public class CajaDeAhorroService implements ICuentaService<CajaDeAhorro>{

    private ICuentaDAO<CajaDeAhorro> cajaDeAhorroDAO;

    public CajaDeAhorroService() {
        this.cajaDeAhorroDAO = new CajaDeAhorroDAO();
    }

    @Override
    public void addCuenta(CajaDeAhorro cuenta) {
        this.cajaDeAhorroDAO.addCuenta(cuenta);
    }

    @Override
    public void removeCuenta(CajaDeAhorro cuenta) {
        this.cajaDeAhorroDAO.removeCuenta(cuenta);
    }

    @Override
    public void depositar(CajaDeAhorro cuenta, double monto) {
        this.cajaDeAhorroDAO.depositar(cuenta, monto);
    }

    @Override
    public void retirar(CajaDeAhorro cuenta, double monto) {
        this.cajaDeAhorroDAO.retirar(cuenta, monto);
    }

    @Override
    public void transferir(CajaDeAhorro cuentaOrigen, CajaDeAhorro cuentaDestino, double monto) {
        this.cajaDeAhorroDAO.transferir(cuentaOrigen, cuentaDestino, monto);
    }

}
