package utn.cursojava.sistemabancario.main;

public class ConsolePrinter {

    public static void imprimirMenuPrincipal() {
        System.out.println("\n**********MENU PRINCIPAL**********\n" +
                "1) Agregar Cliente\n" +
                "2) Agregar cuenta a Cliente\n" +
                "3) Listar Clientes por sucursal\n" +
                "4) Listar Clientes de todas las sucursales\n" +
                "5) Extraer dinero\n" +
                "6) Consultar Saldo\n" +
                "7) Realizar Deposito\n" +
                "8) Realizar transferencias\n" +
                "9) Eliminar una sucursal\n" +
                "0) Finalizar Ejecucion\n");
    }

    public static void imprimirMenuCliente(){
        System.out.println("\n**********MENU CLIENTE-CUENTA**********\n" +
                "1) Alta de Caja de Ahorro en Pesos\n" +
                "2) Alta de Caja de Ahorro en dólares\n" +
                "3) Alta de Cuenta Corriente en Pesos\n" );
    }

}
