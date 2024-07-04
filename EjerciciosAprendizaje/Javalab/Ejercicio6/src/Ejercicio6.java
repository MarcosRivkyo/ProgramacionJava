import java.io.Console;
import java.util.Scanner;




/**
 *
 * @author Marcosky
 */
public class Ejercicio6 {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("               EJERCICIO 6");
        System.out.println("=======================================");
        
        Console con = System.console();
        if(null!=con){
            //CONSOLE
            float suma=0;
            
            con.printf("A continuación, introduzca los resultados de los 10 partidos: \n");
            int [] lista=new int[10];
            for(int i=0 ; i<10 ; i++){
                
               
                lista[i]=Integer.parseInt(con.readLine("Introduzca el numero de goles introducidos en el %dº partido", i+1));
                suma=suma+lista[i];
                
             
            }
            
            float media = calculoMedia(suma, 10);
            
            
            con.printf("La media de goles marcados es: %f", media);
            
            
            
            
            
        }
        else{
            //SCANNER
            int suma=0;
            Scanner scan = new Scanner(System.in);
            System.out.printf("A continuación, introduzca los resultados de los 10 partidos: \n");
            int [] lista=new int[10];
            for(int i=0;i<10;i++){
                
                System.out.printf("Introduzca el numero de goles introducidos en el %dº partido\n", i+1);
                lista[i]=scan.nextInt();
                suma=suma+lista[i];
            }
            
            float media = calculoMedia(suma, 10);
            
            System.out.println("La media de goles marcados es de"+media+"goles");
        }
        
        

    }
    static float calculoMedia(float a,int b){
        
        float media=a/b;
        return media;
        
    }
    
}
