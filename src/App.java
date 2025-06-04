import services.SupplierService;
import ui.SupplierUi;

public class App {
    public static void main(String[] args) throws Exception {
          SupplierService supplierService = new SupplierService();

        SupplierUi suplierUi = new SupplierUi(supplierService);

        // 3. Iniciar la interfaz de usuario
        suplierUi.runSupplierMenu();
    }
}
