package com.example.salaryallowance;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    Button startButton, creditButton;
    Animation scaleUp, scaleDown;
    ImageView logo, logoText, dashLineImg;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decor = MainActivity.this.getWindow().getDecorView();
        if(decor.getSystemUiVisibility() != View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR){
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        else{
            decor.setSystemUiVisibility(0);
        }

        startButton = findViewById(R.id.start_btn);

        logo = (ImageView) findViewById(R.id.logoImage);
        logoText = (ImageView) findViewById(R.id.imageView2);
        dashLineImg = (ImageView) findViewById(R.id.dashLine);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_out);

        logo.startAnimation(scaleUp);
        logo.startAnimation(scaleDown);

        logoText.startAnimation(scaleUp);
        logoText.startAnimation(scaleDown);




    }

    public void startButtonAction(View view) {

        Intent intent = new Intent(MainActivity.this, UserInput.class);
        startActivity(intent);
    }

    public void closeButtonAction(View view){
        //System.out.println("Close Pressed");
        finish();
        System.exit(0);
    }

    public void creditsButtonAction(View view){
        creditButton = findViewById(R.id.creditsButton);
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(R.layout.bottom_bar);
        dialog.show();
    }
}

