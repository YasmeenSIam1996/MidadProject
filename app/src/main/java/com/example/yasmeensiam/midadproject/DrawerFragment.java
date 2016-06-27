package com.example.yasmeensiam.midadproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import Extras.SaveToPreference;
import Extras.cacheThis;
import Model.ItemDrawer;


public class DrawerFragment extends Fragment {

    ListView recyclerView;
    List<ItemDrawer> itemDrawers;
    ImageView icon1, icon2, icon3;
    TextView name1, name2, name3;
    private ArrayAdapter<String> listAdapter;
    private List<String> departmentCardList;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout mDrawer;
    private boolean userLearnedDrawer;
    private boolean formSaveInstanceState;
    SaveToPreference saveToPreference;
    private View ContanerView;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);

        instance_view(view);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        saveToPreference = new SaveToPreference(getActivity());
        userLearnedDrawer = Boolean.valueOf(saveToPreference.getData());
        if (savedInstanceState != null) {
            formSaveInstanceState = true;
        }
    }

    public void instance_view(View view) {
        recyclerView = (ListView) view.findViewById(R.id.view);
        itemDrawers = new Vector<>();

        name1 = (TextView) view.findViewById(R.id.itemName1);
        name2 = (TextView) view.findViewById(R.id.itemName2);
        name3 = (TextView) view.findViewById(R.id.itemName3);
        icon1 = (ImageView) view.findViewById(R.id.itemIcon1);
        icon2 = (ImageView) view.findViewById(R.id.itemIcon2);
        icon3 = (ImageView) view.findViewById(R.id.itemIcon3);
        name1.setText(R.string.live_broadcast);
        name2.setText(R.string.recent_time);
        name3.setText(R.string.favorite);
        icon1.setImageResource(R.drawable.live_broadcast);
        icon2.setImageResource(R.drawable.recent_time);
        icon3.setImageResource(R.drawable.favorite);
        departmentCardList = new Vector<>();
        try {
            departmentCardList = (List<String>) cacheThis.readObject(getActivity(), "department_name");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, departmentCardList);
        recyclerView.setAdapter(listAdapter);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
        ContanerView=getActivity().findViewById(fragmentId);
        mDrawer = drawerLayout;
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!userLearnedDrawer) {
                    userLearnedDrawer = true;
                    saveToPreference.saveData(userLearnedDrawer + "");
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();

            }
        };
        if (!userLearnedDrawer && !formSaveInstanceState) {
            mDrawer.openDrawer(ContanerView);
        }
        mDrawer.addDrawerListener(drawerToggle);
        mDrawer.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });
    }


}
