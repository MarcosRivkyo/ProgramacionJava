package controller;

import data.Modelo;


/**
 *
 * @author Marcos
 */
public class Controlador {

    
    Modelo m = new Modelo();

    
    /*===============================================================*/
    /*                            ARCHIVOS                           */
    /*===============================================================*/     
    

    /**
     * Intenta importar el fichero "figuras.csv" de la carpeta "datos_figuras"
     * @return String -> Registros importados en total si se importó correctamente. No se pudo importar si no se pudo importar.
     */    
    public String importarCSV() {
        
            return m.importarCSV();
            
    }
    
    /**
     * Intenta exportar al fichero "figuras.csv" en la carpeta "datos_figuras"
     * @return String -> Registros exportados en total si se exportó correctamente. No se pudo exportar si no se pudo exportar.
     */    
    public String exportarCSV(){
        
            return m.exportarCSV();
            
    }
    
    /**
     * Intenta exportar al fichero "figuras.html" en la carpeta "datos_figuras"
     * @return String -> Registros exportados en total si se exportó correctamente. No se pudo exportar si no se pudo exportar.
     */    
    
    public String exportarHTML() {
        
            return m.exportarHTML();
            
    }
    
    /*===============================================================*/
    /*                 MÉTODOS ARCHIVOS BINARIOS                     */
    /*===============================================================*/ 
    
    
    /**
     * intenta leer un archivo de formato binario llamado figuras.bin, situado en la carpeta datos_figuras del Escritorio. 
     * @return true si se leyó correctamente, false si no se pudo leer.
     */        
    public boolean load() {
        
            return m.load();
            
    }

    /**
     * intenta guardar un archivo de formato binario llamado figuras.bin en la carpeta datos_figuras del Escritorio. 
     * @return true si se guardó correctamente, false si no se pudo guardar.
     */          
    public boolean save() {
        
            return m.save();
            
    }
    
    
    /*===============================================================*/
    /*                   GESTIÓN DE LA GALERÍA                      */
    /*===============================================================*/ 
    
    
    /**
     * intenta añadir una figura en la galería, teniendo su identificador. 
     * @param nuevaFigura -Datos de la figura a añadir
     * @return String -> Figura guardar con exito si se añadió correctamente la figura. Error si no se pudo guardar la figura porque su id ya esta en la galeria
     */ 
    public String añadirFigura(String[] nuevaFigura) {
        
            return m.añadirFigura(nuevaFigura);
            
    }

    /**
     * intenta mostrar una figura de la galería, teniendo su identificador. 
     * @param identificador -Id de la figura a consultar
     * @return String[][] -> Lista con los datos de la figura solicitada
     */   
    public String[][] consultarDatosFigura(String identificador) {
        
            return m.consultarDatosFigura(identificador);
            
    }


    /**
     * intenta modificar una figura de la galería, teniendo su identificador. Además solicita el nuevo valor del parámetro indicado.
     * @param idFigura -Id de la figura a modificar, 
     * @param parametro ´       -Índice que indica el parámetro que se modificará
     * @param valorNuevo    -nuevo valor que se asociará a la figura 
     */    
    public void modificarDatosFigura(String idFigura, String parametro, String valorNuevo) {
        
            m.modificarDatosFigura(idFigura, parametro, valorNuevo);
            
    }

    /**
     * intenta eliminar una figura de la galería, teniendo su identificador. Además solicita un mensaje de comprobación para asegurar que desea eliminar
     * la figura de la galería
     * @param identificador -Id de la figura a eliminar
     * @return String -> Figura eliminada con exito si se eliminó la figura, Figura no eliminada si no se pudo eliminar
     */    
    public String eliminarFigura(String identificador) {
        
            return m.eliminarFigura(identificador);
    
    }
    
    
    
    /*===============================================================*/
    /*                            LISTADOS                           */
    /*===============================================================*/ 

    /**
     * intenta mostrar un listado donde se muestran todas las figuras de la galería ordenado por su identificador
     * @return String[][] -> Lista de las figuras ordenada por orden de identificación
     */   
    public String[][] listadoPorIdentificador() {

            return m.listadoPorIdentificador();

    }

    /**
     * intenta mostrar un listado donde se muestran todas las figuras de la galería ordenado descendentemente por su año y ascendentemente por su
     * identificador
     * @return String[][] -> Lista de las figuras ordenada por orden de año e identificación
     */     
    public String[][] listadoPorAñoEIdentificador() {

            return m.listadoPorAñoEIdentificador();

    }
    
   
    /**
     * intenta mostrar un listado donde se muestran todas las figuras de la galería ordenado por su fabricante y año
     * @return String[][] -> Lista de las figuras ordenada por orden de fabricante y año
     */    
    public String[][] listadoPorFabricanteYAño() {

            return m.listadoPorFabricanteYAño();

    }
    
    
    /*===============================================================*/
    /*                     MÉTODOS AUXILIARES                        */
    /*===============================================================*/ 
  
     
    /**
     * Comprueba si existe el fichero CSV "figuras.csv"
     * @return true si existe el fichero figuras.csv en la carpeta datos_figuras
     */
    public boolean existeCSV(){
        
            return m.existeCSV();
    
    }
    
    
    
    /**
     * intenta encontrar una figura de la galería, teniendo su identificador. 
     * @param identificador -Id de la figura a consultar
     * @return true si la figura existe, false si no existe
     */    
    public boolean existeFigura(String identificador) {
        
            return m.existeFigura(identificador);
        
    }
    
     /**
     * comprueba si el identificador es válido atendiendo a sus condiciones corrrespondientes
     * @param identificador -Id de la figura a consultar
     * @return true si la identifiación es vñalida, false si no es válida
     */    
    public boolean comprobacionIdentificador(String identificador) {
        
            return m.comprobacionIdentificador(identificador);
        
    }

     /**
     * comprueba si la altura es válida atendiendo a sus condiciones corrrespondientes
     * @param altura -Altura de la figura a consultar
     * @return true si la altura es vñalida, false si no es válida
     */     
    public boolean comprobacionAltura(String altura) {
        
            return m.comprobacionAltura(altura);
        
    }

     /**
     * comprueba si el material es válido atendiendo a sus condiciones corrrespondientes
     * @param material -Material de la figura a consultar
     * @return true si el material es valido, false si no es válido
     */     
    public boolean comprobacionMaterial(String material) {
        
            return m.comprobacionMaterial(material);
        
    }

     /**
     * comprueba si la cantidad es válido atendiendo a sus condiciones corrrespondientes
     * @param cantidad -Cantidad de la figura a consultar
     * @return true si la cantidad es vñalida, false si no es válida
     */ 
    public boolean comprobacionCantidad(String cantidad) {
        
            return m.comprobacionCantidad(cantidad);
        
    }
    
      /**
     * comprueba si el año es válido atendiendo a sus condiciones corrrespondientes
     * @param año -Año de la figura a consultar
     * @return true si el año es vñalido, false si no es válido
     */ 
    public boolean comprobacionAño(String año) {
        
            return m.comprobacionAño(año);
        
    }
    
     /**
     * comprueba si la foto es válida atendiendo a sus condiciones corrrespondientes
     * @param foto -Foto de la figura a consultar
     * @return true si la foto es vñalida, false si no es válida
     */ 
    public boolean comprobacionFoto(String foto) {
        
            return m.comprobacionFoto(foto);
        
    }
    
    /**
     * comprueba si el fabricante es válido atendiendo a sus condiciones corrrespondientes
     * @param fabricacion -Fabricante de la figura a consultar
     * @return true si el fabricante es valido, false si no es válida
     */    
    public boolean comprobacionFabricacion(String fabricacion) {
        
            return m.comprobacionFabricacion(fabricacion);
        
    }
    
    
    
}
