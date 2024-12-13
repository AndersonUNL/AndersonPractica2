package Controllers;

import java.util.Scanner;

public class Ejercicio4 {

    public static int obtenerCantidadTerminos(Scanner Anderson) {
        System.out.println("Ingrese la cantidad de términos que desea calcular de la serie: ");
        return Anderson.nextInt();
    }

    public static double calcularTermino(int numerador, int denominador, int exponente, int signo) {
        return signo * Math.pow((double) numerador / denominador, exponente);
    }

    public static void imprimirTermino(int numerador, int denominador, int exponente, int signo, int i,
            int cantidadTerminos) {
        System.out.print("(" + numerador + "/" + denominador + ")^" + exponente);
        if (i < cantidadTerminos - 1) {
            if (signo == 1) {
                System.out.print(" + ");
            } else {
                System.out.print(" - ");
            }
        }
    }

    public static int alternarSigno(int signo, int i) {
        if ((i + 1) % 2 == 0) {
            signo *= -1;
        }
        return signo;
    }

    public static int calcularSiguienteNumerador(int numerador1, int numerador2) {
        return numerador1 + numerador2;
    }

    public static void mostrarResultado(double suma) {
        System.out.print(" = ");
        System.out.println(" ");
        System.out.println("------ Informe ------");
        System.out.printf("El resultado de la serie es: %.2f", suma);
    }

    public static void calcularSerie(int cantidadTerminos) {
        // Inicializamos los primeros numeros de la secuencia
        int numerador1 = 1, numerador2 = 1; // numeradores
        int denominador = 1; // denominador
        int exponente = 2; // exponente
        int signo = 1; // El signo alterna entre 2 (+) y 2 (-) secuencialmente
        double suma = 0.0; // la suma comienza desde 0

        System.out.print("Términos de la serie: "); // Se usa print para que los términos aparezcan en la misma línea  no de ningun salto de linea
        for (int i = 0; i < cantidadTerminos; i++) {
            // Calculamos el valor del término con el signo alternante
            signo = alternarSigno(signo, i);
            double termino = calcularTermino(numerador1, denominador, exponente, signo);
            suma += termino;
            // Mostramos el término con su signo en la misma línea gracias al print
            imprimirTermino(numerador1, denominador, exponente, signo, i, cantidadTerminos);
            // Alternamos el signo después de cada dos términos
            // Calcular el siguiente numerador siguiendo la secuencia Fibonacci
            int siguienteNumerador = calcularSiguienteNumerador(numerador1, numerador2);
            numerador1 = numerador2;
            numerador2 = siguienteNumerador;
            // Incrementar el denominador de 2 en 2
            denominador += 2;
            // Incrementar el exponente de 2 en 2
            exponente += 2;
        }
        // Mostrar resultado final de la serie
        mostrarResultado(suma);
    }

    public static void ejecutar_serie () {
        Scanner Anderson = new Scanner(System.in);
        int cantidadTerminos = obtenerCantidadTerminos(Anderson);

        // Calcular y mostrar la serie
        calcularSerie(cantidadTerminos);
    }
}
