package paradigmas.desafio;

import java.util.Arrays;

public class Estudiante {
    private String nombre;
    private int[] notas = new int[5];

public Estudiante(String nombre, int n1, int n2, int n3) {
    this.nombre = nombre;
    this.notas[0] = n1;
    this.notas[1] = n2;
    this.notas[2] = n3;
    calcularNotasRestantes();
    }    

    private void calcularNotasRestantes() {
        if (notas[1] < 60)
            notas[3] = 100;
        else
            notas[3] = notas[1];
        if (notas[0] + notas[2] > 150)
            notas[4] = 95;
        else
            notas[4] = 70;
    }

    public String getNombre() { return nombre; }
    public int[] getNotas() { return notas; }

    public int total() {
        int suma = 0;
        for (int n : notas) suma += n;
        return suma;
    }

    public double promedio() {
        return (double) total() / notas.length;
    }

    public boolean aproboTodas() {
        for (int n : notas) if (n < 60) return false;
        return true;
    }

    public boolean noAproboNinguna() {
        for (int n : notas) if (n >= 60) return false;
        return true;
    }

    public boolean algunasAprobadas() {
        return !aproboTodas() && !noAproboNinguna();
    }

    public int mayorVariacion() {
        int maxDiff = 0, indice = -1;
        for (int i = 0; i < notas.length - 1; i++) {
            int diff = Math.abs(notas[i + 1] - notas[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
                indice = i;
            }
        }
        System.out.println("Mayor salto fue de " + maxDiff + " puntos entre prueba " + (indice + 1) + " y " + (indice + 2));
        return maxDiff;
    }

    public boolean esProgresivo() {
        for (int i = 0; i < notas.length - 1; i++)
            if (notas[i + 1] <= notas[i]) return false;
        return true;
    }

    public void ordenarNotasDesc() {
        for (int i = 0; i < notas.length - 1; i++) {
            for (int j = i + 1; j < notas.length; j++) {
                if (notas[j] > notas[i]) {
                    int aux = notas[i];
                    notas[i] = notas[j];
                    notas[j] = aux;
                }
            }
        }
    }

    public String nivelFinal() {
        int total = total();
        if (total < 250) return "Normie total 😢";
        else if (total < 350) return "Soft Chad";
        else if (total < 450) return "Chad";
        else return "Stone Chad definitivo 💪";
    }

    public void mostrarNotas() {
        System.out.println("Notas de " + nombre + ": " + Arrays.toString(notas));
    }
}