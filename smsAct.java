package com.example.intentsss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class smsAct extends AppCompatActivity implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback{
private EditText num;
    private EditText mass;
    private Button conform;
    public static final int SEND_REQUST_CODE=10;

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int []grantResults) {
        String phoneNumbers = num.getText().toString().trim();
        String message = mass.getText().toString().trim();
        if(requestCode==SEND_REQUST_CODE){
            if(grantResults.length>0 &&grantResults[0]== getPackageManager().PERMISSION_GRANTED&&permissions[0].equalsIgnoreCase(Manifest.permission.SEND_SMS)){
                SmsManager xx=SmsManager.getDefault();
                xx.sendTextMessage(phoneNumbers,null,message,null,null);


            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
                num=findViewById(R.id.num);
                mass=findViewById(R.id.mass);
                conform=findViewById(R.id.conform);
conform.setOnClickListener(this);

        ActionBar bar = getSupportActionBar();
        bar.setTitle("SMS");
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
        if(view==conform){

            String phoneNumbers = num.getText().toString().trim();
            String message = mass.getText().toString().trim();
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            smsIntent.setData(Uri.parse("smsto:" + phoneNumbers));
            smsIntent.putExtra("sms_body", message);
            startActivity(smsIntent);
        /*
            String phoneNumbers = num.getText().toString().trim();
            String message = mass.getText().toString().trim();

            // Get the default SmsManager 330135°15'15.98"E.
            SmsManager smsManager = SmsManager.getDefault();

            // Split the phone numbers into an array
            String[] numbersArray = phoneNumbers.split(",");

            // Send the SMS to each phone number in the array
            for (String number : numbersArray) {
                smsManager.sendTextMessage(number, null, message, null, null);
            }

            // Display a toast message to the user
            Toast.makeText(this, "SMS sent", Toast.LENGTH_SHORT).show();
*/

        }


        }
    }




