import java.util.Random;

public class anealling {
    public static double cuad(double x){
        return x*x;
    }

    public static double funcion(double x) {
        return 5 + 0.5 * Math.pow(x, 2) - 5 * Math.cos(3 * x);
    }
    public static double simulatedAnnealing(double lowerLimit, double upperLimit, double temperature, double coolingRate, int iterations) {
        Random rand = new Random();
        double currentSolution = lowerLimit + (upperLimit - lowerLimit) * rand.nextDouble();
        double bestSolution = currentSolution;

        for (int i = 0; i < iterations; i++) {
            // Generar una nueva solución vecina
            double nextSolution = lowerLimit + (upperLimit - lowerLimit) * rand.nextDouble();

            // Evaluar la diferencia de energía entre la nueva solución y la actual
            double energyDifference = funcion(nextSolution) - funcion(currentSolution);

            // Si la nueva solución es mejor, o si es peor pero es aceptada probabilísticamente
            if (energyDifference < 0 || rand.nextDouble() < Math.exp(-energyDifference / temperature)) {
                currentSolution = nextSolution;
            }

            // Actualizar la mejor solución encontrada hasta ahora
            if (funcion(currentSolution) < funcion(bestSolution)) {
                bestSolution = currentSolution;
            }

            // Reducir la temperatura
            temperature *= coolingRate;
        }

        return bestSolution;
    }   
     public static void main(String[] args) {
        double lowerLimit = -3; 
        double upperLimit = 2; 
        double initialTemperature = 500; 
        double coolingRate = 0.95; 
        int iterations = 1000; 

        double resultado = simulatedAnnealing(lowerLimit, upperLimit, initialTemperature, coolingRate, iterations);
      
        String resultadoFormateado = String.format("%.15f",resultado);
        System.out.println(resultadoFormateado);
    }

}
