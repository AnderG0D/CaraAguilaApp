package com.example.lanzarmoneda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    ImageView imgCoin;
    Button btnThrow;
    ProgressBar progressAguila, progressSello;
    TextView txvAguila, txvSello;
    Toolbar menu;

    int aguila = 0, sello = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCoin = findViewById(R.id.imgCoin);
        btnThrow = findViewById(R.id.btnThrow);
        progressAguila = findViewById(R.id.progressAguila);
        progressSello = findViewById(R.id.progressSello);
        txvAguila = findViewById(R.id.txvPA);
        txvSello = findViewById(R.id.txvPS);
        menu = findViewById(R.id.toolbar);

        btnThrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long random = Math.round(Math.random());

                int percentAguila = 0, percentSello = 0;

                if (random == 0) {
                    sello++;
                    imgCoin.setImageResource(R.drawable.mon1);
                }
                else {
                    imgCoin.setImageResource(R.drawable.mon2);
                    aguila++;
                }
                percentAguila = (int)Math.round(aguila*100/(aguila+sello));
                percentSello = (int)Math.round(sello*100/(aguila+sello));

                progressAguila.setProgress(percentAguila);
                progressSello.setProgress(percentSello);

                txvAguila.setText("" + percentAguila + "%");
                txvSello.setText("" + percentSello + "%");
            }
        });

        menu.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        return super.onOptionsItemSelected(item);
    }
}