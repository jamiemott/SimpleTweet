package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {
    Context context;
    ImageView ivProfileImage;
    TextView tvBody;
    TextView tvUserName;
    TextView tvScreenName;
    TextView tvTime;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tweet");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvBody = findViewById(R.id.tvBody);
        tvUserName = findViewById(R.id.tvUserName);
        tvScreenName = findViewById(R.id.tvScreenName);
        tvTime = findViewById(R.id.tvTime);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        tvBody.setText(tweet.getBody());
        tvUserName.setText(tweet.getUser().getName());
        tvScreenName.setText("@" + tweet.getUser().getScreenName());
        tvTime.setText(tweet.getDateTime(tweet.getCreatedAt()));
        Glide.with(ivProfileImage).load(tweet.getUser().getProfileImageUrl()).circleCrop().into(ivProfileImage);


    }

}

