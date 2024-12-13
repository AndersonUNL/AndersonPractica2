package Controllers;
import java.util.Scanner;
public class Ejercicio1 {
    // Creamos variables globales ya que las ocuparemos en todo el codigo
    static Scanner Anderson = new Scanner(System.in);
    static int sueldoEmpleado = 2500; // Sueldo base
    static int totalCarros = 0;// depende la cantidad que ingrese el usuario iran aqui
    static float totalVentaCarros = 0;// la suma de todos los carros vendidos
    static float comisiones = 0;
    static int carrosComision = 0;// igual depende de el total de la suma de carros >=10000 para que den 250 por carro
    static float utilidades = 0;
    static float sueldoTotal = 0;//el total del sueldo del empleado, aqui ira ya todo sumado

    public static void ejecutarAutos () {//metodo principal que encapsula todos los demas metodos almacenados en este codigo
        // Pedimos al usuario que ingrese el total de carros que se vendio
        entradaDatos();
        // realizamos los correspondientes calculos
        procesarVentas();
        // calculamos  las utilidades
        calcularUtilidades();
        // Sumamos todo para que nos de el sueldo total
        calcularSueldoTotal();
        // Presentamos al usuario el informe
        mostrarInforme();
        Anderson.close();//cerramos el scanner
    }

    // Función para la entrada de datos
    public static void entradaDatos() {
        System.out.println("Informe general del empleado:");
        System.out.print("Ingrese la cantidad de carros vendidos: ");
        totalCarros = Anderson.nextInt();
    }

    // Función para procesar las ventas
    public static void procesarVentas() {
        for (int i = 1; i <= totalCarros; i++) {
            System.out.print("Ingrese el valor del carro " + i + ": ");
            float valorCarro = Anderson.nextFloat();
            // Sumamos al total de ventas
            totalVentaCarros += valorCarro;
            // Verificamos si el carro supera los $10,000 para aplicar la correspondiente comisión
            if (valorCarro >= 10000) {
                carrosComision++;
                comisiones += 250; // sumamos la comisión
            }
        }
    }

    // Función para calcular utilidades
    public static void calcularUtilidades() {
        utilidades = totalVentaCarros * 0.05f;
    }

    // Función para sumar el sueldo total
    public static void calcularSueldoTotal() {
        sueldoTotal = sueldoEmpleado + comisiones + utilidades;
    }

    // Aqui creamos la funcion para presentar el informe, osea estos seran los datos de salida
    public static void mostrarInforme() {
        System.out.println("------ Informe ------");
        System.out.println("Total de autos vendidos: " + totalCarros);
        System.out.println("Total de autos que generaron comisión: " + carrosComision);
        System.out.println("Valor total de los autos vendidos: $" + totalVentaCarros);
        System.out.println("Comisiones obtenidas: $" + comisiones);
        System.out.println("Utilidades (5% del valor total de ventas): $" + utilidades);
        System.out.println("Sueldo total del empleado al final del mes:");
        System.out.println("(Sueldo base) $" + sueldoEmpleado + " + (Comisiones) $" + comisiones + " + (Utilidades) $" + utilidades + " =");
        System.out.println("Total: $" + sueldoTotal);
    }
}