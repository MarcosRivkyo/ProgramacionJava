import java.io.Console;
import java.util.Scanner;
        
        
        
package Ejercicio5;

/**
 *
 * @author Marcosky
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        Console con = System.console();
        if (null!=con){
           //CONSOLE 
            con.printf("//////////////CONSOLE///////////\n");
            con.printf("Introduzca sus datos personales: \n");
            con.printf("*******************************\n");
            
            int anioNac = Integer.parseInt(con.readLine("Introduzca el año en el que nació: \n"));
            int anioAct = Integer.parseInt(con.readLine("Introduzca el año actual: \n"));
            
            int edad = restar(anioNac, anioAct);
            
            con.printf("Su edad actual es: %d", edad);
            
        }
        else{
           //SCANNER 
            Scanner scan = new Scanner(System.in);
            System.out.println("//////////////SCANNER///////////");
            System.out.printf("Introduzca sus datos personales: \n");
            System.out.printf("*******************************\n");
            System.out.printf("Introduzca el año en el que nació: \n");
            int anioNac = scan.nextInt();
            System.out.printf("Introduzca el año actual: \n");
            int anioAct = scan.nextInt();
            int edad = restar(anioNac, anioAct);
            System.out.printf("Su edad actual es: %d", edad);
            
            
            
        }
        
            
    
}
    static int restar(int a, int b){
                
                int resul=b-a;
                return resul;
                
                
}
        
        
    }
