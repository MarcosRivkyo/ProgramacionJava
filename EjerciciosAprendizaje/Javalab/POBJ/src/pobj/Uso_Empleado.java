package pobj;

import java.util.*;

public class Uso_Empleado {

    public static void main(String[] args) {

        /*Empleado empleado1 = new Empleado("Marcos Rivas", 15000, 2003, 10, 27);
        Empleado empleado2 = new Empleado("Pepe Viyuela", 8500, 1990, 10, 20);
        Empleado empleado3 = new Empleado("Maria Martin", 10500, 1980, 5, 24);

        empleado1.subeSueldo(5);
        empleado2.subeSueldo(5);
        empleado3.subeSueldo(5);

        System.out.println("Nombre: "+empleado1.getNombre()+" Sueldo: "+empleado1.getSueldo()+ " Fecha de Alta: "+empleado1.getFechaContrato());
        System.out.println("Nombre: "+empleado2.getNombre()+" Sueldo: "+empleado2.getSueldo()+ " Fecha de Alta: "+empleado2.getFechaContrato());
        System.out.println("Nombre: "+empleado3.getNombre()+" Sueldo: "+empleado3.getSueldo()+ " Fecha de Alta: "+empleado3.getFechaContrato());*/
        
        Empleado[] misEmpleados = new Empleado[3];
        misEmpleados[0]=new Empleado("Marcos Rivas", 15000, 2003, 10, 27);
        misEmpleados[1]=new Empleado("Pepe Viyuela", 8500, 1990, 10, 20);
        misEmpleados[2]=new Empleado("Maria Martin", 10500, 1980, 5, 24);
   
        /*for(int i=0;i<3;i++){
            
            misEmpleados[i].subeSueldo(5);
            
        }*/
        
        for(Empleado e: misEmpleados){
            
            e.subeSueldo(5);
        }
        
        /*for(int i=0;i<3;i++){
            System.out.println("Nombre: "+misEmpleados[i].getNombre()+ " Sueldo: "+misEmpleados[i].getSueldo()+" Fecha de Alta: "+misEmpleados[i].getFechaContrato());
            
               
        }*/
        for(Empleado e: misEmpleados){
            
            System.out.println("Nombre: "+e.getNombre()+ " Sueldo: "+e.getSueldo()+" Fecha de Alta: "+e .getFechaContrato());
        }
    
    }   

}

class Empleado {

    public Empleado(String nom, double sue, int anio, int mes, int dia) {

        nombre = nom;

        sueldo = sue;

        GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia);

        altaContrato = calendario.getTime();

    }

    public String getNombre() {//GETTER

        return nombre;
    }

    public double getSueldo() {

        return sueldo;
    }

    public Date getFechaContrato() {

        return altaContrato;
    }

    public void subeSueldo(double porcentaje) {

        double aumento = sueldo * porcentaje / 100;

        sueldo += aumento;
    }

    private String nombre;

    private double sueldo;

    private Date altaContrato;

}
