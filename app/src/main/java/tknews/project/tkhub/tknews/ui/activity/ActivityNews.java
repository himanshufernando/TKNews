package tknews.project.tkhub.tknews.ui.activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tknews.project.tkhub.tknews.R;
import tknews.project.tkhub.tknews.api.model.News;
import tknews.project.tkhub.tknews.ui.adapter.NewsAdapter;


/**
 * Created by Himanshu on 3/7/2017.
 */

public class ActivityNews extends Activity {


    @BindView(R.id.recyclerView_news) RecyclerView recyclerNews;


    NewsAdapter newsAdapter;
    ArrayList<News> newsArrayList = new ArrayList<News>();
    int languageStatus = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ButterKnife.bind(this);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerNews.setLayoutManager(mLayoutManager);
        recyclerNews.setItemAnimator(new DefaultItemAnimator());

        final DatabaseReference myRef = database.getReference("News");

        newsAdapter = new NewsAdapter(this,newsArrayList);





            myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    News newsInfo =ds.getValue(News.class);
                    newsArrayList.add(new News(ds.getKey(),newsInfo.newsTitelEnglish,newsInfo.newsTitelSinhala,newsInfo.newsContentEnglish, newsInfo.newsContentSinhala,newsInfo.newsResourceID,newsInfo.newsDate,newsInfo.newsLikeCount,newsInfo.newsCoverImage,languageStatus));

                }
                recyclerNews.setAdapter(newsAdapter);

            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Failed to read value. :"+error.toException());
            }
        });

    }
    @OnClick(R.id.relativeLayout_tab_sinhala)
    public void tabSinhalaOnClick() {
        languageStatus =0;
    }
    @OnClick(R.id.relativeLayout_tab_english)
    public void tabEnglishOnClick() {
        languageStatus =1;
    }
}
