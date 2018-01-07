package org.kinneret.behemoth;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class SeferPerakim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sefer_perakim);
        Intent intent = getIntent();

        String sefer = intent.getStringExtra("Sefer");
        Integer perakim = 0;
        switch (sefer) {
            case "Bereishit":
                //50
                perakim = 50;
                break;
            case "Shmot":
                //40
                perakim = 40;
                break;
            case "Vayikrah":
                //27
                perakim = 27;
                break;
                //36
            case "Bamidbar":
                perakim = 36;
                break;
            case "Divarim":
                //34
                perakim = 34;
        }

        createLayoutDynamically(perakim);


    }


    private void createLayoutDynamically(Integer n) {

        for (int i = 0; i < n; i++) {
            Button myButton = new Button(this);
            myButton.setText("Button :" + i);
            myButton.setId(i);
            final int id_ = myButton.getId();

            final LinearLayout layout = (LinearLayout) findViewById(R.id.PerakimList);
            layout.addView(myButton);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(SeferPerakim.this, "Button clicked index = " + id_, Toast.LENGTH_SHORT).show();

                }
            });
        }


    }

}
