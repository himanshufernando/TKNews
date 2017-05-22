package tknews.project.tkhub.tknews.ui.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created by Himanshu on 11/26/2015.
 */
public class FontSinhala extends TextView {
    public FontSinhala(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FontSinhala(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontSinhala(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/0kdaraliya.TTF");
        setTypeface(tf);
    }

}
