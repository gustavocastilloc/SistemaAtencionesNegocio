/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import entidades.Cliente;
import entidades.Empleado;
import entidades.Negocio;
import entidades.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class EditarPersona {
    Registro registro = new Registro();
     public void infoEmpleados(Negocio n){
        System.out.printf("\n\nLa informacion de empleados es:\n\n");
        for(Persona e : n.getPersonas()){
            if(e instanceof Empleado){
                System.out.println(e);
            }           
        }
        System.out.println();
    }
    public void infoClientes(Negocio n){
        System.out.printf("\n\nLa informacion de clientes es:\n\n");
        for(Persona c : n.getPersonas()){
            if(c instanceof Cliente){
                System.out.println(c);
            }           
        }
        System.out.println();
    }
    public void editarPersona(Negocio n,int tipoPersona){
        Scanner sc = new Scanner(System.in); int opcion=0,indiceObjEmpleado,opcioncambio=0;
        String cedula="",nombre="",telefono="",email="",indicacionEmpleados = "\t***Empleados***\n\t1.Agregar Empleado\n\t2.Editar Empleado"
                + "\n\t3.Eliminar Empleado\n\t4.Regresar\n\nIngrese opcion [1-4]",
                indicacioncambioEmpleados="\nIngrese opcion de cambio\n\t1.Cedula\n\t2.Nombre\n\t3.Telefono"
                + "\n\t4.Email\n\t5.Estado(true=activo,false=inactivo)\n\t6.Regresar\n\n\tIngrese opcion[1-6]:\t",
                indicacionClientes="\t***Clientes***\n\t1.Agregar Cliente\n\t2.Editar Cliente\n\t3.Regresar";
        boolean activo=true,bandera=true;
        if(tipoPersona==3){
            System.out.println(indicacionEmpleados);
            opcion=sc.nextInt();
            while(opcion!=4){
                if(opcion<1 || opcion>4){
                    System.out.printf("Solo ingresar opciones entre [1-4]\nIngrese opcion[1-4]:\t");
                    opcion=sc.nextInt();
                }else{
                    if(opcion==1){n.getPersonas().add(new Empleado(registro.ingresoDato(cedula,"cedula de empleado").toUpperCase(),
                            registro.ingresoDato(activo,"estado de empleado"),
                            registro.ingresoDato(nombre,"nombre de empleado"),
                            registro.ingresoDato(telefono,"telefono de empleado"),
                            registro.ingresoDato(email,"email de empleado")));}
                    if(opcion==2){
                        int c=0; bandera=true;
                        Scanner eds = new Scanner(System.in);
                        System.out.println("Ingrese cedula de empleado a editar");
                        cedula=eds.nextLine();
                        while(bandera){
                            Persona employee = new Empleado(cedula);
                            for(Persona p: n.getPersonas()){
                                c++;
                                if(employee.equals(p) && p instanceof Empleado){
                                    Empleado empleado=(Empleado)p;
                                    System.out.printf(indicacioncambioEmpleados);
                                    opcioncambio=eds.nextInt();
                                    c=0;//si la cedula coincide con el ultimo elemento del arreglo seteo a cero para que no pida otra vez cedula
                                    while(opcioncambio!=6){
                                        if(opcioncambio==1){empleado.setCedula(registro.ingresoDato(cedula,"nueva cedula "));}
                                        if(opcioncambio==2){empleado.setNombre(registro.ingresoDato(nombre,"nuevo nombre"));}
                                        if(opcioncambio==3){empleado.setTelefono(registro.ingresoDato(telefono,"nuevo telefono"));}
                                        if(opcioncambio==4){empleado.setEmail(registro.ingresoDato(email,"nuevo email"));}
                                        if(opcioncambio==5){empleado.setEsActivo(registro.ingresoDato(activo,"nuevo estado"));}
                                        System.out.printf(indicacioncambioEmpleados);
                                        opcioncambio=eds.nextInt();
                                        //eds.nextInt();
                                    }
                                    if(opcioncambio==6){
                                        bandera=false;
                                    }else{
                                        System.out.printf(indicacioncambioEmpleados);
                                        opcioncambio=eds.nextInt();
                                        c=0;
                                        bandera=true;//asegurar que el ciclo sigua.
                                    }                  
                                }    
                                if(c==n.getPersonas().size()){
                                    System.out.println("Ingrese correctamente la cedula del empleado a editar");
                                    cedula=eds.nextLine();
                                    bandera=true;//asegurar que el ciclo sigua.
                                    c=0;
                                }                        
                            }
                            //if(opcioncambio==6){bandera=false;}
                        }
                        System.out.printf("c=%d  size=%d",c,n.getPersonas().size());
                    }if(opcion==3){//eliminar empleado
                        int c=0;
                        Scanner ds = new Scanner(System.in);
                        System.out.println("Ingrese cedula de empleado a eliminar");
                        cedula=ds.nextLine();
                        bandera=true; //seteo por si acaso haya quedado en false
                        while(bandera){
                            Persona employee = new Empleado(cedula);
                            for(Persona p: n.getPersonas()){
                                if(employee.equals(p) && p instanceof Empleado){
                                    Empleado empleado=(Empleado)p;
                                    empleado.setEsActivo(false);
                                    bandera=false;
                                    if(!empleado.isEsActivo()){
                                        System.out.println("\n¡¡¡¡¡¡Empleado ELIMINADO!!!!!\n\n");
                                    }
                                }
                                if(c==n.getPersonas().size()){
                                    System.out.println("Ingrese correctamente la cedula del empleado a editar");
                                    cedula=ds.nextLine();
                                    c=0;
                                }
                                c++;
                            }
                            if(opcioncambio==6){bandera=false;}
                        }
                    }
                }
                infoEmpleados(n);
                System.out.println(indicacionEmpleados);
                opcion=sc.nextInt();
            }
        }
        if(tipoPersona==4){ //edicion de clientes
            System.out.println(indicacionClientes);
            opcion=sc.nextInt();
            boolean flagcliente = true;
            
            while(flagcliente){
                switch(opcion){
                    case 1:
                        //agregar cliente
                        agregarCliente(n,cedula,nombre,telefono,email);
                        break;
                    case 2:
                        //editar cliente
                        Scanner eds = new Scanner(System.in);
                        System.out.println("Ingrese cedula de empleado a editar");
                        cedula=eds.nextLine();
                        editarCliente(n.getPersonas(), cedula);
                        break;
                    case 3:
                        //salir
                        flagcliente = false;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                        
                }
                infoClientes(n);
                System.out.println(indicacionClientes);
                if(opcion != 3){
                    opcion=sc.nextInt();
                }
            }
        }
        
       
    }
    public void agregarCliente(Negocio n, String cedula,String nombre,String telefono, String email){
        
        n.getPersonas().add(new Cliente(registro.ingresoDato(cedula,"cedula del cliente").toUpperCase(),
                            
                            registro.ingresoDato(nombre,"nombre del cliente"),
                            registro.ingresoDato(telefono,"telefono del cliente"),
                            registro.ingresoDato(email,"email del cliente")));
    }
    public void editarCliente(ArrayList<Persona> clientes, String cedula){
        String indicacionedicionCliente="\nIngrese opcion de cambio\n\t1.Nombre\n\t2.Telefono"
                + "\n\t3.Email\n\t4.Regresar\n\n\tIngrese opcion[1-4]:\t";
        byte opcion;
        Scanner sc = new Scanner(System.in);
        Persona cliente = new Cliente(cedula);
        boolean salir = true;
        String nombre="",telefono="",email="";
        for(Persona c : clientes){
            if(cliente.equals(c) && c instanceof Cliente){
                Cliente customer = (Cliente)c; //almaceno en la variable customer el objeto seleccionado
                System.out.println(indicacionedicionCliente);
                opcion = sc.nextByte();
                while(salir){
                    switch(opcion){
                        case 1:
                            customer.setNombre(registro.ingresoDato(nombre,"nuevo nombre"));
                            break;
                        case 2:
                            customer.setTelefono(registro.ingresoDato(telefono,"nuevo telefono"));
                            break;
                        case 3:
                            customer.setEmail(registro.ingresoDato(email,"nuevo email"));
                            break;
                        case 4:
                            salir = false;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 4");
                    }
                    System.out.println(indicacionedicionCliente);
                    if(opcion!=4){
                        opcion = sc.nextByte();
                    }
                }
                System.out.printf(indicacionedicionCliente);
            }
        }
    
    }
    
}
