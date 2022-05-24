# Sistema Bancario de la Academia de Java UTN

Se utilizará un modelo de capas con DAO, Service y Controller.

### PAUTAS:
1) El alta de un cliente comprende también: <br>
   A. Dar de alta una cuenta o más de una.
2) El agregar cuenta a Cliente implica dar de alta una cuenta nueva solicitada por el
   cliente.
3) El banco debe tener al menos una sucursal, que deben estar predefinidas antes de
   iniciar la ejecución de su programa.
4) Para poder eliminar una sucursal, el banco debe tener al menos dos sucursales de
   tal forma que la cartera de clientes y empleados de la sucursal a eliminar se pase
   a la otra sucursal.
5) Las transferencias pueden ser entre cuentas del mismo cliente o a cuentas de
   terceros.
6) Las transacciones monetarias se realizan sobre las cuentas del cliente.

### Restricciones del Modelado del Sistema de Gestión Bancaria:

✓ Banco tiene una o más sucursales <br>
✓ Cliente va a tener una o más cuentas, no necesariamente debe tener una CA <br>
✓ Cliente depende de una Sucursal <br>
✓ Las cuentas dependen del Cliente y pertenecen al Banco, no de la sucursal <br>
✓ Las cuentas son parte del Banco <br>
