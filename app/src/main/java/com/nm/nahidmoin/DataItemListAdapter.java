package com.nm.nahidmoin;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class DataItemListAdapter extends ArrayAdapter<DataItem> {


    private List<DataItem> dataItemList;
    private LayoutInflater inflater;


    public DataItemListAdapter(@NonNull Context context, @NonNull List<DataItem> objects) {
        super(context, R.layout.list_item, objects);
        this.dataItemList = objects;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        TextView textView = (TextView) convertView.findViewById(R.id.itemNameText);

        DataItem item = dataItemList.get(position);
        String name = item.getItemName();
        textView.setText(name);
//        imageView.setImageResource(R.drawable.artichokes);
        String imagefile= item.getImage();
        try {
            InputStream inputStream=getContext().getAssets().open(imagefile);
            Drawable drawable=Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
