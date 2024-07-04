package ejercicio9;

import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejercicio9 {

   
    public static void main(String[] args) {
        
        float [] peso = new float [2];
        int [] talla = new int [2];
        
        Scanner scan = new Scanner(System.in);
        
        for(int i=0;i<2;i++){
            
            System.out.printf("Introduzca el %d peso", i+1);
            peso[i]=scan.nextFloat();
            System.out.printf("Introduzca la %d talla", i+1);
            talla[i]=scan.nextInt();
  
        }
        
        float peso_mayor=Math.max(peso[0], peso[1]);
        float peso_menor=Math.min(peso[0], peso[1]);
        
        int talla_mayor=Math.max(talla[0], talla[1]);
        int talla_menor=Math.min(talla[0], talla[1]);
        
        
        
        System.out.printf("El peso mayor es: %.2f", peso_mayor);
        System.out.printf("El peso menor es: %.2f", peso_menor);
        
        System.out.printf("%n%n%nLa talla mayor es: %d", talla_mayor);
        System.out.printf("La talla menor es: %d", talla_menor);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
