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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.view);
        itemDrawers = new Vector<>();

        return view;
    }


}
