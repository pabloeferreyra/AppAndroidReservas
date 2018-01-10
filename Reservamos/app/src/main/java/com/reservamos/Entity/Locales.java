package com.reservamos.Entity;


/**
 * Created by pablo on 24/12/2017.
 */
public class Locales {
    public int ID;

    public String Nombre;
    public String Direccion;
    public int Valuacion;
    public String Imagen;

    public Locales(){}

    public Locales(int i, String n, String d, int v, String p)
    {
        this.ID = i;
        this.Nombre = n;
        this.Direccion = d;
        this.Valuacion = v;
        this.Imagen = p;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public String getDireccion(){ return Direccion; }
    public void setDireccion(String Direccion){
        this.Direccion = Direccion;
    }

    public int getValuacion(){
        return Valuacion;
    }
    public void setValuacion(int Valuacion){
        this.Valuacion = Valuacion;
    }

    public String getImagen(){
        return Imagen;
    }
    public void setImagen(String Imagen){
        this.Imagen = Imagen;
    }
}
