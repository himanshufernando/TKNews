package tknews.project.tkhub.tknews.ui.activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import tknews.project.tkhub.tknews.R;


/**
 * Created by Himanshu on 3/7/2017.
 */

public class ActivityNews extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);





    }
}
