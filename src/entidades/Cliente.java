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
public class Cliente extends Persona{
    
    Registro registro = new Registro();
    public Cliente(String cedula){
        super(cedula);
    }
    public Cliente(String cedula,String nombre,String telefono,String email){
        super(cedula);
        this.setNombre(nombre);
        this.setTelefono(telefono);
        this.setEmail(email);
    }
    
    
    public void usuario(){
         System.out.println("Ejemplo de implementacion metodo abstracto de padre");
     }
}
