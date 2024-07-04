
package ejercicio8;

import java.util.Scanner;
/**
 *
 * @author Marcosky
 */
public class Ejercicio8 {

    public static void main(String[] args) {
        
        float acu=0,mayor=0, menor=10000,media;
        int cont=0, contT=0;
        int i;
        int acuT=0,mayorT=0, menorT=10000,mediaT;
        
        
        float [] peso = new float [3];
        int [] talla = new int [3];
        
        Scanner scan = new Scanner(System.in);
        
        for( i=0;i<3;i++){
            
            System.out.printf("Introduzca el %d peso", i+1);
            peso[i]=scan.nextFloat();
            System.out.printf("Introduzca la %d talla", i+1);
            talla[i]=scan.nextInt();
  
        }
        
         for(i=0;i<3;i++){
            acu=acu+peso[i];
            acuT=acuT+talla[i];
            cont=cont+1;
            
            if(peso[i]>mayor){
                 mayor=peso[i];
            }else if(peso[i]<menor){
                 menor=peso[i];
             
               }
            if(talla[i]>mayorT){
                 mayorT=talla[i];
            }else if(talla[i]<menorT){
                 menorT=talla[i];
             
               }
         }
        
         for( i=0;i<3;i++){
            
            System.out.printf("El peso %d: %.2f   ", i, peso[i]);
            
            System.out.printf("La talla %d: %d", i, talla[i]);
      
            System.out.printf("%n");
            
            
            
        }
        media=acu/cont;
        mediaT=acuT/cont;
        System.out.printf("El peso mayor es: %.2f", mayor);
        System.out.printf("El peso menor es: %.2f", menor);
        System.out.printf("%nLa media de peso es: %.2f", media);
        System.out.printf("%n%n%nLa talla mayor es: %d", mayorT);
        System.out.printf("La talla menor es: %d", menorT);
        System.out.printf("%nLa media de talla es: %d", mediaT);
        
    }
    
}
