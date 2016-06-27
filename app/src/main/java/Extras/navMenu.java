package Extras;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;

import com.example.yasmeensiam.midadproject.R;

/**
 * Created by Yasmeen Siam on 26/06/2016.
 */
public class navMenu extends NavigationView {
    public navMenu(Context context) {
        super(context);

    }

    public navMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public navMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, R.style.AppTheme);
    }
}
