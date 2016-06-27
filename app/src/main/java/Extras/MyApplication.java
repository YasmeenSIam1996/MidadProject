package Extras;

import android.app.Application;
import android.content.Context;
import android.util.Log;
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


/**
 * Created by Yasmeen Siam on 23/04/2016.
 */
public class MyApplication extends Application {
    private static MyApplication sInstance;
    String department_name;
    private List<String> departmentCardList;
    private final int METHOD = Request.Method.GET;
    private final String URL = "http://dashboard.watanegypt.tv/api/allMainCategory";

    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "arabicfont.otf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "arabicfont.otf");
        FontsOverride.setDefaultFont(this, "SERIF", "arabicfont.otf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "arabicfont.otf");
        sInstance = this;
        departmentCardList = new Vector<>();
        getsInstance();
        getDepartment(METHOD, URL);
    }

    private static MyApplication getsInstance() {
        return sInstance;
    }

    public static Context getContext() {
        return sInstance.getApplicationContext();
    }

    public void getDepartment(int Method, String Url) {
        RequestQueue mRequestQueue = VolleySingleton.getInstance().getmRequestQueue();
        StringRequest stringRequest = new StringRequest(Method, Url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    JSONArray jsonArray = jsonObject.getJSONArray("categories");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject dapartmant = jsonArray.getJSONObject(i);
                        department_name = dapartmant.getString("name");
                        departmentCardList.add(new String(department_name));
                        Log.e("department_name", department_name);
                    }
                    try {
                        cacheThis.writeObject(getApplicationContext(), "department_name", departmentCardList);
                        departmentCardList.clear();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();

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
