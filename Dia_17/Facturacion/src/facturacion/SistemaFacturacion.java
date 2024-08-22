
package facturacion;

import java.util.Scanner;

public class SistemaFacturacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FacturacionService facturacionService = new FacturacionService();
        
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    facturacionService.insertarNuevoCliente(scanner);
                    break;
                case 2:
                    facturacionService.insertarNuevoProducto(scanner);
                    break;
                case 3:
                    facturacionService.crearNuevaFactura(scanner);
                    break;
                case 4:
                    Cliente.listarClientes();
                    break;
                case 5:
                    Producto.listarProductos();
                    break;
                case 6:
                    Factura.listarFacturas();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Insertar Nuevo Cliente");
        System.out.println("2. Insertar Nuevo Producto");
        System.out.println("3. Crear Nueva Factura");
        System.out.println("4. Listar Clientes");
        System.out.println("5. Listar Productos");
        System.out.println("6. Listar Facturas");
        System.out.println("0. Salir");
    }
}