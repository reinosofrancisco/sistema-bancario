package utn.cursojava.sistemabancario.main;

import utn.cursojava.sistemabancario.models.CajaDeAhorro;
import utn.cursojava.sistemabancario.models.Cliente;
import utn.cursojava.sistemabancario.services.*;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {



        /* CASO 1 - AGREGAR CLIENTE Y SU RESPECTIVA CUENTA */

        /* Doy de Alta una Sucursal Virtual con ID = 0 - Esta Sucursal no se puede Borrar. */
        ISucursalService sucursalService = new SucursalService();
        sucursalService.addSucursal(0, "Sucursal Virtual");

        /* Instancio el Service de Cliente */
        IClienteService clienteService = new ClienteService();

        /* Instancio el Service de Caja de Ahorro */
        ICuentaService<CajaDeAhorro> cajaDeAhorroService = new CajaDeAhorroService();

        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int sucursalNumero, dni, numeroCuenta, numeroCuenta2;
        double monto;
        CajaDeAhorro cajaDeAhorro;
        while (loop) {
            ConsolePrinter.imprimirMenuPrincipal();
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Ingrese el numero de Sucursal: ");
                    sucursalNumero = sc.nextInt();
                    System.out.println("Ingrese el DNI del Cliente: ");
                    dni = sc.nextInt();
                    /* Creo un cliente y lo agrego a la Sucursal Virtual */
                    Cliente cliente = new Cliente(String.valueOf(dni), "Reinoso Francisco", "2214555858",
                            "Test@Test.com", "Calle 99 Numero 99",
                            Date.from(LocalDate.now().minusYears(20).atStartOfDay().toInstant(ZoneOffset.UTC)),
                            sucursalNumero
                    );
                    /* Agrego el cliente a la base de Datos */
                    clienteService.addCliente(cliente);

                    /* Creo una caja de ahorro para el nuevo cliente */
                    System.out.println("Ingrese el numero de la cuenta: ");
                    numeroCuenta = sc.nextInt();
                    cajaDeAhorro = new CajaDeAhorro(numeroCuenta, 350.0,
                            "2255-2255-2255-2255", Integer.valueOf(cliente.getDni()), "ARS");

                    /* Agrego la Caja de Ahorro a la Base de Datos */
                    cajaDeAhorroService.addCuenta(cajaDeAhorro);
                    break;
                case 2:
                    System.out.println("Ingrese el DNI del Cliente: ");
                    dni = sc.nextInt();

                    ConsolePrinter.imprimirMenuCliente();

                    switch (sc.nextInt()) {
                        case 1:
                            /* Creo una caja de ahorro para el nuevo cliente */
                            System.out.println("[ARS] Ingrese el numero de la cuenta: ");
                            numeroCuenta = sc.nextInt();
                            cajaDeAhorro = new CajaDeAhorro(numeroCuenta, 350.0,
                                    "2255-2255-2255-2255", dni, "ARS");

                            /* Agrego la Caja de Ahorro a la Base de Datos */
                            cajaDeAhorroService.addCuenta(cajaDeAhorro);
                            break;
                        case 2:
                            /* Creo una caja de ahorro para el nuevo cliente */
                            System.out.println("[USD] Ingrese el numero de la cuenta: ");
                            numeroCuenta = sc.nextInt();
                            cajaDeAhorro = new CajaDeAhorro(numeroCuenta, 350.0,
                                    "2255-2255-2255-2255", dni, "USD");

                            /* Agrego la Caja de Ahorro a la Base de Datos */
                            cajaDeAhorroService.addCuenta(cajaDeAhorro);
                            break;
                        default:
                            /* Cuenta corriente no esta implementado*/
                            System.out.println("Opcion no valida - Cuenta Corriente no esta implementado.");

                    }
                    break;

                case 3:
                    /* CASO 3 - PRINT CLIENTES BY SUCURSAL */
                    /* Prints clientes de la Sucursal Ingresada */
                    System.out.println("Ingrese el numero de Sucursal: ");
                    sucursalNumero = sc.nextInt();
                    sucursalService.printClientes(sucursalNumero);
                    break;

                case 4:
                    /* CASO 4 - PRINT CLIENTES BY ALL SUCURSALES */
                    sucursalService.printClientesAllSucursales();
                    break;

                case 5:
                    System.out.println("Ingrese el numero de la caja de ahorro: ");
                    numeroCuenta = sc.nextInt();
                    System.out.println("Ingrese el monto a retirar: ");
                    monto = sc.nextDouble();
                    /* CASO 5 - EXTRAER DINERO DE UNA CUENTA */
                    cajaDeAhorroService.retirar(numeroCuenta, monto);
                    break;

                case 6:
                    System.out.println("Ingrese el numero de la caja de ahorro: ");
                    numeroCuenta = sc.nextInt();
                    /* CASO 6 - CONSULTAR SALDO EN UNA CUENTA */
                    double saldo;
                    saldo = cajaDeAhorroService.getSaldo(numeroCuenta);
                    if (saldo >= 0) {
                        System.out.println("Saldo actual de la cuenta " + numeroCuenta + " = " + cajaDeAhorroService.getSaldo(numeroCuenta));
                    }
                    break;

                case 7:
                    System.out.println("Ingrese el numero de la caja de ahorro: ");
                    numeroCuenta = sc.nextInt();
                    System.out.println("Ingrese el monto a depositar: ");
                    monto = sc.nextDouble();
                    /* CASO 7 - DEPOSITAR DINERO EN UNA CUENTAS */
                    cajaDeAhorroService.depositar(numeroCuenta, monto);
                    break;

                case 8:
                    System.out.println("Ingrese el numero de la caja de ahorro: ");
                    numeroCuenta = sc.nextInt();
                    System.out.println("Ingrese el monto a transferir: ");
                    monto = sc.nextDouble();
                    System.out.println("Ingrese el numero de la cuenta a la que desea transferir: ");
                    numeroCuenta2 = sc.nextInt();
                    /* CASO 8 - TRANSFERIR DINERO ENTRE CUENTAS */
                    cajaDeAhorroService.transferir(numeroCuenta, numeroCuenta2, monto);
                    break;

                case 9:
                    /* Doy de Alta una Sucursal Testeo con ID = 1 para eliminar. Sino, solo existe Sucursal 0. */
                    sucursalService.addSucursal(1, "Sucursal Testeo");
                    //ingrese numero sucursal
                    System.out.println("Ingrese el numero de la sucursal: ");
                    sucursalNumero = sc.nextInt();
                    /* CASO 9 - ELIMINAR SUCURSAL - Sucursal 0 NO PUEDE ser borrada.
                     * Cuando una sucursal se borra, los clientes de la misma se asignan a la Sucursal 0. */
                    sucursalService.eliminarSucursal(sucursalNumero);
                    break;

                case 0:
                    System.out.println("Finalizando Ejecucion...");
                    loop = false;
                    break;

                default:
                    System.out.println("Opcion invalida. Finalizando Ejecucion...");
                    loop = false;
                    break;

            }
        }

    }
}
