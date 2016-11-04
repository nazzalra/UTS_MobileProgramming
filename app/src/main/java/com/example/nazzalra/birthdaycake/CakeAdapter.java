package com.example.nazzalra.birthdaycake;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nazzalra on 11/4/2016.
 */

public class CakeAdapter extends ArrayAdapter {

    private final AppCompatActivity context;
    private final String[] CakeName;
    private final int[] CakePic;


    public CakeAdapter(AppCompatActivity context,String[] CakeName, int[] CakePic) {
        super(context, R.layout.list_cake, CakeName);

        this.context = context;
        this.CakeName = CakeName;
        this.CakePic = CakePic;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_cake, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.cake_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.cake_pic);

        txtTitle.setText(CakeName[position]);
        imageView.setImageResource(CakePic[position]);

        return rowView;
    }
}
