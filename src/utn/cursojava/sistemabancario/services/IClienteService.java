package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.models.Cliente;

public interface IClienteService {

    /** Metodo para agregar un cliente a la base de datos
     * @param cliente
     */
    void addCliente(Cliente cliente);

    /** Metodo para buscar un cliente por su dni
     * @param dni
     * @return Cliente
     */
    Cliente getCliente(Integer dni);


}
