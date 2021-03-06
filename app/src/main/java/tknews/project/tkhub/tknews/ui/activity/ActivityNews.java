package tknews.project.tkhub.tknews.ui.activity;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.comix.overwatch.HiveProgressView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tknews.project.tkhub.tknews.R;
import tknews.project.tkhub.tknews.api.callbacks.OnNewsItemClickListener;
import tknews.project.tkhub.tknews.api.model.News;
import tknews.project.tkhub.tknews.ui.adapter.NewsAdapter;


/**
 * Created by Himanshu on 3/7/2017.
 */

public class ActivityNews extends Activity {


    @BindView(R.id.recyclerView_news)
    RecyclerView recyclerNews;
    @BindView(R.id.hiveProgressView)
    HiveProgressView hiveProgressView;


    NewsAdapter newsAdapter;
    ArrayList<News> newsArrayList = new ArrayList<News>();
    int languageStatus = 0;
    DataSnapshot dataSnapshotGlobal;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ButterKnife.bind(this);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);

        // LinearLayoutManager layoutManager
        //   = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerNews.setLayoutManager(mLayoutManager);
        recyclerNews.setItemAnimator(new DefaultItemAnimator());

        final DatabaseReference myRef = database.getReference("News");

        newsAdapter = new NewsAdapter(this, newsArrayList);


        hiveProgressView.setVisibility(View.VISIBLE);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataSnapshotGlobal = dataSnapshot;
                loadNews();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Failed to read value. :" + error.toException());
            }
        });

        newsAdapter.setOnItemClickListener(new OnNewsItemClickListener() {
            @Override
            public void onItemClick(News newsItem) {

                Intent i = new Intent(ActivityNews.this, ActivityNewsContent.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out).toBundle();
                i.putExtra("NewsItem", newsItem);
                finish();
                startActivity(i, bndlanimation);

            }


        });


    }

    @OnClick(R.id.relativeLayout_tab_sinhala)
    public void tabSinhalaOnClick() {
        hiveProgressView.setVisibility(View.VISIBLE);
        languageStatus = 0;
        loadNews();
    }

    @OnClick(R.id.relativeLayout_tab_english)
    public void tabEnglishOnClick() {
        hiveProgressView.setVisibility(View.VISIBLE);
        languageStatus = 1;
        loadNews();
    }

    private void loadNews() {
        newsArrayList.clear();
        for (DataSnapshot ds : dataSnapshotGlobal.getChildren()) {
            News newsInfo = ds.getValue(News.class);
            if (newsInfo.newsStatus == 0) {
            } else {
                newsArrayList.add(new News(ds.getKey(), newsInfo.newsTitelEnglish, newsInfo.newsTitelSinhala, newsInfo.newsContentEnglish, newsInfo.newsContentSinhala, newsInfo.newsResourceID, newsInfo.newsDate, newsInfo.newsLikeCount, newsInfo.newsCoverImage, languageStatus, newsInfo.newsStatus));
            }
            hiveProgressView.setVisibility(View.INVISIBLE);

        }
       recyclerNews.setAdapter(newsAdapter);
    }
}
