package ejercicio10;

import java.util.Scanner;


/**
 *
 * @author Marcosky
 */

public class Ejercicio10 {
    
    public static void main(String[] args) {
        
        
        System.out.println("==================================");
        System.out.println("            EJERCICIO 10");
        System.out.println("==================================");
        
        
        Scanner scan = new Scanner(System.in);
     
        
        System.out.printf("Introduzca el numero de clientes: ");
        int num_clientes=scan.nextInt();
        
        switch(num_clientes){
            
            case 1:
                
                
                System.out.printf("Introduzca el numero de peras: ");
                int num_peras = scan.nextInt();
                System.out.printf("Introduzca el numero de manzanas: ");
                int num_manzanas = scan.nextInt();
                System.out.printf("Introduzca el precio por kilos (sin IVA): ");
                double precio= scan.nextDouble();
                System.out.printf("Introduzca el IVA: ");
                double iva= scan.nextInt();
                
                double precio_total=precio+(precio*(iva/100));
                
                System.out.printf("Precio(SIN IVA)= "+precio+" ,IVA= "+iva+" ,precio final= "+precio_total);
                
                
                break;
                
            case 2: 
                
                
                break;
                
            case 3:
                
                
                 break;
            
            
            default:
                 
                
            
        }
        
      
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
