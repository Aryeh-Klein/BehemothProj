package org.kinneret.behemoth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

public class PesukimPage extends AppCompatActivity {

    private TextView pesukim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesukim_page);

        Intent intent = getIntent();

        String sefer = intent.getStringExtra("Sefer");
        Integer perek = intent.getIntExtra("Perek",0);
        Integer number = intent.getIntExtra("number",0);

        pesukim = (TextView) findViewById(R.id.pesukim);

        if(sefer.equals("Shmot") && perek == 32){
            /*try{
                StringBuilder buf = new StringBuilder();
                InputStream json = getAssets().open("Shmot32.txt");
                BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
                String str;

                while ((str = in.readLine()) != null) {
                    buf.append(str);
                }

                in.close();
                pesukim.setText(buf.toString());
            }
            catch(IOException e){

            }*/
            pesukim.setText(R.string.shmot32);

        }
        else{
            setUpPage(sefer, perek, number);
        }



    }

    private void setUpPage(String sefer, final Integer perekid, final Integer num){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder  = new StringBuilder();
                String perekFinder = "Chapter " + perekid;
                String tempUri = "https://www.mechon-mamre.org/p/pt/pt0" + num + ".htm";
                URI machonSefer =  URI.create(tempUri);
                InputStream is = null;

                try{
                    Log.d("Pesukim","reached");
                    /*Document doc  = Jsoup.connect(tempUri).get();*/
                    is = getAssets().open("bereishitheb.html");
                    Document doc = Jsoup.parse(is,"UTF-8","https://www.example.com");
                    Elements perakim = doc.getElementsByTag("H2");
                    Element perek = perakim.get(perekid - 1);
                    Element table = perek.nextElementSibling();
                    Elements pesukimHebrew = table.getElementsByClass("h");
                    for(Element pasuk : pesukimHebrew){
                        builder.append(pasuk.text()).append("\n");
                    }
                    /*for(Element perek: perakim){
                        String current = perek.text();
                        if(current.equals(perekFinder)){
                            Element table = perek.nextElementSibling();
                            Elements pesukimHebrew = table.getElementsByClass("h");
                            for(Element pasuk : pesukimHebrew){
                                builder.append(pasuk.text()).append("\n");
                            }
                        }
                    }*/

                }catch(Exception e){
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pesukim.setText(builder.toString());
                    }
                });
            }

        }).start();
    }
}
