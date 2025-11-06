package com.codechads.service;

import com.codechads.model.Investigador;
import com.codechads.model.Experimento;
import com.codechads.interfaces.IExportable;

public class InvestigadorService implements IExportable {

    private Investigador investigador;

    public InvestigadorService(Investigador investigador) {
        this.investigador = investigador;
    }

    @Override
    public void exportarDatos() {
        System.out.println("Exportando datos del investigador: " + investigador.getNombre());
        for (Experimento exp : investigador.getExperimentos()) {
            System.out.println("- " + exp);
        }
    }
}

