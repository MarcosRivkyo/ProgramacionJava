package data;

import java.nio.file.Files;
import com.coti.tools.Rutas;
import com.coti.tools.OpMat;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 *
 * @author Marcos
 */
public class Modelo {

    //NOMBRES DE LOS FICHEROS
    String folderName = "datos_figuras";
    String csvFileName = "figuras.csv";
    String htmlFileName = "figuras.html";
    String binFileName = "figuras.bin";

    //IMPRESIONES POR PANTALLA
    String mensajeVista = "";

    List<Figura> listFromCSV;
    List<String> lines;

    
    

    
    
 /*===============================================================*/
 /*                      MÉTODOS DE ARCHIVOS                      */
 /*===============================================================*/
    

    public String importarCSV() {
        
        float registrosTransformados = 0f;        
        int registrosTotales = 0;        
        final String DELIMITER = "\t";
        float porcentaje;
        
        File importedCSV = Rutas.fileToFileInFolderOnDesktop(folderName, csvFileName);

        String[][] tmp = null;
        
        try {
                    tmp = OpMat.importFromDisk(importedCSV, DELIMITER);
        } catch (Exception ex) {
                    return mensajeVista = String.format("%n%nNo se pudo importar(figuras.csv). %nSalga de la aplicacion e introduzcala en la carpeta datos_figuras%n%n");
        }
            
        listFromCSV = new ArrayList<>();
            
        
        for (String[] fila : tmp) {
        
                Figura fig = Figura.factory(fila);

                    if (null != fig && !existeFigura(fila[0])) {

                        registrosTransformados++;
                        listFromCSV.add(fig);
                        
                    } else {
                    }
                    registrosTotales++;
        }
        
        porcentaje = 100 * (registrosTransformados / registrosTotales);
        return mensajeVista = String.format("%n\t-Registros leidos en total -> %d. %n\t-Porcentaje de registros transformados correctamente -> %3.2f%%%n%n", registrosTotales, porcentaje);
    
    }

    
    
    public String exportarCSV() {

        final String DELIMITER = "\t";
        File exportedCSV = Rutas.fileToFileInFolderOnDesktop(folderName, csvFileName);

        if (null == listFromCSV) {
            return mensajeVista = String.format("exportarCSV() - ERROR - la lista está vacía");
        }

        lines = new ArrayList<>();
        
        for (Figura fig : listFromCSV) {

            lines.add(fig.delimittedBy(DELIMITER));

        }

        try {
            
            Files.write(exportedCSV.toPath(), lines, Charset.forName("UTF-8"));
            
        } catch (IOException ex) {

            return mensajeVista = String.format("No se pudo exportar (figuras.csv)");
        }

        return mensajeVista = String.format("%n\t-Se han exportado correctamente %d lineas con formato CSV", lines.size());

    }

    
    
    public String exportarHTML() {
        
        File exportedHTML = Rutas.fileToFileInFolderOnDesktop​(folderName, htmlFileName);

        if (exportedHTML.exists()) {
            exportedHTML.delete();
        }
        
        try {
            
            PrintWriter pw = new PrintWriter(exportedHTML);
            pw.printf("<DOCTYPE html>%n"
                    + "<HTML>%n"
                    + "<HEAD>%n"
                    + "<meta charset=\"UTD-8\">%n"
                    + "<H1>GALERIA DE ARTE</H1>%n"
                    + "</HEAD>%n"
                    + "<BODY>");
            pw.printf("<TABLE BORDER=1>%n");
            pw.printf("<TR>"
                    + "<TD>IDENTIFICADOR</TD>" //identificador
                    + "<TD>ALTURA</TD>" //altura
                    + "<TD>MATERIAL</TD>" //material
                    + "<TD>CANTIDAD</TD>" //cantidad
                    + "<TD>AÑO</TD>" //año
                    + "<TD>FOTO</TD>" // foto
                    + "<TD>FABRICANTE</TD>" //fabricante
                    + "</TR>");
            
            for (Figura fig : listFromCSV) {
                
                pw.printf("%s%n", fig.asHTML());
            
            }
            
            pw.printf("</>%n</BODY>%n</HTML>%n");
            pw.close();
            
        } catch (FileNotFoundException ex) {
            
            return mensajeVista = String.format("ERROR AL EXPORTAR A HTML");
            
        }
        
        return mensajeVista = String.format("%n\t-Se han exportado correctamente %d lineas a HTML", listFromCSV.size());
    }

    
 /*===============================================================*/
 /*              MÉTODOS DE GESTIÓN DE GALERÍA                    */
 /*===============================================================*/
    
    
    public String añadirFigura(String[] nuevaFigura) {

        for (Figura f : listFromCSV) {
            
            if (f.getIdentificador().equalsIgnoreCase(nuevaFigura[0])) {
                
                return mensajeVista = String.format("%n\t-ERROR:   La identificacion introducida ya fue anteriormente registrada, pruebe con otra%n%n");
            
            }

        }

        this.listFromCSV.add(Figura.factory(nuevaFigura));
        return mensajeVista = String.format("%n-Figura guardada con exito%n%n");

    }
    

    
    public String[][] consultarDatosFigura(String idFigura) {

        Figura figuraEncontrada = null;

        for (Figura fig : listFromCSV) {
            if (fig.getIdentificador().equalsIgnoreCase(idFigura)) {
                figuraEncontrada = fig;
                break;
            }
        }

        if (figuraEncontrada == null) {
            return null;
        }

        String[][] tmp = new String[7][1];

                tmp[0][0] = figuraEncontrada.getIdentificador();
                tmp[1][0] = figuraEncontrada.getAltura() + "";
                tmp[2][0] = figuraEncontrada.getMaterial();
                tmp[3][0] = figuraEncontrada.getCantidad() + "";
                tmp[4][0] = figuraEncontrada.getAño() + "";
                tmp[5][0] = figuraEncontrada.getFoto();
                tmp[6][0] = figuraEncontrada.getFabricante();
        
        return tmp;
    }


    
    
    public void modificarDatosFigura (String idFigura, String parametro, String valorNuevo){
        
        
        for(int i = 0 ; i<listFromCSV.size() ; i++){
            
            if(listFromCSV.get(i).getIdentificador().equalsIgnoreCase(idFigura)){
                
                switch(parametro){
                    
                    case "altura" -> 
                        listFromCSV.get(i).setAltura(Float.parseFloat(valorNuevo));
                        
                    case "material" -> 
                        listFromCSV.get(i).setMaterial(this.firstCharUpper(valorNuevo));
                        
                    case "cantidad" -> 
                        listFromCSV.get(i).setCantidad(Integer.parseInt(valorNuevo));
                        
                    case "ano" ->
                        listFromCSV.get(i).setAño(Integer.parseInt(valorNuevo));
                        
                    case "foto" -> 
                        listFromCSV.get(i).setFoto(valorNuevo);
                        
                    case "fabricante" ->
                        listFromCSV.get(i).setFabricante(this.firstCharUpper(valorNuevo));
                        
                }
                
            }
            
        }
        
    }
    

    public String eliminarFigura(String idFigura) {

        Figura figuraEncontrada = null;
        
        for (Figura f : listFromCSV) {
            if (f.getIdentificador().equalsIgnoreCase(idFigura)) {
                figuraEncontrada = f;
                break;
            }
        }

        if (figuraEncontrada == null) {
            
            return mensajeVista = String.format("ERROR: fallo inesperado en la busqueda de la figura");
            
        } else {

            listFromCSV.remove(figuraEncontrada);
            return mensajeVista = String.format("FIGURA ELIMINADA CON EXITO%n");
        
        }
    } // eliminarFigura

    

 /*===============================================================*/
 /*                    MÉTODOS DE LISTADOS                        */
 /*===============================================================*/    
    
    
    public String[][] listadoPorIdentificador() {
        
        Comparator<Figura> comp = Comparator.comparing(Figura::getIdentificador);

        if (listFromCSV == null) {
            return null;
        } else {

            listFromCSV.sort(comp);

            String[][] tmp = new String[listFromCSV.size() + 1][7];

            tmp[0][0] = "IDENTIFICADOR";
            tmp[0][1] = "ALTURA";
            tmp[0][2] = "MATERIAL";
            tmp[0][3] = "CANTIDAD";
            tmp[0][4] = "ANO";
            tmp[0][5] = "FOTO";
            tmp[0][6] = "FABRICANTE";

            for (int i = 0; i < listFromCSV.size(); i++) {
                
                tmp[i+1]=listFromCSV.get(i).comoFila();
                
            }

            return tmp;
        }
    }

    
    
    public String[][] listadoPorAñoEIdentificador() {
        
        Comparator<Figura> comp = Comparator.comparing(Figura::getAño).reversed().thenComparing(Figura::getIdentificador);


        if (listFromCSV == null) {
            return null;
        } else {

            listFromCSV.sort(comp);

            String[][] tmp = new String[listFromCSV.size() + 1][7];

            tmp[0][0] = "IDENTIFICADOR";
            tmp[0][1] = "ALTURA";
            tmp[0][2] = "MATERIAL";
            tmp[0][3] = "CANTIDAD";
            tmp[0][4] = "ANO";
            tmp[0][5] = "FOTO";
            tmp[0][6] = "FABRICANTE";

            for (int i = 0; i < listFromCSV.size(); i++) {
                tmp[i+1]=listFromCSV.get(i).comoFila();
            }

            return tmp;
        }

    }

    
    public String[][] listadoPorFabricanteYAño() {
        
        Comparator<Figura> comp = Comparator.comparing(Figura::getFabricante).thenComparing(Figura::getAño);
        
        String[][] tmp = new String[listFromCSV.size() + 1][7];

        if (listFromCSV == null) {
            return null;
        } else {

            listFromCSV.sort(comp);

            tmp[0][0] = "IDENTIFICADOR";
            tmp[0][1] = "ALTURA";
            tmp[0][2] = "MATERIAL";
            tmp[0][3] = "CANTIDAD";
            tmp[0][4] = "ANO";
            tmp[0][5] = "FOTO";
            tmp[0][6] = "FABRICANTE";

            for (int i = 0; i < listFromCSV.size(); i++) {
                tmp[i+1]=listFromCSV.get(i).comoFila();

            }

            return tmp;
        }
    }
    
 /*===============================================================*/
 /*                   MÉTODOS ARCHIVOS BINARIOS                   */
 /*===============================================================*/    

    public boolean load() {

        File rutaFiguras = Rutas.fileToFileInFolderOnDesktop(folderName, binFileName);

        if (rutaFiguras.exists()) {

            FileInputStream fis;
            BufferedInputStream bis;
            ObjectInputStream ois = null;

                try {
                        fis = new FileInputStream(rutaFiguras);
                        bis = new BufferedInputStream(fis);
                        ois = new ObjectInputStream(bis);

                        listFromCSV = (List<Figura>) ois.readObject();

                } catch (FileNotFoundException ex) {
                        return false;
                } catch (IOException | ClassNotFoundException ex) {
                        return false;

                }
                        return true;

        } else {
  
            return false;
        
        }
    }

    
    
    
    public boolean save() {
        File rutaFiguras = Rutas.fileToFileInFolderOnDesktop​(folderName, binFileName);

        FileOutputStream fos;
        BufferedOutputStream bos;
        ObjectOutputStream oos;

            try {
                    fos = new FileOutputStream(rutaFiguras);
                    bos = new BufferedOutputStream(fos);
                    oos = new ObjectOutputStream(bos);

                    if (listFromCSV != null) {
                        oos.writeObject(listFromCSV);
                    } else {
                        return false;
                    }

                    oos.close();
            
                    } catch (FileNotFoundException ex) {
                        return false;
                    } catch (IOException ex) {
                        return false;
                    }

                        return true;
                        
    }

    
 /*===============================================================*/
 /*                      MÉTODOS AUXILIARES                       */
 /*===============================================================*/    

    
    public boolean existeCSV() {
        
        File importedCSV = Rutas.fileToFileInFolderOnDesktop(folderName, csvFileName);

        return importedCSV.exists();
    }
    
    public boolean existeFigura(String idFigura) {

        for (Figura fig : listFromCSV) {
            if (fig.getIdentificador().equalsIgnoreCase(idFigura)) {
                return true;
            }

        }
        return false;
    }

    public String firstCharUpper(String line) {

        String firstLtr = line.substring(0, 1).toUpperCase();
        String restLtr = line.substring(1, line.length()).toLowerCase();

            String upper = firstLtr + restLtr;

        return upper;
    }
    
    
    public boolean comprobacionIdentificador(String identificador) {
        
        boolean flag = true;
        
        if (identificador.isBlank()) {
            flag = false;
        }
        return flag;
    }

    public boolean comprobacionAltura(String altura) {
        
        boolean flag = true;
        
        if (altura.isBlank() || Float.parseFloat(altura) < 0 || Float.parseFloat(altura) > 1.5f) {
            flag = false;
        }
        return flag;
    }

    public boolean comprobacionMaterial(String material) {
       
        boolean flag = true;
        
        if (material.isBlank()) {
            flag = false;
        }
        return flag;
    }

    public boolean comprobacionCantidad(String cantidad) {
       
        boolean flag = true;
        
        if (cantidad.isBlank() || Integer.parseInt(cantidad) < 1) {
            flag = false;
        }
        return flag;
    }

    public boolean comprobacionAño(String año) {
       
        boolean flag = true;
        
        if (año.isBlank() || Integer.parseInt(año) < 0 || Integer.parseInt(año) > 2100) {
            flag = false;
        }
        return flag;
    }

    public boolean comprobacionFoto(String foto) {
       
        boolean flag = true;
        
        if (foto.isBlank() || !foto.endsWith(".png")) {
            flag = false;
        }
        return flag;
    }

    public boolean comprobacionFabricacion(String fabricacion) {
       
        boolean flag = true;
        
        if (fabricacion.isBlank()) {
            flag = false;
        }
        return flag;
    }
}
