package tknews.project.tkhub.tknews.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import butterknife.ButterKnife;
import tknews.project.tkhub.tknews.R;

import tknews.project.tkhub.tknews.api.model.Videos;


/**
 * Created by Himanshu on 4/10/2015.
 */
public class NewsVideosAdapter extends RecyclerView.Adapter<NewsVideosAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<Videos> newsvideosList;
    private final Map<YouTubeThumbnailView, YouTubeThumbnailLoader> thumbnailViewToLoaderMap;
  //  private final ThumbnailListener thumbnailListener;

    public NewsVideosAdapter(Context mContext, ArrayList<Videos> videoslist) {
        this.mContext = mContext;
        this.newsvideosList = videoslist;
        thumbnailViewToLoaderMap = new HashMap<YouTubeThumbnailView, YouTubeThumbnailLoader>();

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_news_videos, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return newsvideosList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder  {


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }


    }
    private final class ThumbnailListener implements YouTubeThumbnailView.OnInitializedListener, YouTubeThumbnailLoader.OnThumbnailLoadedListener {

        @Override
        public void onInitializationSuccess(YouTubeThumbnailView view, YouTubeThumbnailLoader loader) {

            loader.setOnThumbnailLoadedListener(this);
            thumbnailViewToLoaderMap.put(view, loader);
            //view.setImageResource(R.drawable.loading_thumbnail);
            String videoId = (String) view.getTag();
            loader.setVideo(videoId);
        }

        @Override
        public void onInitializationFailure(
                YouTubeThumbnailView view, YouTubeInitializationResult loader) {
           // view.setImageResource(R.drawable.no_thumbnail);
        }

        @Override
        public void onThumbnailLoaded(YouTubeThumbnailView view, String videoId) {
        }

        @Override
        public void onThumbnailError(YouTubeThumbnailView view, YouTubeThumbnailLoader.ErrorReason errorReason) {
           // view.setImageResource(R.drawable.no_thumbnail);
        }
    }


}
