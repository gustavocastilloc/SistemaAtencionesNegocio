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
public abstract class Persona {
    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
    public Persona(String ced){
        this.cedula=ced;
    }

    public String getCedula() {
        return cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
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
    
    @Override
    public String toString() {
        return "cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email;
    }
    public abstract void usuario();
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj!=null && obj instanceof Persona){
            Persona user = (Persona)obj;
            return cedula.equals(user.cedula);
        }
        return false;
    }
}
