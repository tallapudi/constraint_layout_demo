package com.example.vamsi.myapplication;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.vamsi.myapplication.fragments.CommunitiesFragment;
import com.example.vamsi.myapplication.fragments.ExpertsFragment;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;

    TextView tvExperts, tvCommunities, tvUsers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.frame_container);
        tvExperts = (TextView) findViewById(R.id.tv_experts);
        tvCommunities = (TextView) findViewById(R.id.tv_communities);
        tvUsers = (TextView) findViewById(R.id.tv_users);

        tvCommunities.setTextColor(ContextCompat.getColor(this, R.color.designation));
        tvUsers.setTextColor(ContextCompat.getColor(this, R.color.designation));

        tvCommunities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCommunities.setTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.white));
                tvExperts.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.designation));

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, new CommunitiesFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        tvExperts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExperts.setTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.white));
                tvCommunities.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.designation));

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, new ExpertsFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, new ExpertsFragment())
                .addToBackStack(null)
                .commit();
    }
}