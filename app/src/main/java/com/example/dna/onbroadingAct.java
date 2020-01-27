package com.example.dna;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class onbroadingAct extends AppCompatActivity {
    private ViewPager screenpager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    int position = 0;
    TextView lewati;
    ImageView btn_facebook,btn_google;
    Button btn_Daftar,btn_masuk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (restorePrefData()) {

            Intent Onborading = new Intent(getApplicationContext(), onbroadingAct.class );
            startActivity(Onborading);
            finish();
        }
        setContentView(R.layout.activity_onbroading);
        lewati = findViewById(R.id.lewati);
        btn_Daftar = findViewById(R.id.btn_Daftar);
        btn_Daftar = findViewById(R.id.btn_Daftar);
        btn_facebook = findViewById(R.id.btn_facebook);
        btn_masuk = findViewById(R.id.btn_masuk);
        tabIndicator = findViewById(R.id.tab_indicator);
        btn_google = findViewById(R.id.btn_google);


        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Pertama Dengan Microarray", "DNAku menggunakan teknologi sequencing DNA terkini \n dari Amerika. Bekerjasama hanya dengan para ahli \n dibidangnya, DNAku selalu memberikan hasil yang \n terbaik.", R.drawable.onboard1));
        mList.add(new ScreenItem("Didukung Mitra Terpercaya", "DNAku secara aktif bekerjasama dengan badan riset \n untuk menghasilkan terobosan ilmiah, dengan visi untuk \n memajukan kesadaran dan kesehatan rakyat \n Indonesia.", R.drawable.onboard2));
        mList.add(new ScreenItem("Data Anda Dijamin Aman ", " DNAku menggunakan perangkat lunak yang telah \n disertifikasi oleh ISO serta patuh pada regulasi keamanan \n data Eropa. Sampel Anda juga diolah secara \n anonim.", R.drawable.onboard3));

        screenpager = findViewById(R.id.screen_viwpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this ,mList);
        screenpager.setAdapter(introViewPagerAdapter);

        tabIndicator.setupWithViewPager(screenpager);
//        Blewati.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                position =screenpager.getCurrentItem();
//                if (position < mList.size()){
//                    position++;
//                    screenpager.setCurrentItem(position);
//                }
//                if (position == mList.size()-1) { // when we rech to the last screen
////
////                    // TODO : show the GETSTARTED Button and hide the indicator and the next button
////
//                    loaddLastScreen();
//                }
//            }
//        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()== mList.size()-1){
                    loaddLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        lewati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenpager.setCurrentItem(mList.size());
            }
        });
        btn_Daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar =new Intent(onbroadingAct.this, DaftarAct.class);
                startActivity(daftar);
            }
        });

        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tofacebook =new Intent(onbroadingAct.this, Terhubung_facebook.class);
                startActivity(tofacebook);
            }
        });

        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(onbroadingAct.this,LoginKlikDna.class);
                startActivity(login);
            }
        });


        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verifikasi = new Intent(onbroadingAct.this,CodeVerivikasi.class);
                startActivity(verifikasi);
            }
        });

    }
    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend", false);
        return isIntroActivityOpnendBefore;
    }
    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();

    }
    private void loaddLastScreen (){
        lewati.setVisibility(View.INVISIBLE);
//                tabIndicator.setVisibility(View.INVISIBLE);
    }

    }

