/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Registro {  
     public String ingresoDato(String dato,String especificaciondato){ //metodo para registrar datos, puede ser usado para un nuevo servicio
        Scanner dc = new Scanner(System.in);
        System.out.printf("\nIngrese %s\n",especificaciondato);
        dato=dc.nextLine();
        return dato;
    }
    public int ingresoDato(int dato,String especificaciondato){//metodo sobrecargado
        Scanner dc = new Scanner(System.in);
        System.out.printf("\nIngrese %s\n",especificaciondato);
        dato=dc.nextInt();
        return dato;
    }
    public boolean ingresoDato(boolean dato,String especificaciondato){//metodo sobrecargado
        Scanner dc = new Scanner(System.in);
        System.out.printf("\nIngrese %s\n",especificaciondato);
        dato=dc.nextBoolean();
        return dato;
    }
    public float ingresoDato(float dato,String especificaciondato){//metodo sobrecargado
        Scanner dc = new Scanner(System.in);
        System.out.printf("\nIngrese %s\n",especificaciondato);
        dato=dc.nextFloat();
        return dato;
    }
    
}
