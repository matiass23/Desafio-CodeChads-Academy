package com.codechads.model;
import java.util.ArrayList;
import java.util.List;

public class Investigador {
    private String nombre;
    private List<Experimento> experimentos;

    public Investigador(String nombre) {
        this.nombre = nombre;
        this.experimentos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    public void agregarExperimento(Experimento e) {
        experimentos.add(e);
    }

    public List<Experimento> getExperimentos() {
        return experimentos;
    }
}
