package Extras;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Yasmeen Siam on 23/04/2016.
 */
public class VolleySingleton {
    private static VolleySingleton sInstance = null;
    private RequestQueue mRequestQueue;

    private VolleySingleton() {
        mRequestQueue=Volley.newRequestQueue(MyApplication.getContext());
    }

    public static VolleySingleton getInstance() {
        if (sInstance == null) {
            sInstance = new VolleySingleton();
        }
        return sInstance;
    }

    public RequestQueue getmRequestQueue() {
        return mRequestQueue;
    }
}
