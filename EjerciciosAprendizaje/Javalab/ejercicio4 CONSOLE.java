package ejercicio4;


import java.io.Console;
import static java.lang.System.out;
import java.util.Scanner;




/**
 *
 * @author alumno
 */
public class Ejercicio4 {

   public static void main(String[] args) {

       String nombre = null;
       String apellido1 = null, apellido2=null;
       
       
       Console con = System.console();
        if(null!=con){
       con.printf("Introduzca sus datos personales: \n");
       con.printf("******************************** \n");
       nombre=con.readLine("Por favor, escriba su nombre: ", nombre);
       int num1=nombre.length();
       apellido1=con.readLine("Por favor, escriba su 1º apellido: ", apellido1); 
       int num2=apellido.length();
       apellido2=con.readLine("Por favor, escriba su 2º apellido: ", apellido2);     
       int num3=apellido2.length();
       
       con.printf("La longitud del nombre: %d", num1);
       con.printf("La longitud del nombre: %d", num2); 
       con.printf("La longitud del nombre: %d", num3);     
        }
        else{
            System.err.println("Perdón, no se puede usar la consola");
        }
    
        
    
   }   
    
}
