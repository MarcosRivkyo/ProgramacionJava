package ejercicio11;

import java.util.Scanner;

public class Ejercicio11 {

  
    public static void main(String[] args) {
        
        Scanner scan = new Scanner (System.in);
        int num = 0;
        
        float[] notas_1= new float[num];
        float[] notas_2= new float[num];
        float[] notas_3= new float[num];
        
        
       
        
        System.out.println("Introduzca el numero de alumnos: ");
        num=scan.nextInt();
        
        

        for(int i=0;i<num;i++){
            System.out.println("Introduzca las notas del alumno"+(i+1));
            System.out.println("Introduzca su nota en el primer parcial: ");
            notas_1[i]=scan.nextFloat();
            System.out.println("Introduzca su nota en el segundo parcial: ");
            notas_2[i]=scan.nextFloat();
            System.out.println("Introduzca su nota en el examen final: ");
            notas_3[i]=scan.nextFloat();
        }
        




    }
    
}
