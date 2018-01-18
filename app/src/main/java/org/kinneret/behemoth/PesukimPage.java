package org.kinneret.behemoth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PesukimPage extends AppCompatActivity {

    private TextView pesukim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesukim_page);

        Intent intent = getIntent();

        String sefer = intent.getStringExtra("Sefer");
        Integer perek = intent.getIntExtra("Perek",0);

        pesukim = (TextView) findViewById(R.id.pesukim);


    }
}
