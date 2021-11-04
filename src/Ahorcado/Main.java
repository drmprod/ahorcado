package Ahorcado;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = false;
        String palabraElegida = elegirPalabra();
        char[] palabraOculta = transformarEnGuiones(palabraElegida);
        int vidas = 6;
        // vamos a tomar ingreso del teclado
        Scanner entrada = new Scanner(System.in);
        System.out.println("Te quedan " + vidas + " vidas.");
        do {
            //imprimimos en pantalla los guiones
            System.out.println(palabraOculta);
            System.out.println("Ingresá una letra...");
            boolean acierto = false;
            //Agarramos el primer carácter de la entrada y lo guardamos en la variable c
            char c = entrada.next().charAt(0);
            //acá arranca el bucle, recorremos comparando cada uno de los caracteres de la palabra a adivinar con el carácter ingresado
            for (int i = 0; i < palabraElegida.length(); i++) {
                if (palabraElegida.charAt(i) == c) {
                    //si la búsqueda es exitosa reemplazamos el guión por la letra correspondiente
                    palabraOculta[i] = c;
                    System.out.println("¡Bien!");
                    acierto = true;
                }
            }
            //si no acertamos la letra imprimimos un mensaje y restamos una vida. Si no quedan vidas GAME OVER
            if (!acierto) {
                System.out.println("Esa letra no está, intentá otra.");
                vidas -= 1;
                System.out.println("Te quedan " + vidas + " vidas.");
                if (vidas == 0) {
                    System.out.println("MORISTE");
                    gameOver = true;
                }
            }
            // acá comparamos, si ya no quedan guiones, es decir, la palabra oculta es igual a la palabra elegida, ganamos y GAME OVER
            else if (palabraElegida.equals(new String(palabraOculta))) {
                System.out.println(palabraOculta);
                System.out.println("¡Ganaste!");
                gameOver = true;
            }

        } while (!gameOver); //Acá cerramos el bucle chequeando la variable gameOver
        entrada.close();
    }

    //Con este método sorteamos una palabra aleatoriamente de una lista predefinida
    static String elegirPalabra() {
        String[] palabras = {"gancho", "huir", "lupa", "cubierto", "fragmento", "escena", "dientes", "despertar", "tango", "esclavo"};
        Random rand = new Random();
        int ordenPalabra = rand.nextInt(palabras.length);
        return palabras[ordenPalabra];

    }

    //Con este método transformamos la palabra que salió sorteada en una cadena de guiones
    static char[] transformarEnGuiones(String palabra) {
        int cantidadLetrasPalabraElegida = palabra.length();
        char[] palabraOculta = new char[cantidadLetrasPalabraElegida];
        Arrays.fill(palabraOculta, '_');
        return palabraOculta;
    }
}
