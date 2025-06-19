import services.OrganicStoreServices;
import services.SupplierService;
import ui.GeneralMenu;
import ui.ProductUi;
import ui.SupplierUi;

public class App {

    public static void main(String[] args) throws Exception {
        // Limpiar consola con secuencias ANSI para mejor visualización
        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Inicializar servicios de negocio
        OrganicStoreServices organicStoreServices = new OrganicStoreServices();
        SupplierService supplierService = new SupplierService();

        // Inicializar interfaces de usuario (UI)
        SupplierUi supplierUi = new SupplierUi(supplierService);
        ProductUi productUi = new ProductUi(organicStoreServices, supplierService);

        // Crear y ejecutar menú principal con las UIs de productos y proveedores
        GeneralMenu generalMenu = new GeneralMenu(productUi, supplierUi);
        generalMenu.execute();
    }
}