package tknews.project.tkhub.tknews.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import tknews.project.tkhub.tknews.R;
import tknews.project.tkhub.tknews.api.model.Images;
import tknews.project.tkhub.tknews.api.model.News;
import tknews.project.tkhub.tknews.api.model.Videos;
import tknews.project.tkhub.tknews.ui.adapter.NewsImagesAdapter;



/**
 * Created by Himanshu on 3/7/2017.
 */

public class ActivityNewsContent extends YouTubeBaseActivity implements YouTubeThumbnailView.OnInitializedListener {


    @BindView(R.id.imageView_listnews_coverimage) ImageView imageViewCover;
    @BindView(R.id.textView_listnews_title) TextView textViewTitle;
    @BindView(R.id.textView_listnews_date) TextView textViewDate;
    @BindView(R.id.textView_listnews_content) TextView textViewContent;

    @BindView(R.id.recyclerView_newscontentImages) RecyclerView recyclerNewsImages;

    @BindView(R.id.youtube_player_one) YouTubePlayerView youTubePlayerViewone;
    @BindView(R.id.youtube_player_two) YouTubePlayerView youTubePlayerViewtwo;
    @BindView(R.id.youtube_player_three) YouTubePlayerView youTubePlayerViewthree;



    NewsImagesAdapter newsImagesAdapter;
    ArrayList<Images> imagesList = new ArrayList<Images>();
    ArrayList<Videos> videosArrayList = new ArrayList<Videos>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        ButterKnife.bind(this);

        Intent intent = getIntent();


        News news  = (News) intent.getSerializableExtra("NewsItem");

        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerNewsImages.setLayoutManager(layoutManager);
        recyclerNewsImages.setItemAnimator(new DefaultItemAnimator());

        newsImagesAdapter = new NewsImagesAdapter(this,imagesList);

        setNewsDetails(news);


        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
        Query queryImages = myRef.child("Images").orderByChild("imageNewsID").equalTo(news.getNewsID());
        queryImages.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    imagesList.clear();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        Images iminfio=ds.getValue(Images.class);
                        imagesList.add(new Images(iminfio.getImageNewsID(),iminfio.getImgUrl()));
                    }
                    recyclerNewsImages.setAdapter(newsImagesAdapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Query queryVideos = myRef.child("Videos").orderByChild("videosNewsID").equalTo(news.getNewsID());
        queryVideos.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        Videos vinfo =ds.getValue(Videos.class);
                        videosArrayList.add(new Videos(vinfo.getVideosUrl()));
                    }
                    setVideos(videosArrayList);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }

    private void setNewsDetails(News newsDetails){
        Glide.with(getApplicationContext())
                .load(newsDetails.getNewsCoverImage())
                .into(imageViewCover);

        if(newsDetails.getLanguageStatus()==0){
            textViewTitle.setText(newsDetails.getNewsTitelSinhala());
            textViewContent.setText(newsDetails.getNewsContentSinhala());
        }else {
            textViewTitle.setText(newsDetails.getNewsTitelEnglish());
            textViewContent.setText(newsDetails.getNewsContentEnglish());
        }

        textViewDate.setText(newsDetails.getNewsDate());

    }

    private void setVideos(final ArrayList<Videos> videosArrayList){
        /*int itemcount =videosArrayList.size();
        if(itemcount==0){
            youTubePlayerViewone.setVisibility(View.GONE);
            youTubePlayerViewtwo.setVisibility(View.GONE);
            youTubePlayerViewthree.setVisibility(View.GONE);
        } else if(itemcount==1) {

        }else if(itemcount==2) {
            youTubePlayerViewone.initialize("AIzaSyCV_I7aOpJA27QSnHdz_-K63ah_KTNZr7o",onInitializedListenerone);
            youTubePlayerViewthree.setVisibility(View.GONE);
        }*/

    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
