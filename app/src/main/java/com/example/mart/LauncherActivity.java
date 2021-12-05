package com.example.mart;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mart.databinding.ActivityLaucherBinding;

import java.util.Objects;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LauncherActivity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_laucher);


        ImageView image;
        TextView name,slogan;
        Animation fromtop,frombottom;




        image = (ImageView) findViewById(R.id.logo);
        name = (TextView)findViewById(R.id.appname);
        slogan=(TextView) findViewById(R.id.slogan);

        fromtop = AnimationUtils.loadAnimation(this,R.anim.from_top);
        frombottom = AnimationUtils.loadAnimation(this,R.anim.from_bottom);

        image.setAnimation(fromtop);
        name.setAnimation(frombottom);
        slogan.setAnimation(frombottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                image.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.options,new UserType()).commit();

            }
        },1500);


    }

}