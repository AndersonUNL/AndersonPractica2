package Controllers;

import java.util.Scanner;

// declaramos un enumerador llamado zona para definir las distintas zonas y sus respectivas claves y costos por minuto
enum Zona {
    AMERICA_NORTE(12, 2.75f), 
    AMERICA_CENTRAL(15, 1.89f), 
    AMERICA_SUR(18, 1.60f), 
    EUROPA(19, 3.50f), 
    ASIA(23, 4.50f), 
    AFRICA(25, 3.10f), 
    OCEANIA(29, 3.00f), 
    RESTO_DEL_MUNDO(31, 6.00f);
    int clave; // clave de la zona
    float costoPorMinuto; // costo por minuto de llamada en la zona

    //  construimos el enum zona, iniciamos con la clave y luego con el costo por minuto
    Zona(int clave, float costoPorMinuto) {
        this.clave = clave; // asignamos a clave cada clave del enum
        this.costoPorMinuto = costoPorMinuto;// asignamos el costo a cada costo por minuto del enum
    }
}

public class Ejercicio2 {
    // muestramos las opciones de zonas al usuario con sus respectivas claves y costos
    public static void mostrarOpciones() {
        System.out.println("bienvenido al sistema de llamadas internacionales. seleccione una zona por su clave por favor (solo zonas que le aparezcan):");
        System.out.println("AMERICA DEL NORTE (CLAVE=12) : costo por minuto: $2.75");
        System.out.println("AMERICA CENTRAL (CLAVE=15) : costo por minuto: $1.89");
        System.out.println("AMERICA DEL SUR (CLAVE=18) : costo por minuto: $1.60");
        System.out.println("EUROPA (CLAVE=19) : costo por minuto: $3.50");
        System.out.println("ASIA (CLAVE=23) : costo por minuto: $4.50");
        System.out.println("AFRICA (CLAVE=25) : costo por minuto: $3.10");
        System.out.println("OCEANIA (CLAVE=29) : costo por minuto: $3.00");
        System.out.println("RESTO DEL MUNDO (CLAVE=31) : costo por minuto: $6.00");
    }

    // dependiendo de lo ingresado por el usuario seguimos ejecutando
    public static Zona seleccionarZona(int clave) {
        switch (clave) {
            case 12:
                return Zona.AMERICA_NORTE;
            case 15:
                return Zona.AMERICA_CENTRAL;
            case 18:
                return Zona.AMERICA_SUR;
            case 19:
                return Zona.EUROPA;
            case 23:
                return Zona.ASIA;
            case 25:
                return Zona.AFRICA;
            case 29:
                return Zona.OCEANIA;
            case 31:
                return Zona.RESTO_DEL_MUNDO;
            default:
                return null; // si la clave no coincide con ninguna zona, devuelvo null(es decir nulo)
        }
    }
    // calculamos el costo total de la llamada en función de la zona y los minutos
    public static float calcularCosto(Zona zona, float minutos) {
        return minutos * zona.costoPorMinuto;
    }
    // procesamos la zona seleccionada y mostramos el costo total
    public static void procesarZonaSeleccionada(Zona zonaSeleccionada, Scanner Anderson) {
        System.out.println("seleccionaste: " + zonaSeleccionada.name() + " con un costo de $"
                + zonaSeleccionada.costoPorMinuto + " por minuto");
        System.out.print("ingrese la duración de la llamada en minutos (puede incluir decimales, ejm: 5.23): ");
        float minutos = Anderson.nextFloat(); // leemos la duración de la llamada
        float costo = calcularCosto(zonaSeleccionada, minutos); // calculamos el costo total
        System.out.println("------ informe ------");
        System.out.printf("El costo total de la llamada es: $%.2f", costo);//usamos el printf que usabamos en c para asi redondear a los numeros que querramos
    }

    // mensaje de error si el usuario ingresa una clave inválida
    public static void mostrarMensajeError() {
        System.out.println("ingrese solo opciones válidas por favorrrrr, inténtelo de nuevo");
    }

    public static void ejecutarClave() {
        Scanner Anderson = new Scanner(System.in); 
        mostrarOpciones(); // mostramos las opciones disponibles
        System.out.print("ingrese la clave de la zona que quiera calcular el costo: ");
        int clave = Anderson.nextInt(); // leemos lo ingresado por el usuario
        Zona zonaSeleccionada = seleccionarZona(clave); // selecciono la zona correspondiente
        if (zonaSeleccionada != null) {// significa que si zona es diferente de nulo se ejecutara, sino dara la funcion de mostrarMensajeError
            procesarZonaSeleccionada(zonaSeleccionada, Anderson); // si la clave es válida, se procesara la respectiva zona
        } else {
            mostrarMensajeError();
        }
    }
}
