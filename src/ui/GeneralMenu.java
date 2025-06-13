package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menú principal de la aplicación BioTiendApp.
 * Permite acceder a gestión de proveedores y productos.
 */
public class GeneralMenu {
    private ProductUi productUi; // Gestión de productos
    private SupplierUi supplierUi; // Gestión de proveedores
    private Scanner scanner; // Entrada por consola
    private boolean logoShown = false; // Control para mostrar logo solo una vez

    public GeneralMenu(ProductUi productUi, SupplierUi supplierUi) {
        this.productUi = productUi;
        this.supplierUi = supplierUi;
        this.scanner = new Scanner(System.in);
    }

    // Ejecuta el menú principal en bucle hasta que el usuario salga
    public void execute() {
        int option;
        do {
            showMenu();
            option = getUserOption();
            switch (option) {
                case 1 -> supplierUi.runSupplierMenu();
                case 2 -> productUi.runProductMenu();
                case 0 -> System.out.println("Gracias por utilizar el sistema.");
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (option != 0);
        scanner.close();
    }

    // Muestra las opciones y el logo (solo la primera vez)
    private void showMenu() {
        if (!logoShown) {
            System.out.println(logo());
            logoShown = true;
        }
        System.out.println("\n--- Menú General de BioTiendApp ---");
        System.out.println("1. Gestionar proveedores");
        System.out.println("2. Gestionar productos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Captura y valida la opción del usuario
    private int getUserOption() {
        try {
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            return option;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor ingrese un número.");
            scanner.nextLine(); // Limpiar buffer
            return -1;
        }
    }

    // Logo ASCII de la aplicación
    private String logo() {
        return """
                ██████╗ ██╗ ██████╗ ████████╗██╗███████╗███╗   ██╗██████╗  █████╗ ██████╗ ██████╗
                ██╔══██╗██║██╔═══██╗╚══██╔══╝██║██╔════╝████╗  ██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗
                ██████╔╝██║██║   ██║   ██║   ██║█████╗  ██╔██╗ ██║██║  ██║███████║██████╔╝██████╔╝
                ██╔══██╗██║██║   ██║   ██║   ██║██╔══╝  ██║╚██╗██║██║  ██║██╔══██║██╔═══╝ ██╔═══╝
                ██████╔╝██║╚██████╔╝   ██║   ██║███████╗██║ ╚████║██████╔╝██║  ██║██║     ██║
                ╚═════╝ ╚═╝ ╚═════╝    ╚═╝   ╚═╝╚══════╝╚═╝  ╚═══╝╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝
                """;
    }
}
