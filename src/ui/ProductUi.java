package ui;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Product.OrganicProduct;
import services.OrganicStoreServices;
import services.SupplierService;

// Clase de interfaz de usuario para la gestión de productos orgánicos.
public class ProductUi {

    // Servicio para gestionar productos orgánicos */
    private OrganicStoreServices organicStoreServices;

    // Servicio para gestionar proveedores */
    private SupplierService supplierService;

    // Scanner para capturar entrada del usuario desde consola */
    private Scanner scanner;

    // Constructor que inicializa la interfaz de usuario con los servicios
    // necesarios.
    public ProductUi(OrganicStoreServices organicStoreServices, SupplierService supplierService) {
        this.supplierService = supplierService;
        this.organicStoreServices = organicStoreServices;
        this.scanner = new Scanner(System.in);
    }

    // Método principal que ejecuta el menú de productos.
    public void runProductMenu() {
        int option;
        do {
            displayMenu(); // Mostrar opciones disponibles
            option = getUserOption(); // Capturar selección del usuario

            // Procesar la opción seleccionada
            switch (option) {
                case 1:
                    createProductFlow(); // Crear nuevo producto
                    break;
                case 2:
                    listAllOrganicProductFlow(); // Listar todos los productos
                    break;
                case 3:
                    deleteOrganicProductFlow(); // Eliminar producto
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente nuevamente.");
                    break;
            }
        } while (option != 0); // Continuar hasta que el usuario elija salir
    }

    // Muestra el menú principal de opciones para gestión de productos.
    public void displayMenu() {
        System.out.println("\n--- Menú Principal de Gestión de Productos ---");
        System.out.println("1. Crear Nuevo Producto");
        System.out.println("2. Listar Todos los Productos");
        System.out.println("3. Eliminar Producto");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Captura y valida la opción seleccionada por el usuario.
    private int getUserOption() {
        try {
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer de entrada
            return option;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese una opción válida.");
            scanner.nextLine(); // Limpiar buffer tras excepción
            return -1; // Retornar valor que active el default del switch
        }
    }

    // Flujo para crear un nuevo producto orgánico.
    public void createProductFlow() {
        System.out.println("\n--- Crear Nuevo Producto ---");

        // Determinar tipo de producto (Fruta o Vegetal)
        System.out.print("Tipo de Producto (Fruta(F) / Verdura(V)): ");
        String typeProductInput = scanner.nextLine().toUpperCase();

        String typeProduct = "";
        if (typeProductInput.equals("F")) {
            typeProduct = "Fruta";
        } else if (typeProductInput.equals("V")) {
            typeProduct = "Vegetal";
        } else {
            System.out.println("Tipo de producto inválido. El producto no fue creado.");
            return; // Salir del método si el tipo no es válido
        }

        // Solicitar tipo específico según el producto
        String specificType;
        if (typeProduct.equals("Fruta")) {
            System.out.print("Tipo de Fruta (Ej. Tropicales, Citricos, Drupas): ");
        } else {
            System.out.print("Tipo de Verdura (Ej. Raiz, Hoja, Tallo): ");
        }
        specificType = scanner.nextLine();

        // Capturar nombre del producto
        System.out.print("Nombre del Producto: ");
        String nameProduct = scanner.nextLine();

        // Validar y capturar ID del proveedor
        int idSupplier = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("ID del Proveedor: ");
                idSupplier = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                // Verificar que el proveedor existe
                model.Supplier.Supplier supplier = supplierService.getSupplierById(idSupplier);
                if (supplier == null) {
                    System.out.println("El ID del proveedor ingresado no existe.");
                } else {
                    validInput = true; // Proveedor válido encontrado
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.nextLine(); // Limpiar buffer tras excepción
            }
        }

        // Validar y capturar precio del producto
        double price = -1;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Precio del Producto: ");
                price = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar buffer tras excepción
            }
        }

        // Validar y capturar días de frescura
        int freshnessDays = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Días de Frescura: ");
                freshnessDays = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.nextLine(); // Limpiar buffer tras excepción
            }
        }

        // Establecer fecha de admisión como el momento actual
        LocalDateTime dateAdmission = LocalDateTime.now();

        // Crear el producto a través del servicio
        organicStoreServices.createProduct(typeProduct, nameProduct, idSupplier,
                dateAdmission, "Orgánico", price, specificType, freshnessDays);

        System.out.println("Producto creado exitosamente.");
    }

    // Flujo para listar todos los productos orgánicos registrados.

    private void listAllOrganicProductFlow() {
        System.out.println("\n--- Listado de Todos los Productos ---");
        List<OrganicProduct> allOrganicProducts = organicStoreServices.getAllOrganicProducts();

        // Verificar si existen productos registrados
        if (allOrganicProducts.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            // Mostrar detalles de cada producto
            for (OrganicProduct s : allOrganicProducts) {
                System.out.println(s.getDetails()); // Llamar al método getDetails() de cada producto
            }
        }
    }

    // Flujo para eliminar un producto del inventario.
    public void deleteOrganicProductFlow() {
        System.out.println("\n--- Eliminar Producto ---");
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nameProduct = scanner.nextLine();

        // Intentar eliminar el producto
        OrganicProduct deletedProduct = organicStoreServices.deleteOrganicProduct(nameProduct);

        // Informar resultado de la operación
        if (deletedProduct != null) {
            System.out.println("Producto eliminado: " + deletedProduct.getNameProduct());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}