/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Scanner;
import metodos.Registro;

/**
 *
 * @author Gustavo
 */
public class Negocio {
    ArrayList<Persona> personas;
    ArrayList<Servicio> servicios;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private String horaInicioAtencion;
    private String horaFinAtencion;
    private Empleado Administrador;
    
    public Negocio(){
        
    }
    public Negocio(String nombre,String telefono,String mail,String direccion){
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=mail;
        this.direccion=direccion;
        personas = new ArrayList<Persona>();
        servicios= new ArrayList<Servicio>();
        personas.add(new Empleado("1928374293",true,"Barry","0982742311","barryallen@hotmail.com"));

        //AsignarAdministrador();
        
    }
    public Empleado AsignarAdministrador(){ //para asignar administrador aleatoriamente
        boolean bandera=true;
        
        int aleatorio = (int)(Math.random()*personas.size());
        for(Persona p : personas){
            if(p instanceof Empleado){
               Empleado e = (Empleado)p;
               Administrador = e;
            }
        }
        return Administrador;
    }
    
    public ArrayList<Persona> getPersonas() {
        AsignarAdministrador();
        return personas;
    }

    public void setAdministrador(Empleado empleado) { //para asignar administrador manualmente
        this.Administrador = empleado;
    }

    /*public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }*/

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHoraInicioAtencion(String horaInicioAtencion) {
        this.horaInicioAtencion = horaInicioAtencion;
    }

    public void setHoraFinAtencion(String horaFinAtencion) {
        this.horaFinAtencion = horaFinAtencion;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    

    @Override
    public String toString() {
        return "Negocio{" + "nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", horaInicioAtencion=" + horaInicioAtencion + ", horaFinAtencion=" + horaFinAtencion + ", Administrador=" + Administrador + '}';
    }
    
}
