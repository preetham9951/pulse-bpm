    package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;

    public class MainActivity2 extends AppCompatActivity {
        Camera camera;
        Parameters parameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT,10);
                startActivityForResult(intent,1);


            }
        });
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(resultCode == RESULT_OK && requestCode == 1){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                VideoView videoView = new VideoView(this);
                videoView.setVideoURI(data.getData());
                videoView.start();
                builder.setView(videoView).show();
            }
        }
    }