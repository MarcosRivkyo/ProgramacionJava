/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo;

import javax.swing.*;
/**
 *
 * @author Usuario
 */
public class Uso_coche {

    public static void main(String[] args) {
        
        Coche micoche = new Coche();
                
        System.out.println (micoche.dime_datos_generales());
        
        micoche.establece_color(JOptionPane.showInputDialog("¿De qué color es?"));
        System.out.println(micoche.dime_color());
        
        micoche.configura_asientos(JOptionPane.showInputDialog("¿Tiene asientos de cuero?"));
        System.out.printf(micoche.dime_asientos());
    
        micoche.configurar_climatizador(JOptionPane.showInputDialog("¿Tiene climatizador?"));
        
        System.out.println(micoche.dime_climatizador());
    
    
        System.out.println(micoche.dime_peso_carroceria());
        
        
        System.out.println("El precio final del coche es"+micoche.precio_coche());
        
    }
    
    
}
