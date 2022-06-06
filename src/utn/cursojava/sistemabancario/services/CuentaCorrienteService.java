package utn.cursojava.sistemabancario.services;


import utn.cursojava.sistemabancario.dao.CuentaCorrienteDAO;
import utn.cursojava.sistemabancario.dao.ICuentaDAO;
import utn.cursojava.sistemabancario.models.CajaDeAhorro;
import utn.cursojava.sistemabancario.models.CuentaCorriente;

public class CuentaCorrienteService implements ICuentaService<CuentaCorriente>{

    private final ICuentaDAO<CuentaCorriente> cuentaCorrienteDAO;

    public CuentaCorrienteService(){
        this.cuentaCorrienteDAO = CuentaCorrienteDAO.getInstance();
    }

    @Override
    public void addCuenta(CuentaCorriente cuenta) {
        this.cuentaCorrienteDAO.addCuenta(cuenta);
    }

    @Override
    public void removeCuenta(CuentaCorriente cuenta) {

    }

    @Override
    public void depositar(Integer cuenta, double monto) {
        this.cuentaCorrienteDAO.depositar(cuenta,monto);
    }

    @Override
    public void retirar(Integer cuenta, double monto) {
        this.cuentaCorrienteDAO.retirar(cuenta,monto);
    }

    @Override
    public void transferir(Integer cuentaOrigen, Integer cuentaDestino, double monto) {
        this.cuentaCorrienteDAO.transferir(cuentaOrigen,cuentaDestino,monto);
    }

    @Override
    public double getSaldo(Integer cuenta) {
        try {
            return this.cuentaCorrienteDAO.getCuenta(cuenta).getSaldo();
        } catch (NullPointerException e) {
            System.out.println("No existe la cuenta");
            return -1;
        }
    }
}
