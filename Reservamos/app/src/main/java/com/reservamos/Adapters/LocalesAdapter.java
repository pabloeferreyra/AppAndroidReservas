package com.reservamos.Adapters;

/**
 * Created by pablo on 27/12/2017.
 */


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.reservamos.Entity.Locales;
import com.reservamos.R;

import org.java_websocket.util.Base64;

import java.io.IOException;
import java.util.ArrayList;

public class LocalesAdapter extends ArrayAdapter<Locales> {
    private ArrayList<Locales> objects;
    private Context mContext;

    public LocalesAdapter(Context context, ArrayList<Locales> objects) {
        super(context, R.layout.list_item, objects);
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

            TextView ttd = (TextView) v.findViewById(R.id.toptextdata);
            TextView mtd = (TextView) v.findViewById(R.id.middletextdata);
            ImageView imagen = (ImageView) v.findViewById(R.id.imageView);

            //

            // check to see if each individual textview is null.
            // if not, assign some text!
            if (ttd != null){
                ttd.setText(i.getNombre());
            }
            if (mtd != null){
                mtd.setText(i.getDireccion());
            }
            if (imagen != null){
                byte[] decodeString  = new byte[0];
                try {
                    decodeString = Base64.decode(i.getImagen(), Base64.NO_OPTIONS);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Bitmap decodebitmap = BitmapFactory.decodeByteArray(decodeString,
                       0, decodeString.length);
                imagen.setImageBitmap(decodebitmap);
            }
        }

        // the view must be returned to our activity
        return v;

    }
}
