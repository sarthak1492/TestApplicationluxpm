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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgotPassword extends AppCompatActivity {

    @BindView(R.id.lblAppname)
    TextView lblAppname;
    @BindView(R.id.txtEmailValue)
    EditText txtEmailValue;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

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

        btnLogin.setOnClickListener(view -> {
            if (MainActivity.isValidEmailId(txtEmailValue.getText().toString())){
                if (txtEmailValue.getText().toString().equals("test@luxpmsoft.com")){
                    Intent intent = new Intent(getApplicationContext(), OneTimeKeyActivity.class);
                    intent.putExtra("email", txtEmailValue.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "This email is not registered.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Please enter a valid email.", Toast.LENGTH_SHORT).show();
            }

        });
    }
}