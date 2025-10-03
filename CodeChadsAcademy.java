package paradigmas.desafio;

public class CodeChadsAcademy {
    public static void main(String[] args) {
        
        int[] notas = new int[5];

        // Primeras 3 notas (hardcodeadas)
        notas[0] = 85;
        notas[1] = 75;
        notas[2] = 90;

        // Nota 4 según regla
        notas[3] = (notas[1] < 60) ? 100 : notas[1];
        // Nota 5 según regla
        notas[4] = (notas[0] + notas[2] > 150) ? 95 : 70;

        System.out.println("Las notas del alumno son: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Prueba " + (i+1) + ": " + notas[i]);
        }

        System.out.println("\n************************************************\n");

        int aprobadas = 0;
        for (int nota : notas) if (nota >= 60) aprobadas++;

        if (aprobadas == notas.length) {
            System.out.println("Resultado: Aprobaste todas. ¡Backend Sensei!");
        } else if (aprobadas == 0) {
            System.out.println("Resultado: No aprobaste ninguna. ¡Clon de frontend!");
        } else {
            System.out.println("Resultado: Algunas aprobadas. Refactor en progreso.");
        }

        System.out.println("\n************************************************\n");

        int maxDif = 0;
        int pos = 0;
        for (int i = 0; i < notas.length-1; i++) {
            int dif = Math.abs(notas[i+1] - notas[i]);
            if (dif > maxDif) {
                maxDif = dif;
                pos = i;
            }
        }
        System.out.println("Mayor salto: " + maxDif + " puntos entre prueba " + (pos+1) + " y " + (pos+2));

        boolean progresivo = true;
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] <= notas[i-1]) progresivo = false;
        }
        if (progresivo) System.out.println("¡Nivel PROGRESIVO! Stone Chad en crecimiento 📈");

        int[] ordenadas = notas.clone();
        for (int i = 0; i < ordenadas.length-1; i++) {
            int idxMax = i;
            for (int j = i+1; j < ordenadas.length; j++) {
                if (ordenadas[j] > ordenadas[idxMax]) idxMax = j;
            }
            int tmp = ordenadas[i];
            ordenadas[i] = ordenadas[idxMax];
            ordenadas[idxMax] = tmp;
        }
        System.out.print("Notas ordenadas (mayor a menor): ");
        for (int n : ordenadas) System.out.print(n + " ");
        System.out.println();

        int total = 0;
        for (int n : notas) total += n;
        System.out.println("Total acumulado: " + total);

        if (total < 250) {
            System.out.println("Evaluación final: Normie total 😢");
        } else if (total <= 349) {
            System.out.println("Evaluación final: Soft Chad");
        } else if (total <= 449) {
            System.out.println("Evaluación final: Chad");
        } else {
            System.out.println("Evaluación final: Stone Chad definitivo 💪");
        }

        System.out.println("\n************************************************\n");

        System.out.println("\n Evaluación de la clase: ");

        int[][] clase = {
            {85, 75, 90, 75, 95},  /* ALUMNO 1 */
            {60, 70, 50, 75, 75},  /* ALUMNO 2 */
            {90, 90, 60, 65, 65},  /* ALUMNO 3 */
            {50, 50, 50, 50, 60}   /* ALUMNO 4 */
        };

        double mejorPromedio = -1;
        int idxMejorPromedio = -1;
        double minDesv = Double.MAX_VALUE;
        int idxMasRegular = -1;
        int peorTercera = Integer.MAX_VALUE;
        int idxPeorTercera = -1;

        for (int i = 0; i < clase.length; i++) {
            int[] alumno = clase[i];
            int suma = 0;
            for (int j = 0; j < alumno.length; j++) suma += alumno[j];
            double prom = (double) suma / alumno.length;

            double s = 0;
            for (int nota : alumno) {
                s += Math.pow(nota - prom, 2);
            }
            double desv = Math.sqrt(s / alumno.length);

            System.out.printf("Alumno %d -> Promedio: %.2f | Desviación: %.2f%n", i+1, prom, desv);

            if (prom > mejorPromedio) {
                mejorPromedio = prom;
                idxMejorPromedio = i;
            }
            if (desv < minDesv) {
                minDesv = desv;
                idxMasRegular = i;
            }
            if (alumno[2] < peorTercera) {
                peorTercera = alumno[2];
                idxPeorTercera = i;
            }
        }

        System.out.println("\n************************************************\n");

        System.out.println("Mejor promedio: Alumno " + (idxMejorPromedio+1));
        System.out.println("Más regular: Alumno " + (idxMasRegular+1));
        System.out.println("Peor en la 3ª prueba: Alumno " + (idxPeorTercera+1) + " con " + peorTercera);

    }
}
