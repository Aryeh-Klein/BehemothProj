package org.kinneret.behemoth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SeferPerakim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sefer_perakim);

        Intent intent = getIntent();
        String sefer = intent.getStringExtra("Sefer");


    }
}
