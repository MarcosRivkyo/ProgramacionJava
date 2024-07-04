package view;

import controller.Controlador;

import static com.coti.tools.DiaUtil.clear;
import static com.coti.tools.Esdia.*;
import static com.coti.tools.Esdia.underline2;
import static com.coti.tools.OpMat.printToScreen3;
import static com.coti.tools.DiaUtil.showFinalTime;
import java.util.Arrays;

/**
 *
 * @author Marcos
 */
public class Vista {

    /**
     * Controlador usado para comunicarse con el Modelo
     */
    Controlador c = new Controlador();

 /*======================================================*/
 /*           MÉTODO MOSTRAR MENÚ PRINCIPAL              */
 /*======================================================*/
    public void runMenu(String menu) {

        boolean salir = false;
        String option;
        String[] availableOptions = {"1", "2", "3", "4"};

        do {
            option = readString(menu, availableOptions);

            switch (option) {

                case "1" ->
                    
                        this.menuArchivos("%n===================================="
                                + "%n              ARCHIVOS"
                                + "%n===================================="
                                + "%na. Importar CSV"
                                + "%nb. Exportar CSV"
                                + "%nc. Exportar HTML"
                                + "%n%nSeleccione la opcion que desea realizar>>");
                        
                        
                case "2" ->
                    
                        this.menuGestionDeLaGaleria("%n===================================="
                                + "%n        GESTION DE LA GALERIA"
                                + "%n===================================="
                                + "%na. Anadir una figura al inventario"
                                + "%nb. Consultar datos de una figura"
                                + "%nc. Modificar datos de una figura"
                                + "%nd. Eliminar una figura del inventario"
                                + "%n%nSeleccione la opcion que desea realizar>>");
                        
                        
                case "3" ->
                    
                        this.menuListados("%n===================================="
                            + "%n              LISTADOS"
                            + "%n===================================="
                            + "%na. Listado por identificador"
                            + "%nb. Listado por año e identificador"
                            + "%nc. Listado por fabricante y año"
                            + "%n%nSeleccione la opcion que desea realizar>>");
                        
                        
                case "4" -> {
                    
                        salir = siOno("Desea  salir de la aplicación? ");
                    
                        if (salir) {
                                System.out.printf("%n%n%nSALIENDO DE LA APLICACION...%n%n%n");
                        }
                    
                }

                default ->
                    
                        System.out.printf("%n%nOPCION INCORRECTA: Introduzca una opcion valida.%n%n");
            }

        } while (!salir);

    }// fin runMenu

 /*======================================================*/
 /*           MÉTODO MOSTRAR MENÚ ARCHIVOS               */
 /*======================================================*/
    public void menuArchivos(String menu) {
        
        String option;
        
        clear();

        option = readString(menu).toLowerCase();

        switch (option) {

            case "a" ->
                
                        this.importarCSV();

            case "b" ->
                
                        this.exportarCSV();

            case "c" ->
                
                        this.exportarHTML();

            default ->
                
                        System.out.printf("%n%nOPCION INCORRECTA: Introduzca una opcion valida.%n%n");

        }

    }// fin archivos

  /*================================================================*/
 /*           MÉTODO MOSTRAR MENÚ GESTIÓN DE LA GALERÍA            */
 /*================================================================*/
    public void menuGestionDeLaGaleria(String menu) {
        
        String option;
        
        clear();

        option = readString(menu).toLowerCase();

        switch (option) {

            case "a" ->
                
                        this.añadirFigura();

            case "b" ->
                
                        this.consultarDatosFigura();

            case "c" ->
                
                        this.modificarDatosFigura();

            case "d" ->
                
                        this.eliminarFigura();

            default ->
                
                        System.out.printf("%n%nOPCION INCORRECTA: Introduzca una opcion valida.%n%n");

        }

    }// fin gestionDeLaGaleria

 /*================================================================*/
 /*                MÉTODO MOSTRAR MENÚ LISTADOS                    */
 /*================================================================*/
    public void menuListados(String menu) {
   
        String option;

        clear();

        option = readString(menu).toLowerCase();

        switch (option) {

            case "a" ->
                
                        this.listadoPorIdentificador();

            case "b" ->
                
                        this.listadoPorAñoEIdentificador();

            case "c" ->
                
                        this.listadoPorFabricanteYAño();

            default ->
                
                        System.out.printf("%n%nOPCION INCORRECTA: Introduzca una opcion valida.%n%n");

        }

    }//fin listados

 /*====================================================*/
 /*                MÉTODOS ARCHIVOS                    */
 /*====================================================*/
 
    
    /*=================     IMPORTAR CSV     ==================*/
   
    /**
     * La opción Importar CSV intenta leer de disco el archivo figuras.csv
     * situado en la carpeta datos_figuras. Si el archivo no existe, se le
     * notificará al usuario.
     */
    public void importarCSV() {

        boolean existe;
        existe = c.existeCSV();
        /*<------- Se comprueba si existe el fichero CSV*/

        if (!existe) {
            /*<------- Si no existe no se puede importar*/

                System.out.printf("%n%n\tNo existe el archivo a importar(figuras.csv)%n");
                System.out.printf("%n\tIMPORTACION DE CSV REALIZADA SIN EXITO%n");

        } else {
            /*<------- Si existe se puede importar*/

                System.out.printf("%s", c.importarCSV());
                System.out.printf("%n%n\tIMPORTACION DE CSV REALIZADA CON EXITO%n%n");
        }
        
    }//fin importarCSV

    
    /*=================     EXPORTAR CSV     ==================*/
    
    /**
     * La opción Exportar CSV, exportará en un archivo CSV la relación de
     * Figuras disponible en la aplicación en ese momento, almacenando la
     * información con el mismo formato usado para su lectura.
     */
    public void exportarCSV() {

        boolean existe;
        existe = c.existeCSV();
        /*<------- Se comprueba si existe el fichero CSV*/

        if (!existe) {
            /*<------- Si no existe no se puede exportar*/

                System.out.printf("%n%n\tNo existe el archivo a exportar (figuras.csv)%n");
                System.out.printf("%n\tEXPORTACION DE CSV REALIZADA SIN EXITO%n");
        } else {
            /*<------- Si existe se puede exportar*/

                System.out.printf("%s", c.exportarCSV());
                System.out.printf("%n%n\tEXPORTACION A CSV REALIZADA CON EXITO%n%n");

        }
    }//fin exportarCSV

    /*=================     EXPORTAR HTML     ==================*/
    
    /**
     * La opción Exportar HTML genera un archivo llamado figuras.html situado en
     * la carpeta datos_figuras, que muestra una tabla sencilla con el listado
     * completo de figuras disponible en ese momento.
     */
    
    public void exportarHTML() {

            System.out.printf("%s", c.exportarHTML());
            System.out.printf("%n%n\tEXPORTACION A HTML REALIZADA CON EXITO%n%n");

    }//fin exportarHTML

 /*===============================================================*/
 /*                      GESTIÓN DE LA GALERÍA                    */
 /*===============================================================*/
 
    /*=================     AÑADIR UNA FIGURA     ==================*/
    
    /**
     * Esta opción pide al usuario todos los datos de una figura nueva,
     * comprobando la validez de los mismos. La información, una vez leída, se
     * almacena en forma de un ejemplar de figura en la clase Modelo junto al
     * resto de figuras existentes.
     */
    public void añadirFigura() {

        boolean salir;
        String[] nuevaFigura = new String[7];

        clear();
        underline2("%nAÑADIR FIGURA");

        do {
            nuevaFigura[0] = readString("\t-Introduzca el identificador      : ");
            salir = c.comprobacionIdentificador(nuevaFigura[0]);
                if(!salir){
                        System.out.printf("%n\tERROR:  Debe de introducir el identificador de la figura%n%n");
                }
                
        } while (!salir);

        do {
            nuevaFigura[1] = readString("\t-Introduzca la altura             : ");            
            salir = c.comprobacionAltura(nuevaFigura[1]);
                if(!salir){
                        System.out.printf("%n\tERROR:  Debe de introducir alturas menores que 1.5 metros%n%n");
                }
                
        } while (!salir);

        do {
            nuevaFigura[2] = readString("\t-Introduzca el material           : ");
            salir = c.comprobacionMaterial(nuevaFigura[2]);
                if(!salir){
                        System.out.printf("%n\tERROR:  Debe de introducir el material empleado en la figura%n%n");
                }
                
        } while (!salir);

        do {
            nuevaFigura[3] = readString("\t-Introduzca la cantidad           : ");
            salir = c.comprobacionCantidad(nuevaFigura[3]);
                if(!salir){
                        System.out.printf("%n\tERROR:  Debe de tener por lo menos un ejemplar%n%n");
                }
                
        } while (!salir);

        do {
            nuevaFigura[4] = readString("\t-Introduzca el año                : ");
            salir = c.comprobacionAño(nuevaFigura[4]);
                if(!salir){
                        System.out.printf("%n\tERROR:  Debe de ser creada entre el año 0 y 2100%n%n");
                }
                
        } while (!salir);

        do {
            
            nuevaFigura[5] = readString("\t-Introduzca la foto               : ");
            salir = c.comprobacionFoto(nuevaFigura[5]);
                if(!salir){
                        System.out.printf("%n\tERROR:  Debe de introducir la foto de la figura con formato .png%n%n");
                }
                
        } while (!salir);

        do {
            
            nuevaFigura[6] = readString("\t-Introduzca el fabricante         : ");
            salir = c.comprobacionFabricacion(nuevaFigura[6]);
                if(!salir){
                        System.out.printf("%n\tERROR:  Debe de introducir el fabricante de la figura%n%n");
                }
                
        } while (!salir);

        
        System.out.printf("%s", c.añadirFigura(nuevaFigura));


    }// fin añadirFigura

    
    /*=================     CONSULTAR DATOS DE UNA FIGURA     ==================*/
    
    /**
     * Se pide al usuario el identificador de la figura deseada. Si ese
     * identificador existe, se muestran correctamente los datos de la figura en
     * la terminal. Si no existe, se notifica al usuario y se vuelve al menú de
     * Gestión.
     */
    
    public void consultarDatosFigura() {

        String idFigura;
        boolean encontrado;

        clear();
        underline2("CONSULTAR FIGURA");

        do {

            idFigura = readString("Identificador de la figura a consultar: ");

        } while (idFigura.isBlank());

        encontrado = c.existeFigura(idFigura);

        if (!encontrado) {
            
            System.out.printf("%n%nERROR: no se ha encontrado la figura solicitada%n%n");
        
        } else {

            System.out.printf("%nFigura encontrada%n%n");
            String[][] tmp = c.consultarDatosFigura(idFigura);
                try {
                    printToScreen3(tmp);

                } catch (Exception ex) {
                        System.out.printf("%n%nERROR: no se ha podido consultar la figura correctamente");
                }

        }

    }// fin consultarDatosFigura

    
    /*=================     MODIFICAR DATOS DE UNA FIGURA     ==================*/
    
    /**
     * Se pide al usuario el identificador de la figura deseada. Si ese
     * identificador existe, se muestran correctamente los datos de la figura en
     * la terminal. Si no existe, se notifica al usuario. Una vez mostrados los
     * datos, se permite al usuario modificar cualquiera de ellos salvo el
     * identificador.
     */
  
    
    public void modificarDatosFigura(){
        
        String idFigura;
        boolean flag=false;
        boolean encontrado;
        String valorNuevo;
        String[] atributos = {"identificador", "altura", "material", "cantidad", "ano", "foto", "fabricante"};
        String parametro = "";        


        clear();
        underline2("MODIFICAR FIGURA");

        do {

            idFigura = readString("Identificador de la figura a modificar: ");
            
        } while (idFigura.isBlank());
       
        encontrado = c.existeFigura(idFigura);
        
        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado la figura solicitada%n");
        } else {

            System.out.printf("%n%nFigura encontrada%n%n");
            String[][] tmp = c.consultarDatosFigura(idFigura);
            
                try {
                        printToScreen3(tmp);
                } catch (Exception ex) {
                        System.out.printf("%n%nERROR: no se ha podido consultar la figura correctamente%n%n");
                }

                
                System.out.printf("%n%nPARAMETROS MODIFICABLES: " + Arrays.toString(atributos) + "%n%n");        
        
                do{
                        parametro = readString("Introduzca el parametro que desea modificar (No se puede modificar el identificador)%n");
                
                }while(parametro.equalsIgnoreCase("identificador") ||
                        !parametro.equalsIgnoreCase("altura") &&
                        !parametro.equalsIgnoreCase("material") &&
                        !parametro.equalsIgnoreCase("cantidad") &&
                        !parametro.equalsIgnoreCase("ano") &&
                        !parametro.equalsIgnoreCase("foto") &&
                        !parametro.equalsIgnoreCase("fabricante"));
            
            
                do{
                    valorNuevo = readString("Introduzca un nuevo/a "+parametro+" valido%n");
                
                        if(parametro.equalsIgnoreCase("altura")){
 
                            flag=c.comprobacionAltura(valorNuevo);
                    
                        }else if (parametro.equalsIgnoreCase("material")){
                
                            flag=c.comprobacionMaterial(valorNuevo);
                    
                        }else if (parametro.equalsIgnoreCase("cantidad")){
 
                            flag=c.comprobacionCantidad(valorNuevo);
                    
                        }else if (parametro.equalsIgnoreCase("ano")){

                            flag=c.comprobacionAño(valorNuevo);
                    
                        }else if (parametro.equalsIgnoreCase("foto")){
                    
                            flag=c.comprobacionFoto(valorNuevo);
                    
                        }else if (parametro.equalsIgnoreCase("fabricante")){

                            flag=c.comprobacionFabricacion(valorNuevo);
                    
                        }
                
                    }while(!flag);
            
            c.modificarDatosFigura(idFigura, parametro, valorNuevo);
            
            }
    }//fin modificarDatosFigura

    
    /*=================     ELIMINAR UNA FIGURA     ==================*/
    
    /**
     * Se pide al usuario el identificador de la figura deseada. -Si ese
     * identificador existe, se muestran correctamente los datos de la figura en
     * la terminal. -Si no existe, se notifica al usuario y se vuelve al menú de
     * Gestión. -Si la figura existe, se pide al usuario que confirme la
     * eliminación de la figura y si el usuario la confirma la figura se elimina
     * del modelo y se notifica al usuario que se ha borrado la figura.
     */
    
    public void eliminarFigura() {

        String idFigura;

        clear();
        underline2("ELIMINAR FIGURA");

        do {

            idFigura = readString("Identifidor de la figura a eliminar: ");

        } while (idFigura.isBlank());

        boolean encontrado = c.existeFigura(idFigura);

        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado la figura%n%n");
        } else {

            System.out.printf("%nFigura encontrada%n");
            System.out.printf("%n");
            String[][] tmp = c.consultarDatosFigura(idFigura);

                try {
                    printToScreen3(tmp);
                } catch (Exception ex) {
                    System.out.printf("%n%nERROR: no se ha podido consultar la figura correctamente%n%n");
                }

                String seguridad = readString("%n%nSeguro que desea eliminar la figura " + idFigura + "? (s/n): ").toLowerCase();

                if (seguridad.equalsIgnoreCase("s")) {
                    System.out.printf("%nEliminando figura...%n%n");
                    try {
                            System.out.printf(c.eliminarFigura(idFigura));
                    } catch (Exception ex) {
                            System.out.printf("%n%nERROR: no se ha podido eliminar la figura correctamente%n%n");
                    }
                    
            } else if (seguridad.equalsIgnoreCase("n")) {
                
                System.out.printf("%n%nFigura no eliminada%n%n");
            
            }
        }
    }// fin eliminarFigura

 /*===============================================================*/
 /*                            LISTADOS                           */
 /*===============================================================*/
 
    /*=================      LISTADO POR IDENTIFICADOR     ==================*/
    /**
     * Se genera una tabla en pantalla, ordenada ascendentemente por
     * identificador.
     */
    
    public void listadoPorIdentificador() {

        System.out.printf("%n%nImprimiendo figuras disponibles ordenadas por IDENTIFICADOR...%n%n");
        String[][] figuras = c.listadoPorIdentificador();

        if (figuras == null) {
            
            System.out.printf("%n%nERROR: no se ha encontrado ninguna figura%n%n");
        
        } else {
            
                try {
                        printToScreen3(figuras);
                } catch (Exception ex) {
                        System.out.printf("%n%nERROR: no se ha podido mostrar la tabla de figuras correctamente%n%n");
                }
        }   
        
        System.out.printf("%n%n");

    }//fin listadoPorIdentificador

    /*=================      LISTADO POR AÑO E IDENTIFICADOR     ==================*/
    
    /**
     * Se genera una tabla en pantalla, ordenada descendentemente por año y
     * ascendentemente por identificador.
     */
    
    public void listadoPorAñoEIdentificador() {

        System.out.printf("%n%nImprimiendo figuras disponibles ordenadas por ANO e IDENTIFICADOR...%n%n");
        String[][] figuras = c.listadoPorAñoEIdentificador();

        if (figuras == null) {
            
            System.out.printf("%n%nERROR: no se ha encontrado ninguna figura%n%n");
        
        } else {
            
                try {
                        printToScreen3(figuras);
                } catch (Exception ex) {
                        System.out.printf("%n%nERROR: no se ha podido mostrar la tabla de figuras correctamente%n%n");
                }
        }

        System.out.printf("%n%n");
    
    }//fin listadoPorAñoEIdentificador

    /*=================      LISTADO POR FABRICANTE Y AÑO     ==================*/
    
    /**
     * Se genera una tabla en pantalla, ordenada ascendentemente por fabricante
     * y año.
     */
    
    public void listadoPorFabricanteYAño() {

        System.out.printf("%n%nImprimiendo figuras disponibles ordenadas por FABRICANTE Y AÑO...%n%n");
        String[][] figuras = c.listadoPorFabricanteYAño();

        if (figuras == null) {
            
            System.out.printf("%n%nERROR: no se ha encontrado ninguna figura%n%n");
        
        } else {
            
                try {
                        printToScreen3(figuras);
                } catch (Exception ex) {
                        System.out.printf("%n%nERROR: no se ha podido mostrar la tabla de figuras correctamente%n%n");
                }
        }

        System.out.printf("%n%n");

    }//fin listadoPorFabricanteYAño

 /*===============================================================*/
 /*                            ARRANQUE                           */
 /*===============================================================*/

    /**
     * En el arranque intenta leer un archivo de formato binario llamado
     * figuras.bin, situado en la carpeta datos_figuras del Escritorio. Si
     * existe, contiene todos los datos que poseía la aplicación inmediatamente
     * antes de salir por última vez. Si no existe, se muestra un mensaje al
     * usuario y le permite importar un archivo de formato CSV. .
     */

    public void arranque() {

        boolean arranque = c.load();
        boolean importar;
        
        if (!arranque) {
            
            System.out.printf("El archivo figuras.bin NO existe en la carpeta datos_figuras%n%n");

            importar = siOno("Desea importar un archivo de formato CSV mediante la opcion Importar CSV?");

            if (importar == true) {
                
                    System.out.printf("%n%n\tIMPORTANDO figuras.csv...");
                    System.out.printf("%s", c.importarCSV());

            } else {
                
                    showFinalTime();
                    System.exit(0);

            }

        }
        else{
            
            System.out.printf("El archivo figuras.bin Si existe en la carpeta datos_figuras%n%n");            
        
        }

    }// fin arranque

    
 /*===============================================================*/
 /*                            CIERRE                           */
 /*===============================================================*/    
    
    /**
     * La aplicación guarda sus datos con formato binario inmediatamente antes
     * de salir, y trata de leerlos inmediatamente después de arrancar (antes de
     * mostrar el menú principal).
     */
    
    public void cierre() {
        
        boolean cierre = c.save();
        
        if (!cierre) {
                
                System.out.printf("El archivo figuras.bin no se ha podido guardar correctamente");

        } else {

                System.out.printf("El archivo figuras.bin ha sido guardado correctamente");

        }

    }//fin cierre

}
