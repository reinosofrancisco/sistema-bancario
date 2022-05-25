package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.dao.CajaDeAhorroDAO;
import utn.cursojava.sistemabancario.dao.ICuentaDAO;
import utn.cursojava.sistemabancario.models.CajaDeAhorro;

public class CajaDeAhorroService implements ICuentaService<CajaDeAhorro>{

    private final ICuentaDAO<CajaDeAhorro> cajaDeAhorroDAO;

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
    public void depositar(Integer cuenta, double monto) {
        this.cajaDeAhorroDAO.depositar(cuenta, monto);
    }

    @Override
    public void retirar(Integer cuenta, double monto) {
        this.cajaDeAhorroDAO.retirar(cuenta, monto);
    }

    @Override
    public void transferir(Integer cuentaOrigen, Integer cuentaDestino, double monto) {
        this.cajaDeAhorroDAO.transferir(cuentaOrigen, cuentaDestino, monto);
    }

    @Override
    public double getSaldo(Integer cuenta) {
        return this.cajaDeAhorroDAO.getCuenta(cuenta).getSaldo();
    }

}
