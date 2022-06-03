package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.models.Sucursal;

import java.util.List;

public interface ISucursalDAO {

    /** Metodo para agregar una sucursal a la base de datos.
     * @param sucursal sucursal a agregar. */
    void addSucursal(Sucursal sucursal);

    /** Metodo para imprimir los clientes de la sucursal enviada */
    void printClientes(Integer numeroSucursal);

    /** Metodo para imprimir los clientes de todas las sucursales */
    void printClientesAllSucursales();

    /** Metodo que retorna una lista con el numero de todas las Sucursal.
     * @return Lista con los numeros de las Sucursales */
    List<Integer> getSucursales();

    /** Metodo para eliminar la sucursal enviada.
     * @param numeroSucursal identificador de la sucursal a eliminar. */
    void eliminarSucursal(Integer numeroSucursal);

    /** Metodo que retorna la sucursal enviada.
     * @param numeroSucursal identificador de la sucursal a obtener
     * @return Sucursal */
    Sucursal getSucursal(Integer numeroSucursal);
}
