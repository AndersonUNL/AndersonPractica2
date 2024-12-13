package Controllers;

import java.util.Scanner;

public class Ejercicio3 {

    public static double calcularservicioagua(double consumo) {
        double servicioagua = 0;
        // calculamos el servicio brindado de agua potable
        if (consumo > 0.0 && consumo <= 15) {
            servicioagua = 3.00; // si el consumo es hasta 15 m³, el costo es fijo de $3.00
        } else if (consumo <= 25.0) {
            servicioagua = 3.00 + ((consumo - 15) * 0.10); // para consumos entre 15 y 25 m³, agregamos $0.10 por cada m³ adicional
        } else if (consumo <= 40.0) {
            servicioagua = 4.00 + ((consumo - 25) * 0.20); // para consumos entre 25 y 40 m³, agregamos $0.20 por cada m³ adicional
        } else if (consumo <= 60.0) {
            servicioagua = 7.00 + ((consumo - 40) * 0.30); // para consumos entre 40 y 60 m³, agregamos $0.30 por cada m³ adicional
        } else if (consumo > 60.0) {
            servicioagua = 13.00 + ((consumo - 60) * 0.35); // para consumos mayores a 60 m³, agregamos $0.35 por cada m³ adicional
        } else {
            System.out.println("por favor ingrese datos válidos"); // validamos que el consumo no sea negativo
        }
        return servicioagua;
    }

    public static double calculardescuento(double servicioagua, String esterceraedad, String esdiscapacitado,
            int porcentajediscapacidad, double consumo) {
        double descuento = 0;
        // verificamos si el usuario es de tercera edad para aplicar el descuento correspondiente
        if (esterceraedad.trim().equalsIgnoreCase("si")) {
            if (consumo <= 15) {
                descuento = servicioagua * 0.50; // si consume hasta 15 m³ se aplica un 50% de descuento
            } else {
                descuento = 3.00 * 0.30; // para consumos mayores a 15 m³ se aplica un 30% de descuento solo al costo base
            }
        }
        // verificamos si el usuario es discapacitado para aplicar el descuento correspondiente
        if (esdiscapacitado.trim().equalsIgnoreCase("si")) {
            if (consumo <= 15) {
                descuento = servicioagua * (porcentajediscapacidad / 100.0); // descuento proporcional al porcentaje de discapacidad
            } else {
                descuento = 3.00 * (porcentajediscapacidad / 100.0); // solo sobre el costo base de $3.00
            }
        }
        // si es discapacitado y de tercera edad, tomamos el mayor descuento entre ambos
        if (esdiscapacitado.trim().equalsIgnoreCase("si") && esterceraedad.trim().equalsIgnoreCase("si")) {
            System.out.println("vamos a escoger el mayor porcentaje entre ambas opciones");
            descuento = Math.max(servicioagua * (porcentajediscapacidad / 100.0),
                    consumo <= 15 ? servicioagua * 0.50 : 3.00 * 0.30);
        }
        return descuento;
    }

    public static double calcularalcantarillado(double servicioagua) {
        // calculamos el impuesto de alcantarillado como el 35% del costo del servicio de agua
        return servicioagua * 0.35;
    }

    public static void mostrarresultados(double servicioagua, double descuento, double alcantarillado,
            double totalpagar) {
        // definimos como constante el precio de la recolección de basura y el procesamiento de datos
        double basura = 0.75; // costo fijo por recolección de basura
        double datos = 0.50; // costo fijo por procesamiento de datos

        // mostramos los resultados finales, redondeados a 2 decimales
        System.out.println("\n------------informe------------");
        System.out.printf("servicio de agua potable (ya está incluido el descuento): $%.2f%n", servicioagua);
        System.out.printf("descuento aplicado: $%.2f%n", descuento);
        System.out.printf("impuesto de alcantarillado: $%.2f%n", alcantarillado);
        System.out.printf("tasa por recolección de basura: $%.2f%n", basura);
        System.out.printf("tasa por costo de procesamiento de datos: $%.2f%n", datos);
        System.out.printf("total a pagar: $%.2f%n", totalpagar);
    }

    public static void ejecutar_agua(){// este método ejecuta todo el proceso
        Scanner anderson = new Scanner(System.in);

        // declaración de variables
        double consumo;
        double servicioagua = 0;
        double descuento = 0;
        double totalpagar = 0;
        String esterceraedad, esdiscapacitado;
        int porcentajediscapacidad = 0;

        // mostramos un mensaje de bienvenida al sistema
        System.out.println("bienvenido al sistema municipal de agua potable de loja :)");
        System.out.print(
                "ingrese el consumo de agua en m³: (si requiere usar números decimales utilice , (comas) no . (puntos) por favor)= \n");
        consumo = anderson.nextDouble(); // leemos el consumo ingresado por el usuario
        anderson.nextLine(); // usamos esto para manejar correctamente el carácter de nueva línea ya que esto es un error en java, pero si leemos la sigueinte linea hara un espacio para seguir leyendo mas datos, esto se da por lo general cuando leemos datos double o float y luego una string

        // determinamos si tiene posibles descuentos
        System.out.println("\na continuación ingrese unos datos para saber si tiene algún beneficio:\n");
        System.out.print("¿el contribuyente es de tercera edad? (si/no): ");
        esterceraedad = anderson.nextLine(); // asignamos si es tercera edad o no
        System.out.print("¿el contribuyente es discapacitado? (si/no): ");
        esdiscapacitado = anderson.nextLine(); // asignamos si es discapacitado
        if (esdiscapacitado.equalsIgnoreCase("si")) {
            System.out.print("ingrese el porcentaje de discapacidad: ");
            porcentajediscapacidad = anderson.nextInt(); // leemos el porcentaje de discapacidad
        }

        // cálculo del servicio brindado de agua potable
        servicioagua = calcularservicioagua(consumo);

        // cálculo del descuento correspondiente
        descuento = calculardescuento(servicioagua, esterceraedad, esdiscapacitado, porcentajediscapacidad, consumo);
        servicioagua -= descuento; // restamos el descuento al costo del servicio

        // cálculo del impuesto de alcantarillado
        double alcantarillado = calcularalcantarillado(servicioagua);

        // cálculo del total a pagar
        totalpagar = servicioagua + alcantarillado + 0.75 + 0.50;

        // mostramos los resultados finales
        mostrarresultados(servicioagua, descuento, alcantarillado, totalpagar);

        anderson.close(); 
    }
}
