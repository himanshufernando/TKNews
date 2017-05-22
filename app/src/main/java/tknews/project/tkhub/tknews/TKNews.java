package tknews.project.tkhub.tknews;

import android.app.Application;
import android.support.multidex.MultiDex;


/**
 * Created by Himanshu on 5/9/2017.
 */

public class TKNews extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}
