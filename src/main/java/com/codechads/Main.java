package com.codechads;
import com.codechads.model.*;
import com.codechads.service.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Experimento> experimentos = new ArrayList<>();
    private static ExperimentoService expService;
    private static Investigador investigador;
    private static InvestigadorService invService;

    public static void main(String[] args) {
        inicializarDatos();
        expService = new ExperimentoService(experimentos);
        invService = new InvestigadorService(investigador);

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Elige una opción: ");
            switch (opcion) {
                case 1 -> expService.generarReporte();
                case 2 -> mostrarInvestigador();
                case 3 -> opcionCrearExperimento();
                case 4 -> opcionAgregarExperimentoAInvestigador();
                case 5 -> invService.exportarDatos();
                case 6 -> mostrarEstadisticas();
                case 7 -> {
                    salir = true;
                }
                default -> System.out.println("Opción erronea, por favor vuelva a ingresar: ");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== MENU TPI - CodeChads Academy =====");
        System.out.println("1) Ver reporte global de experimentos");
        System.out.println("2) Mostrar investigador y sus experimentos");
        System.out.println("3) Crear nuevo experimento físico o químico");
        System.out.println("4) Agregar un experimento existente al investigador");
        System.out.println("5) Exportar datos del investigador");
        System.out.println("6) Ver estadísticas (exitosos, promedio duración)");
        System.out.println("7) Salir");
        System.out.println("========================================");
    }

    private static void inicializarDatos() {
        Experimento e1 = new ExperimentoFisico("Experimento de Gravedad", 5, true, 21.3);
        Experimento e2 = new ExperimentoFisico("Prueba de Fricción", 3, false, 18.0);
        Experimento e3 = new ExperimentoQuimico("Reacción Ácida", 4, true, "H2SO4");

        experimentos.add(e1);
        experimentos.add(e2);
        experimentos.add(e3);
        investigador = new Investigador("Franco Matias");
        investigador.agregarExperimento(e1);
    }

    private static int leerEntero(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String linea = scanner.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Por favor ingresá un número válido.");
            }
        }
    }

    private static double leerDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String linea = scanner.nextLine();
                return Double.parseDouble(linea.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Por favor ingresá un número decimal válido.");
            }
        }
    }

    private static String leerLinea(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void mostrarInvestigador() {
        System.out.println("Investigador: " + investigador.getNombre());
        System.out.println("Experimentos:");
        List<Experimento> list = investigador.getExperimentos();
        if (list.isEmpty()) {
            System.out.println("  (ninguno)");
        } else {
            int idx = 1;
            for (Experimento e : list) {
                System.out.println("  " + (idx++) + ") " + e);
            }
        }
    }

    private static void opcionCrearExperimento() {
        System.out.println("--- Crear Experimento ---");
        System.out.println("Tipo: 1) Físico  2) Químico");
        int tipo = leerEntero("Elegí tipo: ");
        String nombre = leerLinea("Nombre del experimento: ");
        int dur = leerEntero("Duración (horas): ");
        boolean exitoso = false;
        String exitoInput = leerLinea("¿Fue exitoso? (s/n): ");
        exitoso = exitoInput.equalsIgnoreCase("s") || exitoInput.equalsIgnoreCase("si");

        if (tipo == 1) {
            double temp = leerDouble("Temperatura (°C): ");
            ExperimentoFisico ef = new ExperimentoFisico(nombre, dur, exitoso, temp);
            experimentos.add(ef);
            System.out.println("Experimento físico creado.");
            preguntarAgregarAlInvestigador(ef);
        } else if (tipo == 2) {
            String reactivo = leerLinea("Reactivo principal: ");
            ExperimentoQuimico eq = new ExperimentoQuimico(nombre, dur, exitoso, reactivo);
            experimentos.add(eq);
            System.out.println("Experimento químico creado.");
            preguntarAgregarAlInvestigador(eq);
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void preguntarAgregarAlInvestigador(Experimento e) {
        String r = leerLinea("¿Querés agregar este experimento al investigador? (s/n): ");
        if (r.equalsIgnoreCase("s") || r.equalsIgnoreCase("si")) {
            investigador.agregarExperimento(e);
            System.out.println("Agregado al investigador.");
        }
    }

    private static void opcionAgregarExperimentoAInvestigador() {
        System.out.println("----Agregar experimento existente al investigador----");
        if (experimentos.isEmpty()) {
            System.out.println("No hay tal experimento en el sistema.");
            return;
        }
        System.out.println("Lista de experimentos disponibles:");
        for (int i = 0; i < experimentos.size(); i++) {
            System.out.println((i + 1) + ") " + experimentos.get(i));
        }
        int sel = leerEntero("Elegí el número del experimento para agregar: ");
        if (sel < 1 || sel > experimentos.size()) {
            System.out.println("Experimento inexistente");
            return;
        }
        Experimento elegido = experimentos.get(sel - 1);
        investigador.agregarExperimento(elegido);
        System.out.println("Experimento agregado al investigador: " + elegido.getNombre());
    }

    private static void mostrarEstadisticas() {
        System.out.println("---Estadísticas rápidas---");
        long exitosos = expService.contarExitosos();
        double prom = expService.promedioDuracion();
        System.out.println("Total de experimentos en el sistema: " + experimentos.size());
        System.out.println("Total de experimentos exitosos: " + exitosos);
        System.out.printf("Promedio de duración: %.2f horas%n", prom);
    }
}