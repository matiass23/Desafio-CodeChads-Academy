package com.codechads.service;
import com.codechads.model.Experimento;
import com.codechads.interfaces.IReportable;
import java.util.List;

public class ExperimentoService implements IReportable {

    private List<Experimento> experimentos;

    public ExperimentoService(List<Experimento> experimentos) {
        this.experimentos = experimentos;
    }

    public long contarExitosos() {
        return experimentos.stream()
                .filter(Experimento::isExitoso)
                .count();
    }

    public double promedioDuracion() {
        return experimentos.stream()
                .mapToInt(Experimento::getDuracionHoras)
                .average()
                .orElse(0.0);
    }

    @Override
    public void generarReporte() {
        System.out.println("----- REPORTE DE EXPERIMENTOS -----");
        experimentos.forEach(System.out::println);
        System.out.println("Total exitosos: " + contarExitosos());
        System.out.println("Promedio duración: " + promedioDuracion() + " horas");
        System.out.println("-----------------------------------");
    }
}
