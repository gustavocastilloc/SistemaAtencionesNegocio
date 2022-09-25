/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Objects;
import java.util.Scanner;
import metodos.Registro;

/**
 *
 * @author Gustavo
 */
public class Servicio {
    private String nombre;
    private int duracion;
    private float precio;
    private boolean estado; //activo o inactivo

    public Servicio(String nombre) {
        this.nombre = nombre;
    }

    public Servicio(String nombre, int duracion, float precio, boolean estado) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
        this.estado = estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public boolean isEstado() {
        return estado;
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servicio other = (Servicio) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Servicio{" + "nombre=" + nombre + ", duracion=" + duracion + ", precio=" + precio + ", estado=" + estado + '}';
    }
    
}
