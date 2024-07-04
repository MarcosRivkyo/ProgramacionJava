/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio10a;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejercicio12 {
  
    
    public static void main(String[] args) {
        
        
        int f,i,j,cont=0;
        
        System.out.println("============================");
        System.out.println("       EJERCICIO 12");
        System.out.println("============================");
    
        Scanner scan = new Scanner(System.in);
        
        System.out.printf("Introduzca el numero de alumnos: ");
        f=scan.nextInt();
        
        double [][] notas=new double[f][3];
        double [] suma= new double[f];
        double [] media=new double[f];
        
        for(i=0;i<f;i++){
            
            System.out.println("Introduzca las notas del alumno "+(i+1));
            
            for(j=0;j<3;j++){
                if(j==0){
                    
                    System.out.printf("Introduzca la nota del primer parcial: ");
                    notas[i][j]=scan.nextDouble();
                    suma[i]=suma[i]+notas[i][j];
                   
                }
                
                if(j==1){
                    
                    System.out.printf("Introduzca la nota del segundo parcial: ");
                    notas[i][j]=scan.nextDouble();
                     suma[i]=suma[i]+notas[i][j];
                    
                }
                
                if(j==2){
                    
                    System.out.printf("Introduzca la nota del examen final: ");
                    notas[i][j]=scan.nextDouble();
                     suma[i]=suma[i]+notas[i][j];
                    
                }
               
         }
        }
        
        for(i=0;i<f;i++){
        
            media[i]=suma[i]/3;
        
        }
        
        System.out.println("TABLA DE CALIFICACIONES CON SU MEDIA");
        for(i=0;i<f;i++){
            if(i==0){
                 System.out.printf("Calificaciones del alumno <"+i+">");   
                }
            System.out.println("");
            for(j=0;j<3;j++){
                if(j==0){
                 System.out.printf("Primer parcial: "); 
                 System.out.printf("%.2f  ", notas[i][j]);
                }
               
                if(j==1){
                 System.out.printf("Segundo parcial: ");   
                 System.out.printf("%.2f  ", notas[i][j]);
                }
                
                if(j==2){
                 System.out.printf("Examen final: ");  
                 System.out.printf("%.2f  ", notas[i][j]);
                }
                
                
                
            }
            System.out.printf("Media: ");  
            System.out.printf("%.2f", media[i]);
        }
        
        
   
  
    
    }
}
    
