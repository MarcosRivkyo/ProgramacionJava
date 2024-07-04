package ejericio1clases;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejericio1CLASES {

    public static void main(String[] args) {

        int caracter;
        int num1, num2;
        int suma;
        
        Scanner scan = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("            EJERCICIO 1- CLASES");
        System.out.println("======================================");

        System.out.println("Introduzca la opción que desea realizar: ");

        caracter = scan.nextInt();

        switch (caracter) {

            case 1 -> {
                
                System.out.println("Introduzca el primer numero entero: ");
                num1=scan.nextInt();
                System.out.println("Introduzca el segundo numero entero: ");
                num2=scan.nextInt();
                
            }

            case 2 -> {
                suma=num1+num2;
                System.out.println("La suma de los 2 numeros es: "+suma);               
                
            }

            case 3 -> {
                
                System.out.printf("El resultado de la suma es: %d%n%n", suma);
                
            }

            case 'g' -> {
                
                System.out.println("Adios, hasta pronto!");
               
                
            }

        }
    }

}
