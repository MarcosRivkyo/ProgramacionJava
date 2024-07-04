/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio11clases;

/**
 *
 * @author Usuario
 */
public class Persona {
    
    float nota_1;
    float nota_2;
    float nota_3;
    double nota_media;
    
   void set_nota1 (float nota){
       
       this.nota_1=nota;
       
   }
    void set_nota2 (float nota){
       
       this.nota_2=nota;
       
   }
   void set_nota3 (float nota){
       
       this.nota_3=nota;
       
   }
    
   double nota_media (){
       
       double nota1=nota_1*0.2;
       double nota2=nota_2*0.2;
       double nota3=nota_3*0.6;
       
       nota_media=nota1+nota2+nota3;
       
       return nota_media;
   }
    
   float get_nota1 (){
       
       return nota_1;
   }
    float get_nota2 (){
       
       return nota_2;
   }
    float get_nota3 (){
       
       return nota_3;
   }
}
