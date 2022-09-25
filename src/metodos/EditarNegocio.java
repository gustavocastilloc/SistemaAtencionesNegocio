/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import entidades.Empleado;
import entidades.Negocio;
import entidades.Persona;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class EditarNegocio {
    Registro registro = new Registro();
    public  void editarInformacionNegocio(Negocio n){
        Scanner ed = new Scanner(System.in);
        int atributo=0;
        String indicacion="\nModificar\n1.Nombre\n2.telefono\n3.email\n4.direccion\n5.horaInicio\n6.horaFin\n7.Administrador\n8.regresar\nIngrese Opcion[1-8]:\t";
        String sn,nombre="",telefono="",email="",direccion="",horainicio="",horafin="",cedula="";
        System.out.println("¿Editar informacion? [S/N]");
        sn=ed.nextLine().toUpperCase();
        if(sn.equals("S")){
            System.out.printf(indicacion);
            atributo=ed.nextInt();
            while(atributo!=8){
                if(atributo>9 || atributo<0){
                    System.out.printf("Ingrese numero opcion [1-8] %s",indicacion);
                    atributo=ed.nextInt();
                }else{
                    if(atributo==1){n.setNombre(registro.ingresoDato(nombre,"nuevo nombre:"));}
                    if(atributo==2){n.setTelefono(registro.ingresoDato(telefono,"nuevo telefono:"));}
                    if(atributo==3){n.setEmail(registro.ingresoDato(email,"nuevo email:"));}
                    if(atributo==4){n.setDireccion(registro.ingresoDato(direccion,"nuevo direccion:"));}
                    if(atributo==5){n.setHoraInicioAtencion(registro.ingresoDato(horainicio,"nueva hora de inicio"));}
                    if(atributo==6){n.setHoraFinAtencion(registro.ingresoDato(horafin,"nueva hora fin"));}
                    if(atributo==7){
                        Scanner nn = new Scanner(System.in);
                        System.out.println("Ingrese cedula nuevo Administrador:");
                        cedula=nn.nextLine();
                        Persona empl= new Empleado(cedula);  //me sirve para poder encotrar el objeto real de la lista empleados                      
                        for(Persona e: n.getPersonas()){
                            if(empl.equals(e)){//forma de encontrar un objeto de una lista, previamente en la clase se define el metodo equals
                                n.setAdministrador((Empleado)e);
                                System.out.printf("\nEmployee with ID:%s has been assigned as administrator\n",cedula);
                            }
                        }
                    }
                    System.out.printf("%s",indicacion);
                    atributo=ed.nextInt();//para volver ingresar una opcion para cambio
                    System.out.println(n);
                }
            }
            
        }else{
            if(!sn.equals("N")){
                System.out.println("Solo puede ingresar las letras s o n");
            }
        }
    }
}
