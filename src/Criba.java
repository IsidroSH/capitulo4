import java.util.Scanner;
public class Criba
{
    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max)
    {
        int i,j;
        if (max >= 2) {
// Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
// Inicializar el array
            inicializacionArray(dim, esPrimo);
// Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
// Criba
            cribaNumeros(dim, esPrimo);
// ¿Cuántos primos hay?
            int cuenta = 0;
            for (i=0; i<dim; i++) {
                if (esPrimo[i])
                    cuenta++;
            }
// Rellenar el vector de números primos
            int[] primos = new int[cuenta];
            for (i=0, j=0; i<dim; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
        } else { // max < 2
            return new int[0];
// Vector vacío
        }
    }

    private static void cribaNumeros(int dim, boolean[] esPrimo) {
        int i;
        int j;
        for (i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
// Eliminar los múltiplos de i
                for (j=2*i; j< dim; j+=i)
                    esPrimo[j] = false;
            }
        }
    }

    private static void inicializacionArray(int dim, boolean[] esPrimo) {
        int i;
        for (i=0; i< dim; i++)
            esPrimo[i] = true;
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }
}
