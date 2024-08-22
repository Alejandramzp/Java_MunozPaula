
package facturacion;

import java.util.Scanner;

public class FacturacionService {

    public void crearNuevaFactura(Scanner scanner) {
        // Solicitar ID del cliente
        System.out.print("ID del cliente: ");
        int clienteId = scanner.nextInt();

        // Obtener el cliente de la base de datos
        Cliente cliente = Cliente.obtenerClientePorId(clienteId);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        // Crear la nueva factura
        Factura factura = new Factura(cliente);

        // Agregar productos a la factura
        boolean agregarMasProductos = true;
        while (agregarMasProductos) {
            System.out.print("ID del producto: ");
            int productoId = scanner.nextInt();
            Producto producto = Producto.obtenerProductoPorId(productoId);

            if (producto != null) {
                System.out.print("Cantidad: ");
                int cantidad = scanner.nextInt();
                factura.agregarProducto(producto, cantidad);
                System.out.println("Producto agregado a la factura.");
            } else {
                System.out.println("Producto no encontrado.");
            }

            // Preguntar si desea agregar otro producto
            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String respuesta = scanner.next();
            agregarMasProductos = respuesta.equalsIgnoreCase("s");
        }

        // Aplicar descuentos
        System.out.println("¿Desea aplicar algún descuento?");
        System.out.println("1. Descuento VIP");
        System.out.println("2. Descuento por Monto");
        System.out.println("3. No aplicar descuento");

        int opcionDescuento = scanner.nextInt();
        switch (opcionDescuento) {
            case 1:
                factura.calcularTotalConDescuento(Descuentos.descuentoVIP());
                System.out.println("Descuento VIP aplicado.");
                break;
            case 2:
                factura.calcularTotalConDescuento(Descuentos.descuentoPorMonto());
                System.out.println("Descuento por Monto aplicado.");
                break;
            case 3:
                factura.calcularTotalConDescuento(total -> total); // No aplicar descuento
                System.out.println("No se aplicó ningún descuento.");
                break;
            default:
                factura.calcularTotalConDescuento(total -> total); // No aplicar descuento
                System.out.println("Opción no válida, no se aplicará ningún descuento.");
        }

        // Guardar la factura en la base de datos
        factura.guardarFactura();

        // Mostrar la factura final con el total
        factura.mostrarFactura();

        System.out.println("Factura creada exitosamente.");
    }

    // Implementación de los métodos insertarNuevoCliente y insertarNuevoProducto
    public void insertarNuevoCliente(Scanner scanner) {
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.next();
        System.out.print("Tipo de cliente (Regular, VIP, etc.): ");
        String tipo = scanner.next();

        Cliente cliente = new Cliente(0, nombre, tipo);
        cliente.insertarCliente();
        System.out.println("Cliente insertado exitosamente.");
    }

    public void insertarNuevoProducto(Scanner scanner) {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.next();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(0, nombre, precio);
        producto.insertarProducto();
        System.out.println("Producto insertado exitosamente.");
    }
}