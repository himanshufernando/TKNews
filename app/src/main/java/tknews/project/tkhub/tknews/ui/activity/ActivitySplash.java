package tknews.project.tkhub.tknews.ui.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.mikhaellopez.circularimageview.CircularImageView;

import tknews.project.tkhub.tknews.R;


/**
 * Created by Himanshu on 3/7/2017.
 */

public class ActivitySplash extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(ActivitySplash.this, ActivityNews.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out).toBundle();
                finish();
                startActivity(i, bndlanimation);

            }
        }, 2000);
    }

}
