package com.example.dna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Edit_Profile extends AppCompatActivity {
        Button btn_simpan;
        TextView btnskip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile);

        btn_simpan = findViewById(R.id.btn_simpan);
        btnskip = findViewById(R.id.btnskip);


        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent success = new Intent(Edit_Profile.this,Success_regisAct.class);
                startActivity(success);
            }
        });

        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skip = new Intent(Edit_Profile.this,Success_regisAct.class);
                startActivity(skip);
            }
        });
    }
}
