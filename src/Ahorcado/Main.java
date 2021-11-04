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
        Scanner entrada = new Scanner(System.in); // vamos a tomar ingreso del teclado
        System.out.println("Te quedan " + vidas + " vidas.");
        do {
            System.out.println(palabraOculta); //imprimimos en pantalla los guiones
            System.out.println("Ingresá una letra...");
            boolean acierto = false;
            char c = entrada.next().charAt(0); //Agarramos el primer carácter de la entrada y lo guardamos en la variable c
            for (int i = 0; i < palabraElegida.length(); i++) { //arranca el bucle, recorremos comparando cada uno de los caracteres de la palabra a adivinar con el carácter ingresado
                if (palabraElegida.charAt(i) == c) {
                    palabraOculta[i] = c;   //si la búsqueda es exitosa reemplazamos el guión por la letra.
                    System.out.println("¡Bien!");
                    acierto = true;
                }
            }
            if (!acierto) {
                System.out.println("Esa letra no está, intentá otra.");
                vidas -= 1;
                System.out.println("Te quedan " + vidas + " vidas.");
                if (vidas == 0) {
                    System.out.println("MORISTE");
                    gameOver = true;
                }
            } else if (palabraElegida.equals(new String(palabraOculta))) {
                System.out.println(palabraOculta);
                System.out.println("¡Ganaste!");
                gameOver = true;
            }

        } while (!gameOver); //siempre y cuando no estemos muertos
    }


    static boolean palabraAdivinada(char[] array) {
        for (char c : array) {
            if (c == '_') return false;
        }
        return true;
    }


    static String elegirPalabra() {
        String[] palabras = {"gancho", "huir", "lupa", "cubierto", "fragmento", "escena", "dientes", "despertar", "tango", "esclavo"};
        Random rand = new Random();
        int ordenPalabra = rand.nextInt(palabras.length);
        return palabras[ordenPalabra];

    }

    static char[] transformarEnGuiones(String palabra) {
        int cantidadLetrasPalabraElegida = palabra.length();
        char[] palabraOculta = new char[cantidadLetrasPalabraElegida];
        Arrays.fill(palabraOculta, '_');
        return palabraOculta;
    }
}
