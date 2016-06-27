package Extras;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Yasmeen Siam on 26/04/2016.
 */

public class SaveToPreference {
    Context context;
    SharedPreferences sharedPreferences;
    public static final String MY_PREFERENCES = "MyPref";

    public SaveToPreference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(MY_PREFERENCES, context.MODE_PRIVATE);

    }

    public void saveData(String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("value", value);
        editor.apply();
    }

    public String getData() {
        String value = sharedPreferences.getString("value", "nullValue");
        return value;
    }

}
