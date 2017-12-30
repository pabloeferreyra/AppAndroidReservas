package io.github.pabloeferreyra.reservamos.Adapters;

/**
 * Created by pablo on 27/12/2017.
 */


import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import io.github.pabloeferreyra.reservamos.Entity.Locales;
import io.github.pabloeferreyra.reservamos.R;


public class LocalesAdapter extends ArrayAdapter<Locales> {
    private ArrayList<Locales> objects;
    private Context mContext;

    public LocalesAdapter(Context context, ArrayList<Locales> objects) {
        super(context, 0, objects);
        this.mContext = context;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */
        Locales i = objects.get(position);

        if (i != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView tt = (TextView) v.findViewById(R.id.toptext);
            TextView ttd = (TextView) v.findViewById(R.id.toptextdata);
            TextView mt = (TextView) v.findViewById(R.id.middletext);
            TextView mtd = (TextView) v.findViewById(R.id.middletextdata);
            TextView bt = (TextView) v.findViewById(R.id.bottomtext);
            TextView btd = (TextView) v.findViewById(R.id.desctext);

            // check to see if each individual textview is null.
            // if not, assign some text!
            if (tt != null){
                tt.setText("Nombre: ");
            }
            if (ttd != null){
                ttd.setText(i.getNombre());
            }
            if (mt != null){
                mt.setText("Direccion: ");
            }
            if (mtd != null){
                mtd.setText("$" + i.getDireccion());
            }
            if (bt != null){
                bt.setText("Valuacion: ");
            }
            if (btd != null){
                btd.setText(i.getValuacion());
            }
        }

        // the view must be returned to our activity
        return v;

    }
}
