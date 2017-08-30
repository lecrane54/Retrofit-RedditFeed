package com.kyle.lefebvre.retrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kyle.lefebvre.retrofit.Activities.MainActivity;
import com.kyle.lefebvre.retrofit.Activities.image;
import com.kyle.lefebvre.retrofit.Activities.webviewActivity;
import com.kyle.lefebvre.retrofit.R;
import com.kyle.lefebvre.retrofit.model.children.Children;

import java.util.List;



public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private List<Children> childrenList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView author, subreddit, title;
        public ImageView mImageView;
        public View mView;
        public MyViewHolder(View view) {
            super(view);
            mView = view;
            author = (TextView) view.findViewById(R.id.author);
            subreddit = (TextView) view.findViewById(R.id.subreddit);
            title = (TextView) view.findViewById(R.id.title);
            mImageView = (ImageView)view.findViewById(R.id.imageview);
            mImageView.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v == mView){
                int i = getAdapterPosition();
                Children child = childrenList.get(i);
                Intent intent = new Intent(mContext,webviewActivity.class);
                intent.putExtra("url",child.getData().getUrl());
                mContext.startActivity(intent);

            }else{
                int i = getAdapterPosition();
                Children child = childrenList.get(i);

                Intent intent = new Intent(mContext,image.class);



                intent.putExtra("theTitle", child.getData().getTitle());
                intent.putExtra("thumbnail",child.getData().getThumbnail());
                Pair<View,String> pair1 = new Pair<>((View)mImageView,"image");
                Pair<View,String> pair2 = new Pair<>((View)title,"title");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((MainActivity)mContext, pair1,pair2);
                mContext.startActivity(intent, options.toBundle());


            }

        }
    }


    public ListAdapter(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        mContext = parent.getContext();
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Children child = childrenList.get(position);
        holder.author.setText("Author: " + child.getData().getAuthor());
        holder.subreddit.setText("Subreddit: " +child.getData().getSubreddit());
        holder.title.setText(child.getData().getTitle());
        Glide.with(mContext)
                .load(child.getData().getThumbnail())
                .centerCrop()
                .override(125,125)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .crossFade()
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return childrenList.size();
    }
}
