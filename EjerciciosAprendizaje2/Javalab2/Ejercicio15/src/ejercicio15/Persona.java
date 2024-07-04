/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio15;

/**
 *
 * @author Usuario
 */
public class Persona {
    
    String nombre;
    
    float talla;
    
    int edad;
    
    Persona (){
        
        nombre=" ";
        edad=0;
        talla=0;
        
        
    }
    
    void set_Nombre (String nombre){
        
        this.nombre=nombre;
    }
    
        
    void set_Talla (float talla){
        
        this.talla=talla;
    }
    
    void ser_Edad (int edad){
        
        this.edad=edad;
    }

    
    String get_Nombre (){
        return nombre;
    }
    
    int get_Edad (){
       return edad; 
    }
    
    float get_Talla (){
        return talla;
    }
    
}
