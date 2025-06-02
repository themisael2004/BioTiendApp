package ui;

import services.SupplierService;
import model.Supplier.Supplier;
import java.util.List;
import java.util.Scanner;

public class SupplierUi {
    private final SupplierService supplierService;
    private final Scanner scanner;

    public SupplierUi(SupplierService supplierService) {
        this.supplierService = supplierService;
        this.scanner = new Scanner(System.in);
    }

    public void showSupplierMenu() {
        int option;
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear proveedor local");
            System.out.println("2. Crear proveedor internacional");
            System.out.println("3. Listar proveedores");
            System.out.println("4. Buscar por país");
            System.out.println("5. Buscar por ID");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    createLocalSupplier();
                    break;
                case 2:
                    createInternationalSupplier();
                    break;
                case 3:
                    listSuppliers();
                    break;
                case 4:
                    searchByCountry();
                    break;
                case 5:
                    searchById();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (option != 6);
    }

    private void createLocalSupplier() {
        System.out.println("=== NUEVO PROVEEDOR LOCAL ===");
        
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        
        System.out.print("Dirección: ");
        String direction = scanner.nextLine();
        
        System.out.print("Ciudad: ");
        String city = scanner.nextLine();
        
        System.out.print("País: ");
        String country = scanner.nextLine();
        
        System.out.print("Contacto: ");
        String contact = scanner.nextLine();
        
        System.out.print("Código Regional: ");
        String regionalCode = scanner.nextLine();

        supplierService.createLocalSupplier(id, name, description, direction, city, country, contact, regionalCode);
        System.out.println("Proveedor local registrado");
    }

    private void createInternationalSupplier() {
        System.out.println("=== NUEVO PROVEEDOR INTERNACIONAL ===");
        
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        
        System.out.print("Dirección: ");
        String direction = scanner.nextLine();
        
        System.out.print("Ciudad: ");
        String city = scanner.nextLine();
        
        System.out.print("País: ");
        String country = scanner.nextLine();
        
        System.out.print("Contacto: ");
        String contact = scanner.nextLine();
        
        System.out.print("Código ISO: ");
        String isoCode = scanner.nextLine();

        supplierService.createInternacionalSupplier(id, name, direction, city, country, contact, isoCode);
        System.out.println("Proveedor internacional registrado");
    }

    private void listSuppliers() {
        List<Supplier> suppliers = supplierService.getALLSuppliers();
        System.out.println("=== LISTA DE PROVEEDORES ===");
        for (Supplier supplier : suppliers) {
            System.out.println(supplier.getDetails());
        }
    }

    private void searchByCountry() {
        System.out.print("País a buscar: ");
        String country = scanner.nextLine();
        
        List<Supplier> results = supplierService.getALLSuppliers();
        System.out.println("=== RESULTADOS ===");
        for (Supplier supplier : results) {
            if (supplier.getSupplierCountry().equalsIgnoreCase(country)) {
                System.out.println(supplier.getDetails());
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

    public static void main(String[] args) {
        new SupplierUi(new SupplierService()).showSupplierMenu();
    }
}
