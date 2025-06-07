package ui;

import services.SupplierService;
import model.Supplier.Supplier;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SupplierUi {
    private final SupplierService supplierService;
    private final Scanner scanner;

    public SupplierUi(SupplierService supplierService) {
        this.supplierService = supplierService;
        this.scanner = new Scanner(System.in);
    }

    public void runSupplierMenu() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    createSupplierFlow();
                    break;
                case 2:
                    listAllSuppliersFlow();
                    break;
                case 3:
                    searchById();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (choice != 0);
    }

    private void displayMenu() {
        System.out.println("\n--- Menú Principal de Gestión de Proveedores ---");
        System.out.println("1. Crear Nuevo Proveedor");
        System.out.println("2. Listar Todos los Proveedores");
        System.out.println("3. Buscar Proveedor por ID");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void createSupplierFlow() {
        System.out.println("\n--- Crear Nuevo Proveedor ---");

        System.out.print("¿Es proveedor [I]nternacional o [L]ocal? (I/L): ");
        String typeChoice = scanner.nextLine();

        System.out.print("Nombre del proveedor: ");
        String name = scanner.nextLine();

        System.out.print("Dirección: ");
        String direction = scanner.nextLine();

        System.out.print("Ciudad: ");
        String city = scanner.nextLine();

        System.out.print("País: ");
        String country = scanner.nextLine();

        System.out.print("Contacto (email/teléfono): ");
        String contact = scanner.nextLine();

        if (typeChoice.equalsIgnoreCase("I")) {
            System.out.print("Código de país internacional (ISO): ");
            String isoCountryCode = scanner.nextLine();
            supplierService.createInternacionalSupplier(name, direction, city, country, contact, isoCountryCode);

        } else if (typeChoice.equalsIgnoreCase("L")) {
            System.out.print("Tipo de producto que provee: ");
            String supplierProductType = scanner.nextLine();

            System.out.print("Código regional: ");
            String regionalCode = scanner.nextLine();

            supplierService.createLocalSupplier(name, supplierProductType, direction, city, country, contact, regionalCode);

        } else {
            System.out.println("Tipo de proveedor inválido. El proveedor no fue creado.");
        }
    }

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
