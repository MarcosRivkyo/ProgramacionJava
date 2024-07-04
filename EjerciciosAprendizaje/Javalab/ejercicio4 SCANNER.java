package ejer4;


import java.io.Console;
import static java.lang.System.out;
import java.util.Scanner;




/**
 *
 * @author alumno
 */
public class Ejer4 {

   public static void main(String[] args) {

       String nombre;
       String apellido1, apellido2;
     
       
       Scanner scan = new Scanner(System.in);
    
    
    
    
   
          
        System.out.printf("Introduzca sus datos personales: \n");
        System.out.printf("*******************************\n");
        System.out.printf("Por favor, introduzca su nombre:\n");
        nombre=scan.nextLine();
        int num1=nombre.length();
        
        System.out.printf("Por favor, introduzca su 1º apellido:\n");
        apellido1=scan.nextLine();
        int num2=apellido1.length();
        
        System.out.printf("Por favor, introduzca su 2º apellido:\n");
        apellido2=scan.nextLine();
        int num3=apellido2.length();
        
        
        System.out.printf("La longitud del nombre es: %d\n", num1);
        System.out.printf("La longitud del 1º apellido es: %d\n", num2);
        System.out.printf("La longitud del 2º apellido es: %d\n", num3);
        
        
    
   
        
      
    
    
        
    
   }   
    
}
