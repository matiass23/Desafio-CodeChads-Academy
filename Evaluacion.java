package paradigmas.desafio;

public class Evaluacion {
    private Estudiante[] estudiantes;

    public Evaluacion() {
        estudiantes = new Estudiante[4];
        estudiantes[0] = new Estudiante("Franco", 5, 75, 90);
        estudiantes[1] = new Estudiante("Mati", 60, 40, 80);
        estudiantes[2] = new Estudiante("Ian", 90, 95, 88);
        estudiantes[3] = new Estudiante("Sofi", 50, 55, 60);
    }

    public Estudiante mejorPromedio() {
        Estudiante mejor = estudiantes[0];
        for (Estudiante e : estudiantes)
            if (e.promedio() > mejor.promedio()) mejor = e;
        return mejor;
    }

    public Estudiante masRegular() {
        Estudiante masConstante = estudiantes[0];
        double minDesv = desviacion(estudiantes[0]);

        for (Estudiante e : estudiantes) {
            double desv = desviacion(e);
            if (desv < minDesv) {
                minDesv = desv;
                masConstante = e;
            }
        }
        return masConstante;
    }

    private double desviacion(Estudiante e) {
        int[] notas = e.getNotas();
        double prom = e.promedio();
        double suma = 0;
        for (int n : notas)
            suma += Math.pow(n - prom, 2);
        return Math.sqrt(suma / notas.length);
    }

    public Estudiante peorEnTercera() {
        Estudiante peor = estudiantes[0];
        for (Estudiante e : estudiantes)
            if (e.getNotas()[2] < peor.getNotas()[2])
                peor = e;
        return peor;
    }

    public void mostrarResumen() {
        for (Estudiante e : estudiantes) {
            e.mostrarNotas();
            System.out.println("Total: " + e.total() + " | Promedio: " + e.promedio());
            e.mayorVariacion();
            System.out.println("Nivel final: " + e.nivelFinal());
            System.out.println("----------------------------");
        }

        System.out.println("El mejor promedio es de " + mejorPromedio().getNombre());
        System.out.println("El más regular es " + masRegular().getNombre());
        System.out.println("El peor en la tercera prueba es " + peorEnTercera().getNombre());
    }
}
