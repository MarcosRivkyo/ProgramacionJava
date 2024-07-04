/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio15;

import java.util.Scanner;

public class Dato {

    public int leerEntero(String frase) {

        String temp;
        int salida = 0;
        Boolean control = false;

        Scanner scan = new Scanner(System.in);

        while (!control) {
            do {
                System.out.println(frase);
                temp = scan.nextLine();

            } while (temp.isEmpty());

            try {
                salida = Integer.parseInt(temp);
                control = true;

            } catch (NumberFormatException e) {
                System.out.println("Introduce un valor entero: ");
                control = false;
            }
        }

        return salida;
    }

    public float leerFloat(String frase) {

        String temp;
        float salida = 0;
        Boolean control = false;

        Scanner scan = new Scanner(System.in);
        while (!control) {

            do {
                System.out.println(frase);
                temp = scan.nextLine();

            } while (temp.isEmpty());

            try {
                salida = Float.parseFloat(temp);
                control = true;

            } catch (NumberFormatException e) {

                System.out.println("Introduce un valor float: ");
                control = false;

            }

        }

        return salida;

    }

    public double leerDouble(String frase) {

        String temp;
        double salida = 0;
        boolean control = false;

        Scanner scan = new Scanner(System.in);

        while (!control) {

            do {

                System.out.println(frase);
                temp = scan.nextLine();

            } while (temp.isEmpty());

            try {
                salida = Double.parseDouble(temp);
                control = true;
            } catch (NumberFormatException e) {

                System.out.println("Introduce un valor double: ");
                control = false;
            }

        }
        return salida;
    }

    
    
    
}
