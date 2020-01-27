package com.example.dna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuatAkundifacebook extends AppCompatActivity {

    Button btn_lantukan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_akundifacebook);

        btn_lantukan = findViewById(R.id.btn_lantukan);

         btn_lantukan.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(BuatAkundifacebook.this,CodeVerivikasi.class);
                 startActivity(intent);
             }
         });


    }
}
