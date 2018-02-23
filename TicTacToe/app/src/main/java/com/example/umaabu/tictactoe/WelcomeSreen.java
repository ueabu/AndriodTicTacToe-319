package com.example.umaabu.tictactoe;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;



public class WelcomeSreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_sreen);


        Button Multiplayer = findViewById(R.id.Multiplayer);
        Button SinglePlayer = findViewById(R.id.SinglePlayer);


        Multiplayer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent i = new Intent(WelcomeSreen.this, MainActivity.class);

                startActivity(i);
            }

        });


        SinglePlayer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent i = new Intent(WelcomeSreen.this, MainActivity.class);

                startActivity(i);
            }

        });



    }

}