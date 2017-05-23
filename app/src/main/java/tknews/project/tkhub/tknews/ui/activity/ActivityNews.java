package tknews.project.tkhub.tknews.ui.activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.firebase.database.FirebaseDatabase;

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
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ButterKnife.bind(this);



      //  final DatabaseReference myRef = database.getReference("News");

       /* myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    News newsInfo =ds.getValue(News.class);
                   // Users users_info =ds.getValue(Users.class);


                    System.out.println("sssssssss :"+newsInfo.getNewsDate());
                  //  System.out.println("idddddddddd :"+ds.getKey());

                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

                System.out.println("Failed to read value. :"+error.toException());
            }
        });
*/


    }
}
