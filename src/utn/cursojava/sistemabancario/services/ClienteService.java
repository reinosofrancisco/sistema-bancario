package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.dao.ClienteDAO;
import utn.cursojava.sistemabancario.dao.IClienteDAO;
import utn.cursojava.sistemabancario.models.Cliente;

public class ClienteService implements IClienteService {

    private final IClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    public void addCliente(Cliente cliente) {
        this.clienteDAO.addCliente(cliente);
    }
}
