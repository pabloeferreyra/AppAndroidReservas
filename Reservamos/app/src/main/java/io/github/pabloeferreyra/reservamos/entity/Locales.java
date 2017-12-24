package io.github.pabloeferreyra.reservamos.entity;

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
}
