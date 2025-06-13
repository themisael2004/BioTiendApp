package ui;

import services.SupplierService;
import model.Supplier.Supplier;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Clase de interfaz de usuario para la gestión de proveedores.
public class SupplierUi {
    // Servicio que contiene la lógica de gestión de proveedores
    private final SupplierService supplierService;

    // Scanner para capturar entradas del usuario por consola
    private final Scanner scanner;

    // Constructor que inicializa la interfaz con el servicio de proveedores
    public SupplierUi(SupplierService supplierService) {
        this.supplierService = supplierService;
        this.scanner = new Scanner(System.in);
    }

    // Método principal que ejecuta el menú interactivo hasta que el usuario decida
    public void runSupplierMenu() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    createSupplierFlow(); // Crear proveedor
                    break;
                case 2:
                    listAllSuppliersFlow(); // Listar todos los proveedores
                    break;
                case 3:
                    searchById(); // Buscar proveedor por ID
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (choice != 0);
    }

    // Muestra el menú de opciones en consola
    private void displayMenu() {
        System.out.println("\n--- Menú Principal de Gestión de Proveedores ---");
        System.out.println("1. Crear Nuevo Proveedor");
        System.out.println("2. Listar Todos los Proveedores");
        System.out.println("3. Buscar Proveedor por ID");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Flujo de creación de un nuevo proveedor (local o internacional)
    private void createSupplierFlow() {
        System.out.println("\n--- Crear Nuevo Proveedor ---");

        System.out.print("¿Es proveedor [I]nternacional o [L]ocal? (I/L): ");
        String typeChoice = scanner.nextLine();

        System.out.print("Nombre del proveedor: ");
        String name = scanner.nextLine();

        System.out.print("Tipo de producto que provee: ");
        String supplierProductType = scanner.nextLine();

        System.out.print("Dirección: ");
        String direction = scanner.nextLine();

        System.out.print("Ciudad: ");
        String city = scanner.nextLine();

        System.out.print("País: ");
        String country = scanner.nextLine();

        System.out.print("Contacto (email/teléfono): ");
        String contact = scanner.nextLine();

        // Proveedor internacional
        if (typeChoice.equalsIgnoreCase("I")) {
            System.out.print("Código de país internacional (ISO): ");
            String isoCountryCode = scanner.nextLine();

            supplierService.createInternacionalSupplier(
                    name, supplierProductType, direction, city, country, contact, isoCountryCode);

            // Proveedor local
        } else if (typeChoice.equalsIgnoreCase("L")) {
            System.out.print("Código regional: ");
            String regionalCode = scanner.nextLine();

            supplierService.createLocalSupplier(
                    name, supplierProductType, direction, city, country, contact, regionalCode);

            // Entrada inválida
        } else {
            System.out.println("Tipo de proveedor inválido. El proveedor no fue creado.");
        }
    }

    // Lee la opción numérica ingresada por el usuario, validando errores

    private int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer
            return choice;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine(); // limpiar entrada incorrecta
            return -1;
        }
    }

    // Muestra todos los proveedores registrados en el sistema
    private void listAllSuppliersFlow() {
        System.out.println("\n--- Listado de Todos los Proveedores ---");
        List<Supplier> allSuppliers = supplierService.getALLSuppliers();

        if (allSuppliers.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            for (Supplier s : allSuppliers) {
                System.out.println(s.getDetails());
            }
        }
    }

    // Permite buscar un proveedor por su ID

    private void searchById() {
        System.out.print("ID a buscar: ");
        int id = Integer.parseInt(scanner.nextLine());

        List<Supplier> suppliers = supplierService.getALLSuppliers();
        for (Supplier supplier : suppliers) {
            if (supplier.getIdSupplier() == id) {
                System.out.println(supplier.getDetails());
                return;
            }
        }
        System.out.println("No encontrado");
    }
}
