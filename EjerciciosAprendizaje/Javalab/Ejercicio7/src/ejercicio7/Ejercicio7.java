package ejercicio7;

import java.io.Console;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Marcosky
 */
public class Ejercicio7 {
    
    public static void main(String[] args) {
        
        System.out.println("==================================");
        System.out.println("            EJERCICIO 7");
        System.out.println("==================================");
        
                
       Console con = System.console();
       
       if(null!=con){
           //console
           
        
        ArrayList<String> nombre = new ArrayList<>();
        int [] edad;
        float [] talla;
        
      
        con.printf("A continuación, introduzca los datos personales\nasociados a cada persona:");
        
       
        edad = new int [3];
        talla = new float [3];
        
        for(int i=0;i<3;i++){
          
       
        nombre.set(i, con.readLine("Introduzca el nombre:"));
        edad[i]=Integer.parseInt(con.readLine("Introduzca la edad: "));
        talla[i]=Integer.parseInt(con.readLine("Introduzca la talla: "));
        
       }
        
        con.printf("Proceso realizado con exito.");
        con.printf("A continuación, se mostrará por pantalla los datos introducidos.");
        
        for(int i=0;i<3;i++){
            
        con.printf("El nombre -%d- es %c", i, nombre.get(i));
        con.printf("La edad -%d- es %d", i, edad[i]);
        con.printf("La talla -%d- es %f", i, talla[i]);
        
            
        }
     
        
      }
       else{
           //scanner
        Scanner scan = new Scanner(System.in);
        
        ArrayList<String> nombre = new ArrayList<>();
        int [] edad;
        float [] talla;
        
        System.out.println("A continuación, introduzca los datos personales\nasociados a cada persona:");
        
        
        edad = new int [3];
        talla = new float [3];
        
        for(int i=0;i<1;i++){
            
            System.out.printf("Introduzca el nombre %d: \n", i+1);
            nombre.set(i, scan.nextLine());
            System.out.printf("Introduzca la edad %d: \n", i+1);
            edad[i]=scan.nextInt();
            System.out.printf("Introduzca la talla %d: \n", i+1);
            talla[i]=scan.nextFloat();
            
            
        }
        
        System.out.printf("Proceso realizado con exito.");
        
        for(int i=0;i<1;i++){
            
            System.out.printf("El nombre -%d- es %C", i, nombre.get(i));
            System.out.printf("La edad -%d- es %d", i, edad[i]);
            System.out.printf("La talla -%d- es %f", i, talla[i]);
            
            
        }
             
           
       }
            
        
    }
    
}
