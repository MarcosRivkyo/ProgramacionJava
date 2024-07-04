import java.io.Console;
import static java.lang.System.out;
import java.util.Scanner;




/**
 *
 * @author alumno
 */
public class ejer{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Console con=System.console();
    if(null!=con){
          
        con.printf("Vamos a sumar dos numeros\n");
        con.printf("*************************\n");
        
        String cad = con.readLine("Introduzca el 1º numero entero: ");
        int num1 = Integer.parseInt(cad);
        int num2 = Integer.parseInt(con.readLine("Introduzca el 2º numero entero: "));
        int resul=sumar(num1, num2);
        con.printf("La suma de %d y %d es %d\n", num1, num2, resul);
        
    }
    else{
        
        System.err.println("No podemos ejecutar este programa desde NetBeans.");
        
    }
    
    
        
    }
    
    
    
    
    static int sumar (int a, int b){
        int resul=a+b;
        return resul;
    
    
    
    }
    
}
