package tknews.project.tkhub.tknews.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import tknews.project.tkhub.tknews.R;
import tknews.project.tkhub.tknews.api.callbacks.OnNewsItemClickListener;
import tknews.project.tkhub.tknews.api.model.Images;
import tknews.project.tkhub.tknews.api.model.News;


/**
 * Created by Himanshu on 4/10/2015.
 */
public class NewsImagesAdapter extends RecyclerView.Adapter<NewsImagesAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<Images> newsimageList;
    private OnNewsItemClickListener onItemClickListener;

    public NewsImagesAdapter(Context mContext, ArrayList<Images> newslist) {
        this.mContext = mContext;
        this.newsimageList = newslist;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_news_image, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Glide.with(mContext)
                .load(newsimageList.get(position).getImgUrl())
                .into(holder.imgNews);

    }

    @Override
    public int getItemCount() {
        return newsimageList.size();
    }




    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.imageView_listnews_coverimage)
        ImageView imgNews;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


        @Override
        public void onClick(View v) {

        }

    }

    public void setOnItemClickListener(OnNewsItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
