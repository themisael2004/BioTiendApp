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

    public GeneralMenu(ProductUi productUi, SupplierUi supplierUi) {
        this.productUi = productUi;
        this.supplierUi = supplierUi;
        this.scanner = new Scanner(System.in);
    }

    // Ejecuta el menú principal en bucle hasta que el usuario salga
    public void execute() {
        int option;
        ConsoleUtils.clearConsole(); // Limpiar consola una vez al inicio
        do {
            showMenu(); // Mostrar menú con logo
            option = getUserOption(); // Leer opción del usuario
            switch (option) {
                case 1 -> {
                    ConsoleUtils.clearConsole();
                    supplierUi.runSupplierMenu(); // Ir a gestión de proveedores
                    ConsoleUtils.clearConsole();
                }
                case 2 -> {
                    ConsoleUtils.clearConsole();
                    productUi.runProductMenu(); // Ir a gestión de productos
                    ConsoleUtils.clearConsole();
                }
                case 0 -> System.out.println("Gracias por utilizar el sistema.");
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (option != 0);
        scanner.close(); // Cerrar scanner al finalizar
    }

    // Muestra el logo y las opciones del menú principal
    private void showMenu() {
        System.out.println(ConsoleUtils.getLogo());
        System.out.println("\n--- Menú General de BioTiendApp ---");
        System.out.println("1. Gestionar proveedores");
        System.out.println("2. Gestionar productos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Captura y valida la opción ingresada por el usuario
    private int getUserOption() {
        try {
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            return option;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor ingrese un número.");
            scanner.nextLine();
            return -1;
        }
    }
}
