package utn.cursojava.sistemabancario.main;

import utn.cursojava.sistemabancario.dao.CajaDeAhorroDAO;
import utn.cursojava.sistemabancario.models.CajaDeAhorro;
import utn.cursojava.sistemabancario.models.Cliente;
import utn.cursojava.sistemabancario.services.*;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaBancario {

    public static void main(String[] args) {
        // TODO code application logic here

        /* Doy de Alta una Sucursal Virtual con ID = 0 */
        ISucursalService sucursalService = new SucursalService();
        sucursalService.addSucursal(0, "Sucursal Virtual");

        /* CASO 1 - AGREGAR CLIENTE Y SU RESPECTIVA CUENTA */

        /* Creo un cliente y lo agrego a la Sucursal Virtual */
        Cliente cliente = new Cliente("42095198","Reinoso Francisco","2214555858",
                "Test@Test.com","Calle 99 Numero 99",
                Date.from(LocalDate.now().minusYears(20).atStartOfDay().toInstant(ZoneOffset.UTC)),
                0
        );

        /* Agrego el cliente a la base de Datos */
        IClienteService clienteService = new ClienteService();
        clienteService.addCliente(cliente);

        /* Creo una caja de ahorro  */
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(0,350.0,
                "2255-2255-2255-2255",Integer.valueOf(cliente.getDni()),"ARS");

        /* Uso el Service para agregar la Caja de Ahorro. */
        ICuentaService<CajaDeAhorro> cajaDeAhorroService = new CajaDeAhorroService();
        cajaDeAhorroService.addCuenta(cajaDeAhorro);


    }
}
