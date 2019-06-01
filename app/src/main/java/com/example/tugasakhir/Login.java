package com.example.tugasakhir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private Button blogin;
    private ImageView imageView;
    private Animation smalltobig, btta, btta2;
    private TextView textView, subtitle_header;
    private Button button;
    private EditText editText, editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // load this animation
        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        btta = AnimationUtils.loadAnimation(this, R.anim.btta);
        btta2 = AnimationUtils.loadAnimation(this, R.anim.btta2);

        imageView = findViewById(R.id.imageView);

        textView = findViewById(R.id.textView);
        subtitle_header = findViewById(R.id.subtitle_header);

        button = findViewById(R.id.signin);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        // passing animation and start it
        imageView.startAnimation(smalltobig);

        textView.startAnimation(btta);
        subtitle_header.startAnimation(btta);

        button.startAnimation(btta2);

        editText.startAnimation(btta2);
        editText2.startAnimation(btta2);

        blogin  = (Button)findViewById(R.id.signin);

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ilogin = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ilogin);
            }
        });

    }
}
