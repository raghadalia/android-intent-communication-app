package com.example.intentsss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private BottomNavigationView bottom;
private ImageButton sms1;
    private ImageButton email;
    private ImageButton map;
    private ImageButton photo;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Log.i("home"," onCreateOptionsMenu is called");
        MenuInflater flat = getMenuInflater();
        flat.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("services");
        bar.setDisplayHomeAsUpEnabled(true);
        BottomNavigationView bottom = findViewById(R.id.bottom);
        sms1=findViewById(R.id.sms2);
        email=   findViewById(R.id.email2);
        map=findViewById(R.id.map2);
        photo=findViewById(R.id.camera);
        sms1.setOnClickListener(this);
        email.setOnClickListener(this);
        map.setOnClickListener(this);
        photo.setOnClickListener(this);
        bottom.setItemIconTintList(null);

        bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.Sms)
                {
                    Sms();
                }
                else if ( item.getItemId()==R.id.Email)
                {

                    Email();
                }
                else if (item.getItemId()==R.id.Map)
                {
                    Map();
                }
                else if ( item.getItemId()==R.id.Photo)
                {
                    takePhoto();
                }
                return true;
            }
                });
            }

            private void Sms() {
                Intent a=new Intent(this,smsAct.class);
                startActivity(a);

            }

            private void Email() {
                Intent a=new Intent(this,secAct.class);
                startActivity(a);

            }


            private void Map() {
                Intent a=new Intent(this,mapAct.class);
                startActivity(a);
            }

            private void takePhoto() {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
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
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");

                }
            }

    @Override
    public void onClick(View item) {
        if (item==sms1)
        {
            Sms();
        }
        else if ( item==email)
        {

            Email();
        }
        else if (item==map)
        {
            Map();
        }
        else if ( item==photo)
        {
            takePhoto();
        }
    }
}


