package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que representa el menú principal de BioTiendApp
 * Permite navegar entre las diferentes funcionalidades del sistema
 */
public class GeneralMenu {
    // Referencia a la interfaz de usuario para gestionar productos
    private ProductUi productUi;
    
    // Referencia a la interfaz de usuario para gestionar proveedores
    private SupplierUi supplierUi;
    
    // Scanner para leer la entrada del usuario desde consola
    private Scanner scanner;
    
    // Bandera para controlar si ya se mostró el logo (evita mostrar el logo repetidamente)
    private boolean logoShown = false;

    /**
     * Constructor de la clase GeneralMenu
     * @param productUi Instancia de ProductUi para gestionar productos
     * @param supplierUi Instancia de SupplierUi para gestionar proveedores
     */
    public GeneralMenu(ProductUi productUi, SupplierUi supplierUi) {
        this.supplierUi = supplierUi;
        this.productUi = productUi;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método principal que ejecuta el bucle del menú
     * Muestra las opciones disponibles y procesa la selección del usuario
     */
    public void execute() {
        int option; // Variable para almacenar la opción seleccionada por el usuario
        
        // Bucle principal del menú que continúa hasta que el usuario seleccione salir (0)
        do {
            showMenu(); // Mostrar las opciones del menú
            option = getUserOption(); // Obtener la opción del usuario

            // Procesar la opción seleccionada
            switch (option) {
                case 1:
                    // Ejecutar el menú de gestión de proveedores
                    supplierUi.runSupplierMenu();
                    break;
                case 2:
                    // Ejecutar el menú de gestión de productos
                    productUi.runProductMenu();
                    break;
                case 0:
                    // Opción para salir del sistema
                    System.out.println("Gracias por utilizar el sistema.");
                    break;
                default:
                    // Manejo de opciones inválidas
                    System.out.println("Opción inválida, por favor intente nuevamente.");
                    break;
            }
        } while (option != 0); // Continuar mientras no se seleccione la opción de salir
        
        // Cerrar el scanner para liberar recursos
        scanner.close();
    }

    /**
     * Método privado que muestra el menú principal en consola
     * El logo solo se muestra la primera vez para evitar repetición
     */
    private void showMenu() {
        // Solo mostrar el logo la primera vez que se ejecuta el menú
        if (!logoShown) {
            System.out.println(logo()); // Mostrar el logo de la aplicación
            logoShown = true; // Marcar que el logo ya fue mostrado
        }

        // Mostrar las opciones del menú principal
        System.out.println("\n--- Menú General de BioTiendApp ---");
        System.out.println("1. Gestionar proveedores");
        System.out.println("2. Gestionar productos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Método privado que obtiene la opción seleccionada por el usuario
     * Incluye manejo de excepciones para entradas inválidas
     */
    private int getUserOption() {
        try {
            // Leer un número entero del usuario
            int option = scanner.nextInt();
            // Limpiar el buffer del scanner (consumir el salto de línea)
            scanner.nextLine();
            return option;
        } catch (InputMismatchException e) {
            // Manejo de excepción cuando el usuario ingresa un valor que no es un número
            System.out.println("Entrada inválida. Por favor, ingrese una opción válida.");
            // Limpiar el buffer del scanner para evitar bucles infinitos
            scanner.nextLine();
            // Retornar -1 para indicar entrada inválida
            return -1;
        }
    }

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
