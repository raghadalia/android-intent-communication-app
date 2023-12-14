package com.example.intentsss;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mapAct extends AppCompatActivity implements View.OnClickListener {
private EditText loc;
    private EditText log;
    private EditText lat;
private Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
loc=findViewById(R.id.loc);
log=findViewById(R.id.log);
lat=findViewById(R.id.lot);
go=findViewById(R.id.go);
go.setOnClickListener(this);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Google Map");
        bar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    @Override
    public void onClick(View view) {
        if(view==go){
            String locationName = loc.getText().toString();
            String latitude = lat.getText().toString();
            String longitude = log.getText().toString();

            Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(locationName) + latitude + "," + longitude);// an-najah national university 32°13'41"N, 35°13'20"E
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
            startActivity(mapIntent);

        }
    }
}