package com.example.mayuhei.helloworld.com.example.mayuhei.helloworld.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayuhei.helloworld.R;
import com.example.mayuhei.helloworld.com.example.mayuhei.helloworld.entity.Item;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by mayuhei on 2016/12/12.
 */

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Item> listStorage;
    private Context context;

    public CustomAdapter(Context context, List<Item> listStorage) {
        this.context = context;
        this.listStorage = listStorage;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;
        if (convertView == null) {
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.card_view, parent, false);
            listViewHolder.name = (TextView) convertView.findViewById(R.id.music_author);
            listViewHolder.screenShot = (ImageView) convertView.findViewById(R.id.screen_shot);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.name.setText(listStorage.get(position).getName());
        listViewHolder.screenShot.setImageBitmap(extractBitMap(listStorage.get(position).getImageUrl()));
        return convertView;
    }

    private Bitmap extractBitMap(String imageName){
        InputStream istream = null;
        try {
            istream = context.getResources().getAssets().open(imageName);
        } catch (IOException e) {
           return null;
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istream);
        return bitmap;
    }

    static class ViewHolder {
        ImageView screenShot;
        TextView name;
    }
}
