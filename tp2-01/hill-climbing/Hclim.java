
public class  Hclim {
    public static double cuad(double x){
        return x*x;
    }
    public static double funcion(double x) {
        return 5 + 0.5 * Math.pow(x, 2) - 5 * Math.cos(3 * x);
    }

    public static double hill(double lowerLimit, double upperLimit){
        double current=  funcion(lowerLimit), increase=0.1, neighbour;
        double i= lowerLimit+increase;
        while (i<=upperLimit){
            neighbour=funcion(i);
            if(neighbour<= current){
                current=neighbour;
            }
            i+=increase;
        }
        
        return current;
    }

    public static void main(String[] args) {
    
       String resultadoFormateado = String.format("%.15f", hill(-3,2));
       System.out.println(resultadoFormateado);
    }
}