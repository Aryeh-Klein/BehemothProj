package org.kinneret.behemoth;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeferPage extends AppCompatActivity {

    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sefer_page);

       /* final Button myButton;
        myButton = (Button)(R.id.per);*/



        final Button buttonBereshit = (Button) findViewById(R.id.Bereshit);
        buttonBereshit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                OpenSefer(v, "Bereishit");

            }
        });

        final Button buttonShmot = (Button) findViewById(R.id.Shmot);
        buttonShmot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                OpenSefer(v, "Shmot");

            }
        });

        final Button buttonVayikrah = (Button) findViewById(R.id.Vayikrah);
        buttonVayikrah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                OpenSefer(v, "Vayikrah");

            }
        });

        final Button buttonBamidbar = (Button) findViewById(R.id.Bamidbar);
        buttonBamidbar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                OpenSefer(v, "Bamidbar");

            }
        });

        final Button buttonDivarim = (Button) findViewById(R.id.Divarim);
        buttonDivarim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                OpenSefer(v, "Divarim");

            }
        });

    }

    private void OpenSefer(View view, String sefer){

        Intent intent = new Intent(this, SeferPerakim.class);
        intent.putExtra("Sefer",sefer);
        startActivity(intent);

    }


}
