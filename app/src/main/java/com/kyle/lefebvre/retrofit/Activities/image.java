package com.kyle.lefebvre.retrofit.Activities;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kyle.lefebvre.retrofit.R;

public class image extends Activity {

    private ImageView imageView;
    private TextView textView;
    private String title, thumbnail;
    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();

        getBundleExtras();
        setTextView();

        loadImageThumbnail();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void loadImageThumbnail(){
        Glide.with(this)
                .load(thumbnail)
                .centerCrop()
                .override(300,300)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .crossFade()
                .into(imageView);
    }

    private void init(){
        imageView = (ImageView) findViewById(R.id.imagething);
        textView = (TextView) findViewById(R.id.tit);
    }

    private void getBundleExtras(){
        extras = getIntent().getExtras();
        title = extras.getString("theTitle");
        thumbnail = extras.getString("thumbnail");
    }

    private void setTextView(){
        textView.setText(title);
    }
}
