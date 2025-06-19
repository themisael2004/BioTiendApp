package ui;

import java.util.Scanner;

// Clase utilitaria para funciones relacionadas con la consola
public class ConsoleUtils {

    // Método para limpiar la consola, compatible con Windows y otros sistemas operativos
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // Ejecuta el comando 'cls' en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Usa secuencias ANSI en otros sistemas
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("No se pudo limpiar la consola: " + e.getMessage());
        }
    }

    // Método para pausar la ejecución hasta que el usuario presione Enter
    public static void pause() {
        System.out.println("Presione Enter para continuar...");
        new Scanner(System.in).nextLine();
    }

    // Método que devuelve el logo ASCII de la aplicación
    public static String getLogo() {
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
