package Controllers;

public class DoWhile {

    public static void main(String[] args) {
        int contador = 10; // Inicializamos el contador en 10
    
        // Bucle do-while que se ejecuta al menos una vez y luego mientras el contador sea mayor o igual a 1
        do {
            System.out.println(contador); // Imprime el valor del contador
            contador -= 2; // Decrementa el contador en 2
        } while (contador >= 1); // La condición se evalúa después de ejecutar el código dentro del bucle
    }
}

