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

public class ActivitySplash extends Activity implements Animation.AnimationListener{


    CircularImageView imagLogo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imagLogo = (CircularImageView)findViewById(R.id.imageView_logo);

        final Animation animMovelaypot = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
        animMovelaypot.setAnimationListener(this);
        imagLogo.startAnimation(animMovelaypot);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(ActivitySplash.this, ActivityNews.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.activity_open_translate, R.anim.activity_close_translate).toBundle();
                finish();
                startActivity(i, bndlanimation);

            }
        }, 3000);


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
