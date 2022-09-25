/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import entidades.Negocio;
import entidades.Servicio;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class EditarServicio {
    Registro registro = new Registro();
    public void infoServicios(Negocio n){
        System.out.println("\nLos servicios son los siguientes:");
            for(Servicio s : n.getServicios()){
                System.out.println(s);
            }
            System.out.printf("\n\n");
    }
    public void editarServicio(Negocio n){
        Scanner sc = new Scanner(System.in);
        int opcion=0,duracion=0,opcioncambio=0,indiceObjServicio;
        float precio=0.0f; boolean estado=false,bandera=true;
        String nombre="",indicacion = "\t***SERVICIO***\n\t1.Agregar Servicio\n\t2.Editar Servicio"
                + "\n\t3.Eliminar Servicio\n\t4.Regresa\n\nIngrese opcion [1-4]",
                indicacioncambio="\nIngrese opcion de cambio\n\t1.Nombre\n\t2.Duracion\n\t3.Precio"
                + "\n\t4.Estado(true=activo,false=inactivo)\n\t5.Regresar\nIngrese opcion[1-5]";
        System.out.println(indicacion);
        opcion=sc.nextInt();
        while(opcion!=4){
            if(opcion<1 || opcion>4){
                System.out.printf("Solo ingresar opciones entre [1-4]\nIngrese opcion[1-4]:\t");
                opcion=sc.nextInt();
            }else{
                if(opcion==1){n.getServicios().add(new Servicio(registro.ingresoDato(nombre,"Nombre de Servicio").toUpperCase(),
                        registro.ingresoDato(duracion,"duracion de Servicio"),
                        registro.ingresoDato(precio,"precio de Servicio"),
                        registro.ingresoDato(estado,"estado de Servicio [true , false]")));}
                if(opcion==2){
                    Scanner eds = new Scanner(System.in);
                    //infoServicios(n);
                    System.out.println("Ingrese nombre de servicio a editar");
                    nombre=eds.nextLine().toUpperCase();
                    while(bandera){
                        Servicio service = new Servicio(nombre);
                        if(!n.getServicios().contains(service)){
                            System.out.println("Ingrese correctamente nombre de servicio a editar");
                            nombre=eds.nextLine().toUpperCase();
                        }else{ //si existe el servicio, entonces lo buscamos en la lista servicios
                            indiceObjServicio=n.getServicios().indexOf(service);//numero entero indice de la lista servicios
                            System.out.println(indicacioncambio);
                            opcioncambio=eds.nextInt();
                            if(opcioncambio!=5){
                                service = n.getServicios().get(indiceObjServicio); //actualizo la referencia de la variable servicio para que apunte al objeto real
                                if(opcioncambio==1){service.setNombre(registro.ingresoDato(nombre,"nuevo nombre"));}
                                if(opcioncambio==2){service.setDuracion(registro.ingresoDato(duracion,"nuevo duracion"));}
                                if(opcioncambio==3){service.setPrecio(registro.ingresoDato(precio,"nuevo precio"));}
                                if(opcioncambio==4){service.setEstado(registro.ingresoDato(estado,"nuevo estado"));}
                                System.out.println(indicacioncambio);
                                opcioncambio=eds.nextInt();
                            }else{
                                if(opcioncambio==5){
                                    bandera=false;
                                    //infoServicios(n);
                                }else{
                                    System.out.println(indicacioncambio);
                                    opcioncambio=eds.nextInt();
                                }
                            }
                        }
                        infoServicios(n);              
                    }
                }if(opcion==3){
                    Scanner eds = new Scanner(System.in);
                    //infoServicios(n);
                    System.out.println("Ingrese nombre de servicio a eliminar");
                    nombre=eds.nextLine().toUpperCase();
                    Servicio service = new Servicio(nombre);
                    while(!n.getServicios().contains(service)){
                        System.out.println("Ingrese correctamente nombre de servicio a eliminar");
                            nombre=eds.nextLine().toUpperCase();
                    }
                    indiceObjServicio=n.getServicios().indexOf(service);
                    service= n.getServicios().get(indiceObjServicio);
                    service.setEstado(false);
                    if(!service.isEstado()){
                        System.out.println("¡¡¡¡¡¡Servicio Eliminado!!!!!!!\n");
                    }
                }
            }
            infoServicios(n);
            System.out.println(indicacion);
            opcion=sc.nextInt();
        }
        
    }
}
