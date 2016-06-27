package com.example.yasmeensiam.midadproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import Adapters.NewsAdapter;
import Extras.VolleySingleton;
import Extras.cacheThis;
import Model.News;


public class recent_time extends Fragment {

    private final int METHOD = Request.Method.GET;
    private final String URL = "http://dashboard.watanegypt.tv/api/allnews";
    String ImageNews, NewsDate, NewsTitle, NewsDepartment,published;
    int NewsId;
    List<News> newsList;
    RecyclerView recyclerView;
    NewsAdapter newsAdapter;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recent_time, container, false);
        recyclerView= (RecyclerView) view.findViewById(R.id.view2);
        newsList = new Vector<>();
        getNews(METHOD, URL);
        return view;
    }

    public void getNews(int Method, String Url) {
        RequestQueue mRequestQueue = VolleySingleton.getInstance().getmRequestQueue();
        StringRequest stringRequest = new StringRequest(Method, Url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    JSONArray jsonArray = jsonObject.getJSONArray("news");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject News = jsonArray.getJSONObject(i);
                        NewsTitle = News.getString("title");
                        published = News.getString("published");
                        NewsId = Integer.valueOf(News.getString("id"));
                        NewsDate = News.getString("published_at");
                        ImageNews=News.getString("photo") ;
                        JSONObject get_cat = News.getJSONObject("get_cat");
                        NewsDepartment = get_cat.getString("name");


                        newsList.add(new News(ImageNews, NewsDate, NewsDepartment, NewsTitle, NewsId));
                    }
                    newsAdapter = new NewsAdapter( newsList,getActivity());
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(newsAdapter);

                } catch (JSONException e) {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
        };

        mRequestQueue.add(stringRequest);
    }
}
