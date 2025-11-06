package com.codechads.model;

public class ExperimentoFisico extends Experimento {
    private double temperatura;

    public ExperimentoFisico(String nombre, int duracionHoras, boolean exitoso, double temperatura) {
        super(nombre, duracionHoras, exitoso);
        this.temperatura = temperatura;
    }

    public double getTemperatura() { return temperatura; }

    @Override
    public String obtenerTipo() {
        return "Experimento Físico";
    }
}
