package com.codechads;
import com.codechads.model.*;
import com.codechads.service.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Experimento e1 = new ExperimentoFisico("Experimento de Gravedad", 5, true, 21.3);
        Experimento e2 = new ExperimentoFisico("Prueba de Friccion", 3, false, 18.0);
        Experimento e3 = new ExperimentoQuimico("Reaccion Acida", 4, true, "H2SO4");

        List<Experimento> lista = Arrays.asList(e1, e2, e3);

        ExperimentoService expService = new ExperimentoService(lista);
        expService.generarReporte();

        Investigador inv = new Investigador("Franco Matias Alarcon");
        inv.agregarExperimento(e1);
        inv.agregarExperimento(e2);
        inv.agregarExperimento(e3);

        InvestigadorService invService = new InvestigadorService(inv);
        invService.exportarDatos();
    }
}
