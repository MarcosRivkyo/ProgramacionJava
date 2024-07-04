package ejercicio15;

import java.util.Scanner;

public class Ejercicio15 {

    
    public static void main(String[] args) {

        
      Dato dt = new Dato ();
      Persona p1 = new Persona ();
      Persona p2 = new Persona ();
      Persona p3 = new Persona ();

      
      Scanner scan = new Scanner (System.in);
      
      System.out.println("Introduzca su nombre");
      p1.set_Nombre(scan.nextLine());
      
      p1.set_Talla(dt.leerFloat("Introduzca su talla: "));
      
      p1.ser_Edad(dt.leerEntero("Introduzca su edad: "));
      

      System.out.println("El nombre introducido es: "+p1.get_Nombre());
      System.out.println("La talla introducida es: "+p1.get_Talla());
      System.out.println("La edad introducida es: "+p1.get_Edad());

      
      System.out.println("Introduzca su nombre");
      p2.set_Nombre(scan.nextLine());
      
      p2.set_Talla(dt.leerFloat("Introduzca su talla: "));
      
      p2.ser_Edad(dt.leerEntero("Introduzca su edad: "));
      

      System.out.println("El nombre introducido es: "+p2.get_Nombre());
      System.out.println("La talla introducida es: "+p2.get_Talla());
      System.out.println("La edad introducida es: "+p2.get_Edad());


      System.out.println("Introduzca su nombre");
      p3.set_Nombre(scan.nextLine());
      
      p3.set_Talla(dt.leerFloat("Introduzca su talla: "));
      
      p3.ser_Edad(dt.leerEntero("Introduzca su edad: "));
      

      System.out.println("El nombre introducido es: "+p3.get_Nombre());
      System.out.println("La talla introducida es: "+p3.get_Talla());
      System.out.println("La edad introducida es: "+p3.get_Edad());












    }
    
}
