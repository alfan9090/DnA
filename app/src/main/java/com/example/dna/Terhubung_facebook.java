package com.example.dna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Terhubung_facebook extends AppCompatActivity {

    Button buat_akun_dna,btn_masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terhubung_facebook);
            buat_akun_dna = findViewById(R.id.buat_akun_dna);
            btn_masuk = findViewById(R.id.btn_masuk);

            buat_akun_dna.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Terhubung_facebook.this,BuatAkundifacebook.class);
                    startActivity(intent);
                }
            });


        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Terhubung_facebook.this,Verifikasi_via_nomor_telfon.class);
                startActivity(intent);
            }
        });


    }
}
