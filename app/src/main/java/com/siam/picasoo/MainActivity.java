package com.siam.picasoo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    ProgressBar progressBar;
    TextView textError;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        progressBar = findViewById(R.id.progress_circular);
        textError = findViewById(R.id.textError);

        Picasso.get()
                .load("https://d2u0ktu8omkpf6.front.net/e45b2cbc20d24f7ae2caed29499b3e712e68c1d758a0c99b.png")
                .into(image, new Callback() {
                    @Override
                    public void onSuccess() {
                        image.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        image.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        textError.setVisibility(View.VISIBLE);
                    }
                });


    }
}