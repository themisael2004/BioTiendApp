package ui;

import services.SupplierService;
import model.Supplier.Supplier;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Clase encargada de la interacción con el usuario para gestionar proveedores
public class SupplierUi {
    private final SupplierService supplierService; // Lógica de negocio de proveedores
    private final Scanner scanner; // Entrada por consola

    public SupplierUi(SupplierService supplierService) {
        this.supplierService = supplierService;
        this.scanner = new Scanner(System.in);
    }

    // Método que ejecuta el menú de proveedores de forma interactiva
    public void runSupplierMenu() {
        int choice;
        do {
            ConsoleUtils.clearConsole(); // Limpia consola antes del menú
            displayMenu(); // Muestra el menú
            choice = getUserChoice(); // Captura opción del usuario

            // Ejecuta acción según la opción ingresada
            switch (choice) {
                case 1 -> createSupplierFlow();
                case 2 -> listAllSuppliersFlow();
                case 3 -> searchById();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

            // Pausa para permitir leer la salida
             if (choice != 0) {
                System.out.println("Presione Enter para continuar...");
                scanner.nextLine(); // Espera que el usuario presione Enter
            }

        } while (choice != 0);
    }

    // Muestra el menú de opciones
    private void displayMenu() {
        System.out.println("\n--- Menú Principal de Gestión de Proveedores ---");
        System.out.println("1. Crear Nuevo Proveedor");
        System.out.println("2. Listar Todos los Proveedores");
        System.out.println("3. Buscar Proveedor por ID");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Flujo para crear un nuevo proveedor (local o internacional)
    private void createSupplierFlow() {
        ConsoleUtils.clearConsole();
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

        // Crear proveedor según tipo seleccionado
        if (typeChoice.equalsIgnoreCase("I")) {
            System.out.print("Código de país internacional (ISO): ");
            String isoCountryCode = scanner.nextLine();

            supplierService.createInternacionalSupplier(name, supplierProductType, direction, city, country, contact, isoCountryCode);

        } else if (typeChoice.equalsIgnoreCase("L")) {
            System.out.print("Código regional: ");
            String regionalCode = scanner.nextLine();

            supplierService.createLocalSupplier(name, supplierProductType, direction, city, country, contact, regionalCode);

        } else {
            System.out.println("Tipo de proveedor inválido. El proveedor no fue creado.");
        }
    }

    // Captura y valida la opción numérica del usuario
    private int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine();
            return -1;
        }
    }

    // Muestra todos los proveedores registrados
    private void listAllSuppliersFlow() {
        ConsoleUtils.clearConsole();
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

    // Busca un proveedor por su ID
    private void searchById() {
        ConsoleUtils.clearConsole();
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
