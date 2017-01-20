    package com.example.khan.musicapp;

    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.*;
    import android.widget.TextView;
    import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            TextView numbers = (TextView) findViewById(R.id.numbers);
            numbers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent numbersIntent = new Intent(MainActivity.this,NumbersActivity.class);
                    startActivity(numbersIntent);
                }
            });

            TextView colors = (TextView) findViewById(R.id.colors);
            colors.setOnClickListener(new View.OnClickListener(){
               @Override
                public void onClick(View view){
                   Intent colorsIntent = new Intent(MainActivity.this,ColorsActivity.class);
                   startActivity(colorsIntent);
               }
            });

            TextView family = (TextView) findViewById(R.id.family);
            family.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent familyIntent = new Intent(MainActivity.this,FamilyActivity.class);
                    startActivity(familyIntent);
                }
            });

            TextView phrases = (TextView) findViewById(R.id.phrases);
            phrases.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent phrasesIntent = new Intent(MainActivity.this,PhrasesActivity.class);
                    startActivity(phrasesIntent);
                }
            });
        }
    }