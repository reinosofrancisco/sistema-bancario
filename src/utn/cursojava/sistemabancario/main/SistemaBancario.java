package utn.cursojava.sistemabancario.main;

import utn.cursojava.sistemabancario.dao.CajaDeAhorroDAO;
import utn.cursojava.sistemabancario.models.CajaDeAhorro;
import utn.cursojava.sistemabancario.models.Cliente;
import utn.cursojava.sistemabancario.services.*;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        Cliente cliente = new Cliente("42095199","Reinoso Francisco","2214555858",
                "Test@Test.com","Calle 99 Numero 99",
                Date.from(LocalDate.now().minusYears(20).atStartOfDay().toInstant(ZoneOffset.UTC)),
                0
        );

        Cliente cliente2 = new Cliente("654654654","Pedro Perez","3424555858",
                "Lucas@Mamani.com","Av. 54, Mendoza",
                Date.from(LocalDate.now().minusYears(20).atStartOfDay().toInstant(ZoneOffset.UTC)),
                1
        );

        /* Agrego el cliente a la base de Datos */
        IClienteService clienteService = new ClienteService();
        clienteService.addCliente(cliente);
        clienteService.addCliente(cliente2);

        /* CASO 1 Y 2 - Agrego la Caja de ahorro al Cliente */
        /* Para agregar CUENTA a CLIENTE, creo una cuenta y le paso el DNI como idCliente. */
        /* Creo una caja de ahorro  */
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(0,350.0,
                "2255-2255-2255-2255",Integer.valueOf(cliente.getDni()),"ARS");

        CajaDeAhorro cajaDeAhorro2 = new CajaDeAhorro(3,900.0,
                "2555-999-999-999",Integer.valueOf(cliente2.getDni()),"ARS");

        /* Uso el Service para agregar la Caja de Ahorro. */
        ICuentaService<CajaDeAhorro> cajaDeAhorroService = new CajaDeAhorroService();
        cajaDeAhorroService.addCuenta(cajaDeAhorro);
        cajaDeAhorroService.addCuenta(cajaDeAhorro2);

        /* CASO 3 - PRINT CLIENTES BY SUCURSAL */
        /* Prints clientes de la Sucursal = 0 */
        sucursalService.printClientes(0);

        System.out.println("\n\nSEPARADOR\n\n");

        /* CASO 4 - PRINT CLIENTES BY ALL SUCURSALES */
        sucursalService.printClientesAllSucursales();

        /* CASO 5 - EXTRAER DINERO DE UNA CUENTA */
        cajaDeAhorroService.retirar(cajaDeAhorro,50.0);

        /* CASO 7 - DEPOSITAR DINERO EN UNA CUENTAS */
        cajaDeAhorroService.depositar(cajaDeAhorro,100.0);

        /* CASO 6 - CONSULTAR SALDO EN UNA CUENTA */
        System.out.println("Saldo actual de la cuenta 1 = " + cajaDeAhorroService.getSaldo(cajaDeAhorro));
        System.out.println("Saldo actual de la cuenta 2 = " + cajaDeAhorroService.getSaldo(cajaDeAhorro2));

        /* CASO 8 - TRANSFERIR DINERO ENTRE CUENTAS */
        cajaDeAhorroService.transferir(cajaDeAhorro,cajaDeAhorro2,50.0);

        System.out.println("Saldo actual de la cuenta 1 = " + cajaDeAhorroService.getSaldo(cajaDeAhorro));
        System.out.println("Saldo actual de la cuenta 2 = " + cajaDeAhorroService.getSaldo(cajaDeAhorro2));

        /* CASO 9 - ELIMINAR SUCURSAL */
        //TODO: No se puede eliminar una sucursal con clientes asociados.
        // Should update idSucursal to 0 for every client in sucursal to be deleted.
        // Sucursal 0 mustn't be deleted.

        /* Doy de Alta una Sucursal Testeo con ID = 1 para eliminar */
        sucursalService.addSucursal(1, "Sucursal Testeo");

        /* Elimino la Sucursal Testeo. Esto hace update a los clientes con Sucursal 1 y le asigna un 0. */
        sucursalService.eliminarSucursal(1);


        //TODO: Menu interactivo?



    }
}
