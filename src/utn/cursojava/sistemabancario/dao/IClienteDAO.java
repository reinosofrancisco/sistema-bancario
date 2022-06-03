package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Cliente;

public interface IClienteDAO {

    /** Metodo para agregar un cliente a la Base de Datos.
     * @params cliente Cliente que se desea agregar */
    void addCliente(Cliente cliente);

    /** Metodo para cambiar la sucursal de todos los clientes de
     * la sucursal enviada por parametro a sucursal ID = 0
     * @params idSucursal Sucursal a la que le queremos reasignar los clientes.
     * */
    public void updateClientesSucursal(Integer idSucursal);

    /** Metodo que devuelve el cliente mediante el DNI.
     * @param dni identificador unico del cliente.
     * @return Cliente con el DNI enviado por parametro.
     * */
    public Cliente getCliente(Integer dni);


}
