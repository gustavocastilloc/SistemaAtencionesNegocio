/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author Gustavo
 */
public class Cita {
   
    protected Empleado masajista;
    private int year,month,day;
    //public static Calendar calendar= new GregorianCalendar();
    private int hora,minuto;
    
    public Cita(Empleado msj,int year,int month,int day,int hora,int minuto){
        this.masajista=msj;
        this.day=day;
        this.month=month;
        this.year=year;
        this.hora=hora;
        this.minuto=minuto;
    }
    
    /*public  static void cargarFechaCita(int year, int month, int day){
        calendar.set(year, month, day);
    }
    public static Date getDateCalendar(){
        return calendar.getTime();
    }
   
    public boolean verificarUnicidad(Calendar c, int hora, int min){
        boolean unica=false;
        if(hora>8 && hora <18 && min>0 && min<59){
            if(calendar !=c){
                unica=true;
            }
        }
        return unica;
    }
    */

    public Empleado getMasajista() {
        return masajista;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }
    
}
