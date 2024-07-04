package main;

import view.Vista;
import static com.coti.tools.DiaUtil.*;


/**
 *
 * @author Marcos
 */

public class GaleriaDeArte {

    public static void main(String[] args){

        Vista v = new Vista();                  

        clear();
        
        //1º Intenta cargar el archivo binario figuras.bin
        v.arranque();
                

        //2º Muestra el menú principal de la aplicación
        v.runMenu(String.format("%n===============%n"
                                   + "GALERIA DE ARTE"
                                  + "%n==============="
                                   + "%n1. Archivos"
                                   + "%n2. Gestion de la galeria"
                                   + "%n3. Listados"
                                   + "%n4. Salir"
                                   + "%n%nSeleccione una opcion>>"));
        
        //3º Intenta guardar el archivo binario figuras.bin        
        v.cierre();
        
        showFinalTime();
        
    }

}
