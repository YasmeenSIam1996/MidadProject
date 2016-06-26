package com.example.yasmeensiam.midadproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

import Model.ItemDrawer;


public class DrawerFragment extends Fragment {

    RecyclerView recyclerView;
    List<ItemDrawer> itemDrawers;
    ImageView icon1, icon2, icon3;
    TextView name1, name2, name3;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);


        return view;
    }

    public void instance_view(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.view);
        itemDrawers = new Vector<>();
        name1= (TextView) view.findViewById(R.id.itemName1);
        name2= (TextView) view.findViewById(R.id.itemName2);
        name3= (TextView) view.findViewById(R.id.itemName3);
        icon1=(ImageView)view.findViewById(R.id.itemIcon1);
        icon2=(ImageView)view.findViewById(R.id.itemIcon2);
        icon3=(ImageView)view.findViewById(R.id.itemIcon3);
        name1.setText(R.string.live_broadcast);
    }

}
