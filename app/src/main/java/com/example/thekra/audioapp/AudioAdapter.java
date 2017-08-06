package com.example.thekra.audioapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AudioAdapter extends ArrayAdapter<Audio> {

    public AudioAdapter(Context context, ArrayList<Audio> audios) {
        super(context, 0, audios);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Audio currentAudio = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items, parent, false);

            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(currentAudio.getTitle());

        if(currentAudio.hasImage()){
            viewHolder.image.setImageResource(currentAudio.getImage());
            viewHolder.image.setVisibility(View.VISIBLE);
        }else{
            viewHolder.image.setVisibility(View.GONE);
        }
        return convertView;
    }

    public static class ViewHolder {
        TextView title;
        ImageView image;
    }

}
