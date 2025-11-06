package com.codechads.model;

public class ExperimentoQuimico extends Experimento {
    private String reactivoPrincipal;

    public ExperimentoQuimico(String nombre, int duracionHoras, boolean exitoso, String reactivoPrincipal) {
        super(nombre, duracionHoras, exitoso);
        this.reactivoPrincipal = reactivoPrincipal;
    }

    public String getReactivoPrincipal() { return reactivoPrincipal; }

    @Override
    public String obtenerTipo() {
        return "Experimento Químico";
    }
}
