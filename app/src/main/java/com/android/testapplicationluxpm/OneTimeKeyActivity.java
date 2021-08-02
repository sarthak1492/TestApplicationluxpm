package com.android.testapplicationluxpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alimuzaffar.lib.pin.PinEntryEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OneTimeKeyActivity extends AppCompatActivity {

    @BindView(R.id.lblAppname)
    TextView lblAppname;
    @BindView(R.id.lblCodeDesc)
    TextView lblCodeDesc;
    @BindView(R.id.btnVerify)
    Button btnVerify;
    @BindView(R.id.txt_pin_entry)
    PinEntryEditText txt_pin_entry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time_key);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        Bundle bundle = getIntent().getExtras();
        lblCodeDesc.setText("The code has been sent to "+ bundle.getString("email") + "\n Please enter the code below.");


        TextPaint paint = lblAppname.getPaint();
        float width = paint.measureText(lblAppname.getText().toString());

        Shader textShader = new LinearGradient(0, 0, width, lblAppname.getTextSize(),
                new int[]{
                        Color.parseColor("#87CEFA"),
                        Color.parseColor("#B0E0E6"),
                        Color.parseColor("#5F9EA0"),
                        Color.parseColor("#7B68EE"),
                        Color.parseColor("#7B68EE"),
                }, null, Shader.TileMode.CLAMP);
        lblAppname.getPaint().setShader(textShader);

        btnVerify.setOnClickListener(view -> {
            if (txt_pin_entry.getText().toString().isEmpty() || txt_pin_entry.getText().toString().length() < 8){
                Toast.makeText(getApplicationContext(), "Incorrect/No OTP found.", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), NewPassword.class);
                startActivity(intent);
            }
        });

    }
}