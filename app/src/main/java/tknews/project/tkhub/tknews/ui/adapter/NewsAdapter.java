package tknews.project.tkhub.tknews.ui.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;
import tknews.project.tkhub.tknews.R;

import tknews.project.tkhub.tknews.api.callbacks.OnNewsItemClickListener;
import tknews.project.tkhub.tknews.api.model.News;



/**
 * Created by Himanshu on 4/10/2015.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<News> newsList;
    private OnNewsItemClickListener onItemClickListener;

    public NewsAdapter(Context mContext, ArrayList<News> newslist) {
        this.mContext = mContext;
        this.newsList = newslist;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_news, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final News newsItem = newsList.get(position);
        holder.txtNewsDate.setText(newsList.get(position).getNewsDate());
        holder.txtNewsLikeCount.setText(newsList.get(position).getNewsLikeCount());

        if(newsList.get(position).getLanguageStatus()==0){
           holder.txtNewsTitel.setText(newsList.get(position).getNewsTitelSinhala());
        }else {
            holder.txtNewsTitel.setText(newsList.get(position).getNewsTitelEnglish());
        }

        Glide.with(mContext)
                .load(newsList.get(position).getNewsCoverImage())
                .into(holder.imgNewsCover);

        holder.btnNewsLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(newsItem);
               // System.out.println("himasdsd :"+newsItem.getNewsTitelSinhala());
            }
        };
        holder.imgNewsCover.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.textView_listnews_title)
        TextView txtNewsTitel;
        @BindView(R.id.textView_listnews_date)
        TextView txtNewsDate;
        @BindView(R.id.textView_listnews_date_count)
        TextView txtNewsLikeCount;
        @BindView(R.id.imageView_listnews_coverimage)
        ImageView imgNewsCover;
        @BindView(R.id.shinebutton_listnews_heart) ShineButton btnNewsLike;


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
