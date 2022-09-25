/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.ArrayList;
import java.util.Scanner;
import entidades.*;
import metodos.EditarNegocio;
import metodos.EditarPersona;
import metodos.EditarServicio;
/**
 *
 * @author Gustavo
 */
public class Sistema {
    public Sistema(){
        System.out.println("--------Sistema Inicializado-------");    
    }
    public static void main(String[]args){
        int opcion;
        Sistema s = new Sistema();
        boolean salir=true;
        Negocio negocio=s.inicializarSistema();
        while(salir){            
           switch(opcion=opcionMenu()){
               case 1:
                   System.out.printf("\n*********       1       ********\n\t >>>>Negocio<<<<\n");
                   System.out.println();
                   EditarNegocio editarnegocio = new EditarNegocio();
                   editarnegocio.editarInformacionNegocio(negocio);
                   break;
               case 2:
                   System.out.printf("\n*********       2       *********\n\t >>>>Servicios<<<<\n");
                   EditarServicio editarservicio = new EditarServicio();
                   editarservicio.infoServicios(negocio);
                   editarservicio.editarServicio(negocio);
                   break;
                case 3:
                   System.out.printf("\n*********       3       *********\n\t >>>>Empleados<<<<\n");
                   EditarPersona editarempleado = new EditarPersona();
                   editarempleado.infoEmpleados(negocio);
                   editarempleado.editarPersona(negocio, 3);
                   break;
                case 4:
                   System.out.println("\n*********       4       *********\n\t >>>>Clientes<<<<\n");
                   EditarPersona editarcliente = new EditarPersona();
                   editarcliente.infoClientes(negocio);
                   editarcliente.editarPersona(negocio, 4);
                   break;
                case 5:
                   System.out.println("Has seleccionado la opcion 5");
                   break;
                case 6:
                   System.out.println("Has seleccionado la opcion 6");
                   break;
                case 7:
                   System.out.println("***********************  BYE ****************************");
                   salir=false;
                   break;
                default:
                   System.out.println("Solo números entre 1 y 7");
           }
            
       }
    }
    public Negocio inicializarSistema(){
        Empleado e1 = new Empleado("1927263829",true,"Alison","0982737282","alisonsn@hotmail.com");
        Empleado e2 = new Empleado("1701827363",true,"Ronald","0892736456","ronaldsol@hotmail.com");
        Empleado e3 = new Empleado("1700827649",false,"Emanuel","0927362892","emanuksd@hotmail.com");
        Cliente c1 = new Cliente("1927263829","Nath","0982737282","Nath@hotmail.com");
        Cliente c2 = new Cliente("1701827363","Miguel","0892736456","miguel@hotmail.com");
        Cliente c3 = new Cliente("1700827649","Bryan","0927362892","brian@hotmail.com");
        Servicio masaje = new Servicio("MASAJE",60,15.5f,true);
        Servicio circuito = new Servicio("CIRCUITO",30,20.0f,true);
        Servicio ritual = new Servicio("RITUAL", 45, 250.f,true);
        Negocio negocio = new Negocio("HydroSPA","0994709231","hydrospa@gmail.com","av.quevedo sto dgo");
        negocio.getPersonas().add(e1); //getPersonas metodo para obtener la lista de personas del objeto negocio.
        negocio.getPersonas().add(e2);
        negocio.getPersonas().add(e3);
        negocio.getPersonas().add(c1);
        negocio.getPersonas().add(c2);
        negocio.getPersonas().add(c3);
        negocio.setAdministrador(e2);        
        negocio.getServicios().add(masaje); //getServicios método para obtener la lista de servicios del objeto negocio.
        negocio.getServicios().add(circuito);
        negocio.getServicios().add(ritual);
        return negocio;
    }
    public static int opcionMenu(){
        Scanner sc= new Scanner(System.in);
        int opc=0;
        System.out.println("-----***Welcome Menu***----");
        System.out.println("\t1. Negocio");
        System.out.println("\t2. Servicios");
        System.out.println("\t3. Empleados");
        System.out.println("\t4. Clientes");
        System.out.println("\t5. Citas");
        System.out.println("\t6. Atenciones");
        System.out.println("\t7. Salir\n\n");
        do{
            System.out.println("Ingrese opcion [1-7]");
            opc=sc.nextInt();
        }while(opc<0 || opc>7);
        return opc;
    }
     
    
    
}
