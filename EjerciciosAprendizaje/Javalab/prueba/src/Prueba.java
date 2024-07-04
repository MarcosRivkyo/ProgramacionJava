import javax.swing.*;
import java.lang.*;




/**
 *
 * @author Usuario
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String clave="juan";
        String pass="";
       
        String nombre=JOptionPane.showInputDialog("Introduce tu nombre, por favor: "); 
        
        String edad=JOptionPane.showInputDialog("Introduce tu edad, por favor: ");
        
        int edad1=Integer.parseInt(edad);
        
        System.out.printf("Hola "+nombre+" el año que viene tendrás "+(edad1+1)+" años.");
        
        while(clave.equals(pass)==false){
            
            pass=JOptionPane.showInputDialog("Introduzca la contraseña: ");
            
            if(clave.equals(pass)==false){
                
                System.out.printf("%n%nContraseña incorrecta");
                
            }
            
        }
        
        System.out.printf("%n%nContraseña correcta. Acceso permitido");
        
        
   }
    
}
