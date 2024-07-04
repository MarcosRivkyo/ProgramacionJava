package ejercicio11b;
import java.util.Scanner;

public class Ejercicio11b {

   
    public static void main(String[] args) {
        int num;
        
        

        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el numero de alumnos");
        num=scan.nextInt();
        float[] nota_1= new float[num];
        float[] nota_2= new float[num];
        float[] nota_3= new float[num];
        float[] nota_media= new float [num];
        
        for(int i=0; i<=num;i++){
            
            System.out.println("Introduzca los datos del alumno "+(i+1));
            
            System.out.println("Nota PRIMER PARCIAL");
            nota_1[i]=scan.nextFloat();
            System.out.println("Nota SEGUNDO PARCIAL");
            nota_2[i]=scan.nextFloat();
            System.out.println("Nota EXAMEN FINAL");
            nota_3[i]=scan.nextFloat();
            
            
            nota_media[i]=(nota_1[i]*0.2)+(nota_2[i]*0.2)+(nota_3[i]*0.6);
            
            
        }

    }
    
}
