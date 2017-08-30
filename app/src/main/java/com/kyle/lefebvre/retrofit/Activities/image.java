package com.kyle.lefebvre.retrofit.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kyle.lefebvre.retrofit.R;

public class image extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setBackgroundDrawable(
        //        new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.activity_image_view);



        Bundle extras = getIntent().getExtras();
        String  title = extras.getString("theTitle");
        String thumbnail = extras.getString("thumbnail");

        Log.d("ddd",title + "   " + thumbnail);

        ImageView imageView = (ImageView) findViewById(R.id.imagething);
        TextView textView = (TextView) findViewById(R.id.tit);
        textView.setText(title);


        Glide.with(this)
                .load(thumbnail)
                .centerCrop()
                .override(300,300)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .crossFade()
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
