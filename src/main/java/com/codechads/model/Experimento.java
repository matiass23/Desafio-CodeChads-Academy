package com.codechads.model;

public abstract class Experimento {
    protected String nombre;
    protected int duracionHoras;
    protected boolean exitoso;

    public Experimento(String nombre, int duracionHoras, boolean exitoso) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.exitoso = exitoso;
    }

    public String getNombre() { return nombre; }
    public int getDuracionHoras() { return duracionHoras; }
    public boolean isExitoso() { return exitoso; }

    // Metodo abstracto → las subclases deberán implementarlo
    public abstract String obtenerTipo();

    @Override
    public String toString() {
        return obtenerTipo() + " - " + nombre + " (" + duracionHoras + "h, Exitoso: " + exitoso + ")";
    }
}
