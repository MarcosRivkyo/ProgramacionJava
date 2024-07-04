package data;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author Marcos
 */

public class Figura implements Serializable {

    
    /*Atributos de figuras.*/

        String identificador;
        float altura;
        String material;
        int cantidad;
        int año;
        String foto;
        String fabricante;

    
    /*Clases necesarias para establecer el formato (numérico e idioma)*/
    
        public static final Locale ENGLISH = new Locale("en", "EN");
        public static final NumberFormat NF = NumberFormat.getInstance(ENGLISH);

    
    /*======================================================*/
    /*                   CONSTRUCTORES                       */
    /*======================================================*/
    
    
    public Figura(String identificador,
                  float altura,
                  String material,
                  int cantidad,
                  int año,
                  String foto,
                  String fabricante) {

        this.identificador = identificador;
        this.altura = altura;
        this.material = material;
        this.cantidad = cantidad;
        this.año = año;
        this.foto = foto;
        this.fabricante = fabricante;
    }

    
    public Figura() {

        this.identificador = "DESCONOCIDO";
        this.altura = 0.0f;
        this.material = "DESCONOCIDO";
        this.cantidad = 0;
        this.año = 0;
        this.foto = "DESCONOCIDO";
        this.fabricante = "DESCONOCIDO";
    }

    
    /*======================================================*/
    /*                  GETTERS Y SETTERS                   */
    /*======================================================*/
    
    
    public String getIdentificador() {
            return identificador;
    }

    public void setIdentificador(String identificador) {
            this.identificador = identificador;
    }

    public float getAltura() {
            return altura;
    }

    public void setAltura(float altura) {
            this.altura = altura;
    }

    public String getMaterial() {
            return material;
    }

    public void setMaterial(String material) {
            this.material = material;
    }

    public int getCantidad() {
            return cantidad;
    }

    public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    
    /*======================================================*/
    /*                      MÉTODOS                         */
    /*======================================================*/    
    
    
     /**
     * El Factory Method define un método que debe utilizarse para crear objetos, en lugar de una llamada directa al constructor
     * @param line - String línea que contine todos los datos 
     * @param numCols - número de datos que tiene la clase figura 
     * @return La nueva Figura creada con los datos introducidos
     */
    
    
    public static Figura factory(String line, int[] numCols) {
       
        final int NUM_FIELDS = 7;
        int firstIndex = 0;
        int lastIndex = numCols[0];
        String[] f = new String[NUM_FIELDS];
        

        if (numCols.length != NUM_FIELDS) {
            return null;
        }
        
        f[0] = line.substring(firstIndex, lastIndex);
        
        for (int n = 1; n < NUM_FIELDS; n++) {
            
                firstIndex = lastIndex;
                lastIndex = firstIndex + numCols[n];
                f[n] = line.substring(firstIndex, lastIndex).strip();
        }
        
        return Figura.factory(f);
    
    }

     /**
     * El Factory Method define un método que debe utilizarse para crear objetos, en lugar de una llamada directa al constructor
     * @param f - Vector de strings que recibe del factory anterior, los datos de la nueva Figura en forma de vector.
     * @return La nueva Figura creada con los datos introducidos
     */        
        
    public static Figura factory(String[] f) {

        for (String s : f) {                                                                /*<------ Comprobación para ver que no hay campos vacíos*/                    
            if (s.isBlank()) {
                return null;
            }

        }

        if (f.length != 7) {                                                                /*<------ Comprobación para ver que no hay más campos */  
            return null;
        }


        float token1;                                                                       /*<------ Conversión de los datos necesarios(ALTURA a float, CANTIDAD a int, AÑO a int)*/
        int token3, token4;
        String token2, token6;
        Locale locale = Locale.ENGLISH;
        NumberFormat nf = NumberFormat.getInstance(locale);
        
        
        
      
        token2=toUpperFirstChar(f[2]);                                                      /*<------ Puesta de Strings iniciados con mayúsucla (necesario para el listado ordenado por fábrica)*/

        token6=toUpperFirstChar(f[6]);


        try {

                token1 = nf.parse(f[1].trim()).floatValue();
                token3 = nf.parse(f[3].trim()).intValue();
                token4 = nf.parse(f[4].trim()).intValue();
            
        } catch (ParseException ex) {
            return null;
        }
        //COMPROBACIONES

        //COMPROBACION DE LA ALTURA
        if (token1 > 1.5f || token1<0) {
            return null;
        }
        //COMPROBACION DEL MATERIAL        

        if (f[2].isBlank()) {
            return null;
        }

        //COMPROBACION DE LA CANTIDAD
        if (token3 < 1) {
            return null;
        }

        //COMPROBACION DEL AÑO        
        if (token4 < 0 || token4 > 2100) {
            return null;
        }

        //COMPROBACION DE LA FOTO                
        if (!f[5].endsWith(".png")) {
            return null;
        }
        //COMPROBACION DEL FABRICANTE                
        if (token6.isBlank()) {
            return null;
        }

        return new Figura(f[0], 
                    token1, 
                   token2, 
                   token3, 
                       token4, 
                          f[5], 
                 token6);

         

    }

    
     /**
     * Crea una cadena con el formato utilizado para la exportación que es el mismo que el empleado para la importación.
     * @param delimiter - Caracter usado como delimitador en los ficheros, que separa cada campo de los datos de cada figura.
     * @return String -> Cadena formateada adecuada a cada dato y separada por el delimitador, \t.
     */        

    public String delimittedBy(String delimiter) {
        String result;
        var actualLocale = Locale.ENGLISH;

        result = String.format(actualLocale,
                "%s"
                + "%s"
                + "%4.3f"
                + "%s"
                + "%s"
                + "%s"
                + "%d"
                + "%s"
                + "%d"
                + "%s"
                + "%s"
                + "%s"
                + "%s", this.identificador, delimiter, this.altura, delimiter, this.material, delimiter, this.cantidad, delimiter,
                        this.año, delimiter, this.foto, delimiter, this.fabricante);
        return result;
    }

     /**
     * Crea una cadena con el formato utilizado para la exportación en HTML, con sus especificadores de formato correspondientes.
     * @return String -> Cadena formateada adecuada a cada dato en formato HTML.
     */        
    
    public String asHTML() {

        String tabla = String.format("<TR>"
                + "<TD>%s</TD>" //identificador
                + "<TD>%s</TD>" //altura
                + "<TD>%s</TD>" //material
                + "<TD>%s</TD>" //cantidad
                + "<TD>%s</TD>" //año
                + "<TD>%s</TD>" // foto
                + "<TD>%s</TD>" //fabricante
                + "</TR>",
                
                this.identificador, 
                this.altura, 
                this.material, 
                this.cantidad, 
                this.año, 
                this.foto, 
                this.fabricante);
        
        
        return tabla;
        
    }
    
    public String[] comoFila(){
        
        
        String[] fila = {this.identificador,
                        this.altura+"",
                        this.material,
                        this.cantidad+"",
                        this.año+"",
                        this.foto,
                        this.fabricante
                        };
       
        return fila;
        
    }
    
    public static String toUpperFirstChar(String palabra){
        
        String formateado;
        
        String firstLtr2 = palabra.substring(0,1).toUpperCase();
        String restLtr2 = palabra.substring(1,palabra.length()).toLowerCase();
        
            formateado=firstLtr2+restLtr2;        
        
        return formateado;
        
    }

}
