import java.util.Scanner;
/**
 * Clase Criba:
 * Genera todos los números primos de 1 hasta un número máximo especificado por el usuario
 * @author IsidroSH
 * @version 1.0
 */

public class Criba
{
    /** Función que genera números primos de 1 a max
     * /
     * @param max
     * @return Matriz con los numeros primos existentes
     */
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
            cuenta = getCuenta(dim, esPrimo, cuenta);
// Rellenar el vector de números primos
            int[] primos = new int[cuenta];
            arrayNumPrimos(dim, esPrimo, primos);
            return primos;
        } else { // max < 2
            return new int[0];
// Vector vacío
        }
    }

    /** Función que genera el array con los numeros primos que han salido
     *
     * @param dim
     * @param esPrimo
     * @param primos
     */
    private static void arrayNumPrimos(int dim, boolean[] esPrimo, int[] primos) {
        int i;
        int j;
        for (i=0, j=0; i< dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
    }

    /** Función que cuenta cuantos numero primos han salido
     *
     * @param dim
     * @param esPrimo
     * @param cuenta
     * @return el numero de numeros primos existentes
     */
    private static int getCuenta(int dim, boolean[] esPrimo, int cuenta) {
        int i;
        for (i=0; i< dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    /** Función donde se hace la criba de cuales son numeros primos y cuales no
     *
     * @param dim
     * @param esPrimo
     */
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

    /** Función que inicializa el array con todos los valores verdaderos
     * 
     * @param dim
     * @param esPrimo
     */
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
