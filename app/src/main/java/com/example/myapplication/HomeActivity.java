package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    private Button btnStart;
    private ImageView imgSpin;
    private EditText p01, p02, p03, p04;
    private Random random = new Random();
    private int lastDirection;
    private int newDirection;
    private ImageView playAgain;
    private LinearLayout ll_spin;
    private LinearLayout ll_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViews();
        listener();

    }

    private void listener() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String person_01 = p01.getText().toString();
                String person_02 = p02.getText().toString();
                String person_03 = p03.getText().toString();
                String person_04 = p04.getText().toString();
                if (person_01.matches("") | person_02.matches("") | person_03.matches("") | person_04.matches("")) {
                    Toast.makeText(HomeActivity.this, "Please Define Person", Toast.LENGTH_SHORT).show();
                } else {
                    btnStart.setVisibility(View.GONE);
                    ll_start.setVisibility(View.GONE);
                    ll_spin.setVisibility(View.VISIBLE);
                    imgSpin.setVisibility(View.VISIBLE);
                    p01.setEnabled(false);
                    p02.setEnabled(false);
                    p03.setEnabled(false);
                    p04.setEnabled(false);
                }
            }
        });
        imgSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newDirection = random.nextInt(3600);
                float x = imgSpin.getWidth() / 2;
                float y = imgSpin.getHeight() / 2;
                Animation rotation = new RotateAnimation(lastDirection, newDirection, x, y);
                lastDirection = newDirection;
                rotation.setDuration(2000);
                rotation.setFillAfter(true);
                imgSpin.startAnimation(rotation);
            }
        });
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgSpin.setVisibility(View.GONE);
                ll_spin.setVisibility(View.GONE);
                ll_start.setVisibility(View.VISIBLE);
                btnStart.setVisibility(View.VISIBLE);
                p01.setEnabled(true);
                p02.setEnabled(true);
                p03.setEnabled(true);
                p04.setEnabled(true);
            }
        });

    }

    private void findViews() {
        btnStart = findViewById(R.id.btn_start);
        imgSpin = findViewById(R.id.img_spin);
        p01 = findViewById(R.id.input_name_01);
        p02 = findViewById(R.id.input_name_02);
        p03 = findViewById(R.id.input_name_03);
        p04 = findViewById(R.id.input_name_04);
        playAgain = findViewById(R.id.play_again);
        ll_spin = findViewById(R.id.img_spin_layout);
        ll_start = findViewById(R.id.btn_start_layout);

    }
}