package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Cliente;

public interface IClienteDAO {

    void addCliente(Cliente cliente);

    public void updateClientesSucursal(Integer idSucursal);

    public Cliente getCliente(Integer dni);


}
