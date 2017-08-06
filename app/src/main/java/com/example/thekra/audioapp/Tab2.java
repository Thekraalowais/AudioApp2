package com.example.thekra.audioapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Tab2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_view, container, false);

        ArrayList<Audio> audios = new ArrayList<>();
        audios.add(new Audio(R.string.audio2));

        AudioAdapter adapter = new AudioAdapter(getActivity(), audios);

        ListView listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent firstIntent = new Intent(getActivity(), Audio2.class);
                        startActivity(firstIntent);
                        break;
                }
            }
        });
        return view;
    }
}
