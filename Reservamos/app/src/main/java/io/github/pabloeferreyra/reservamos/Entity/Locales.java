package io.github.pabloeferreyra.reservamos.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by pablo on 24/12/2017.
 */
@Entity
public class Locales {
    @PrimaryKey
    public int ID;

    public String Nombre;
    public String Direccion;
    public int Valuacion;

    public Locales(){}

    public Locales(int i, String n, String d, int v)
    {
        this.ID = i;
        this.Nombre = n;
        this.Direccion = d;
        this.Valuacion = v;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public String getDireccion(){
        return Nombre;
    }
    public void setDireccion(String Direccion){
        this.Direccion = Direccion;
    }

    public int getValuacion(){
        return Valuacion;
    }
    public void setValuacion(int Valuacion){
        this.Valuacion = Valuacion;
    }
}
