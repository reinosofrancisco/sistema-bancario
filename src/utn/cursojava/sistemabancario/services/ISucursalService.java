package utn.cursojava.sistemabancario.services;

import utn.cursojava.sistemabancario.models.Sucursal;

public interface ISucursalService {

    /** Metodo que permite agregar una sucursal
     * @param numeroSucursal
     * @param nombreSucursal */
    void addSucursal(Integer numeroSucursal, String nombreSucursal);

    /** Metodo que permite imprimir los clientes de una sucursal
     * @param numeroSucursal */
    void printClientes(Integer numeroSucursal);

    /** Metodo que permite imprimir los clientes de todas las sucursales */
    void printClientesAllSucursales();

    /** Metodo que permite eliminar una sucursal
     * @param numeroSucursal
     */
    void eliminarSucursal(Integer numeroSucursal);

    /** Metodo que permite obtener una sucursal
     * @param numeroSucursal
     * @return sucursal
     */
    Sucursal getSucursal(Integer numeroSucursal);

}
