package tknews.project.tkhub.tknews.ui.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Himanshu on 11/26/2015.
 */
public class Cobert extends TextView {
    public Cobert(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Cobert(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Cobert(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Corbert-Regular.otf");

        setTypeface(tf,Typeface.BOLD);
    }

}
