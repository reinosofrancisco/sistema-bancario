package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Cliente;

public interface IClienteDAO {

    void addCliente(Cliente cliente);

    void updateClientesSucursal(Integer idSucursal);


}
