package view;

import java.util.Scanner;
import Controllers.*;

public class Menu {

    public static void main(String[] args) {
        int opcion = 0;

            Scanner Anderson = new Scanner(System.in);

            System.out.println("Ingresa la opción que quieras:");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Ejercicio 3");
            System.out.println("4. Ejercicio 4");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Anderson.nextInt();

            switch (opcion) {
                case 1:
                    Ejercicio1.ejecutarAutos(); // Ejecutar Ejercicio 1
                    break;
                case 2:
                    Ejercicio2.ejecutarClave(); // Ejecutar Ejercicio 2
                    break;
                case 3:
                    Ejercicio3.ejecutar_agua(); // Ejecutar Ejercicio 3
                    break;
                case 4:
                    Ejercicio4.ejecutar_serie(); // Ejecutar Ejercicio 4
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor ingrese una opción entre 0 y 4.");
            }
        Anderson.close();
    }
}
