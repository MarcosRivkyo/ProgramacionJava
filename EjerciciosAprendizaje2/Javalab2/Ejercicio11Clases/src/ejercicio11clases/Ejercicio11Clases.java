
package ejercicio11clases;

import java.util.Scanner;

public class Ejercicio11Clases {

 
    public static void main(String[] args) {

        Persona alumno1 = new Persona ();
        Persona alumno2 = new Persona ();
        Persona alumno3 = new Persona ();
        
      Scanner scan = new Scanner (System.in);
        
      System.out.println("Introduzca las notas del alumno 1: ");
      System.out.println("Introduzca la primera nota del alumno 1: ");
      alumno1.set_nota1(scan.nextFloat());
      System.out.println("Introduzca la segunda nota del alumno 1: ");
      alumno1.set_nota2(scan.nextFloat());
      System.out.println("Introduzca la tercera nota del alumno 1: ");
      alumno1.set_nota3(scan.nextFloat());
      System.out.println("La nota media es: "+alumno1.nota_media());

      System.out.println("========================================");
      System.out.println("Introduzca las notas del alumno 2: ");
      System.out.println("Introduzca la primera nota del alumno 2: ");
      alumno2.set_nota1(scan.nextFloat());
      System.out.println("Introduzca la segunda nota del alumno 2: ");
      alumno2.set_nota2(scan.nextFloat());
      System.out.println("Introduzca la tercera nota del alumno 2: ");
      alumno2.set_nota3(scan.nextFloat());
      System.out.println("La nota media es: "+alumno2.nota_media());

      System.out.println("========================================");
      System.out.println("Introduzca las notas del alumno 3: ");
      System.out.println("Introduzca la primera nota del alumno 3: ");
      alumno3.set_nota1(scan.nextFloat());
      System.out.println("Introduzca la segunda nota del alumno 3: ");
      alumno3.set_nota2(scan.nextFloat());
      System.out.println("Introduzca la tercera nota del alumno 3: ");
      alumno3.set_nota3(scan.nextFloat());
      System.out.println("La nota media es: "+alumno3.nota_media());
      

      
      System.out.println("=======================================");
      System.out.println("          TODAS LAS NOTAS EN TABLA");
      System.out.println("=======================================");
     
     System.out.print("Notas alumno 1: ");
     System.out.printf("%3.2f ",alumno1.get_nota1());
     System.out.printf("%3.2f ",alumno1.get_nota2());   
     System.out.printf("%3.2f %n",alumno1.get_nota3());
     System.out.print("Notas alumno 2: ");
     System.out.printf("%3.2f ",alumno2.get_nota1());   
     System.out.printf("%3.2f ",alumno2.get_nota2()); 
     System.out.printf("%3.2f %n",alumno2.get_nota3()); 
     System.out.print("Notas alumno 3: ");
     System.out.printf("%3.2f ",alumno3.get_nota1()); 
     System.out.printf("%3.2f ",alumno3.get_nota2()); 
     System.out.printf("%3.2f %n",alumno3.get_nota3()); 


    }
    
}
