package ui;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Product.OrganicProduct;
import services.OrganicStoreServices;
import services.SupplierService;

// Clase que representa la interfaz de usuario para gestionar productos orgánicos
public class ProductUi {

    private OrganicStoreServices organicStoreServices; // Servicio de productos
    private SupplierService supplierService; // Servicio de proveedores
    private Scanner scanner; // Entrada por consola

    // Constructor que inicializa los servicios requeridos
    public ProductUi(OrganicStoreServices organicStoreServices, SupplierService supplierService) {
        this.supplierService = supplierService;
        this.organicStoreServices = organicStoreServices;
        this.scanner = new Scanner(System.in);
    }

    // Método que ejecuta el menú de productos
    public void runProductMenu() {
        int option;
        do {
            ConsoleUtils.clearConsole(); // Limpia consola
            displayMenu(); // Muestra opciones
            option = getUserOption(); // Captura opción

            switch (option) {
                case 1 -> createProductFlow(); // Crear nuevo producto
                case 2 -> listAllOrganicProductFlow(); // Listar productos
                case 3 -> deleteOrganicProductFlow(); // Eliminar producto
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida, por favor intente nuevamente.");
            }

             if (option != 0) {
                System.out.println("Presione Enter para continuar...");
                scanner.nextLine(); // Espera que el usuario presione Enter
            }
        } while (option != 0);
    }

    // Muestra el menú de opciones en consola
    public void displayMenu() {
        System.out.println("\n--- Menú Principal de Gestión de Productos ---");
        System.out.println("1. Crear Nuevo Producto");
        System.out.println("2. Listar Todos los Productos");
        System.out.println("3. Eliminar Producto");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Obtiene y valida la opción ingresada por el usuario
    private int getUserOption() {
        try {
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpia buffer
            return option;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese una opción válida.");
            scanner.nextLine();
            return -1;
        }
    }

    // Flujo para crear un nuevo producto
    public void createProductFlow() {
        ConsoleUtils.clearConsole();
        System.out.println("\n--- Crear Nuevo Producto ---");

        System.out.print("Tipo de Producto (Fruta(F) / Verdura(V)): ");
        String typeProductInput = scanner.nextLine().toUpperCase();

        String typeProduct = "";
        if (typeProductInput.equals("F")) {
            typeProduct = "Fruta";
        } else if (typeProductInput.equals("V")) {
            typeProduct = "Vegetal";
        } else {
            System.out.println("Tipo de producto inválido. El producto no fue creado.");
            return;
        }

        // Solicita tipo específico
        String specificType;
        if (typeProduct.equals("Fruta")) {
            System.out.print("Tipo de Fruta (Ej. Tropicales, Cítricos, Drupas): ");
        } else {
            System.out.print("Tipo de Verdura (Ej. Raíz, Hoja, Tallo): ");
        }
        specificType = scanner.nextLine();

        System.out.print("Nombre del Producto: ");
        String nameProduct = scanner.nextLine();

        // Validación del ID de proveedor
        int idSupplier = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("ID del Proveedor: ");
                idSupplier = scanner.nextInt();
                scanner.nextLine();

                model.Supplier.Supplier supplier = supplierService.getSupplierById(idSupplier);
                if (supplier == null) {
                    System.out.println("El ID del proveedor ingresado no existe.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.nextLine();
            }
        }

        // Validación: precio debe ser mayor a 0
        double price = -1;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Precio del Producto: ");
                price = scanner.nextDouble();
                scanner.nextLine();
                if (price <= 0) {
                    System.out.println("El precio debe ser mayor que 0.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Ingrese un número decimal.");
                scanner.nextLine();
            }
        }

        // Validación: frescura debe ser mayor a 0
        int freshnessDays = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Días de Frescura: ");
                freshnessDays = scanner.nextInt();
                scanner.nextLine();
                if (freshnessDays <= 0) {
                    System.out.println("Los días de frescura deben ser mayores que 0.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
                scanner.nextLine();
            }
        }

        LocalDateTime dateAdmission = LocalDateTime.now();

        organicStoreServices.createProduct(
            typeProduct, nameProduct, idSupplier,
            dateAdmission, "Orgánico", price, specificType, freshnessDays
        );
    }

    // Muestra todos los productos orgánicos registrados
    private void listAllOrganicProductFlow() {
        ConsoleUtils.clearConsole();
        System.out.println("\n--- Listado de Todos los Productos ---");
        List<OrganicProduct> allOrganicProducts = organicStoreServices.getAllOrganicProducts();

        if (allOrganicProducts.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (OrganicProduct s : allOrganicProducts) {
                System.out.println(s.getDetails());
            }
        }
    }

    // Elimina un producto por su nombre
    public void deleteOrganicProductFlow() {
        ConsoleUtils.clearConsole();
        System.out.println("\n--- Eliminar Producto ---");
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nameProduct = scanner.nextLine();

        OrganicProduct deletedProduct = organicStoreServices.deleteOrganicProduct(nameProduct);

        if (deletedProduct != null) {
            System.out.println("Producto eliminado: " + deletedProduct.getNameProduct());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
