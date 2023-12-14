package com.example.intentsss;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class secAct extends AppCompatActivity implements View.OnClickListener {
private EditText cc;
    private EditText bcc;
    private EditText subject;
    private EditText text;
    private EditText to;
private Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sec);
        cc=findViewById(R.id.cc);
        bcc=findViewById(R.id.bcc);
        to=findViewById(R.id.To);
        subject=findViewById(R.id.subject);
        text=findViewById(R.id.etext);
        ok=findViewById(R.id.ok);
        ok.setOnClickListener(this);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("E-Mail");
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
        if(view==ok){
            Intent email = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));

            email.putExtra(Intent.EXTRA_EMAIL, new String[] {to.getText().toString().trim()});
            email.putExtra(Intent.EXTRA_CC, new String[] {cc.getText().toString().trim()});
            email.putExtra(Intent.EXTRA_BCC, new String[] {bcc.getText().toString().trim()});
            email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString().trim());
            email.putExtra(Intent.EXTRA_TEXT, text.getText().toString().trim());
            startActivity(email);

        }
    }
}