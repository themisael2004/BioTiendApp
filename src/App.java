import services.OrganicStoreServices;
import services.SupplierService;
import ui.GeneralMenu;
import ui.ProductUi;
import ui.SupplierUi;

public class App {
    

    public static void main(String[] args) throws Exception {
        
        // Limpiar la consola utilizando códigos ANSI
        // \033[H: Mueve el cursor a la posición inicial (esquina superior izquierda)
        // \033[2J: Borra toda la pantalla
        System.out.println("\033[H\033[2J");
        System.out.flush(); // Asegurar que los caracteres se escriban inmediatamente
        
        // Inicialización de servicios de negocio
        // Servicio principal para gestionar la tienda orgánica
        OrganicStoreServices organicStoreServices = new OrganicStoreServices();
        
        // Servicio específico para gestionar proveedores
        SupplierService supplierService = new SupplierService();
        
        // Inicialización de interfaces de usuario (UI)
        // Interfaz para gestionar proveedores, recibe el servicio de proveedores
        SupplierUi supplierUi = new SupplierUi(supplierService);
        
        // Interfaz para gestionar productos, requiere ambos servicios:
        // - organicStoreServices: para operaciones generales de productos
        // - supplierService: para asociar productos con proveedores
        ProductUi productUi = new ProductUi(organicStoreServices, supplierService);
        
        // Creación del menú principal que coordina todas las interfaces
        // Se le pasan las interfaces de productos y proveedores
        GeneralMenu generalMenu = new GeneralMenu(productUi, supplierUi);
        
        // Ejecutar el menú principal - inicia la aplicación
        // Este método contiene el bucle principal que mantiene la aplicación corriendo
        generalMenu.execute();
    }
}