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

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lblAppname)
    TextView lblAppname;
    @BindView(R.id.txtEmailValue)
    EditText txtEmailValue;
    @BindView(R.id.txtpassword)
    EditText txtpassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.lblForgotpassword)
    TextView lblForgotpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        lblForgotpassword.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(view -> {
            if (!isValidEmailId(txtEmailValue.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter a valid email.", Toast.LENGTH_SHORT).show();
                return;
            } else if (txtpassword.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Please enter password.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (txtEmailValue.getText().toString().equals("test@luxpmsoft.com") && txtpassword.getText().toString().equals("test1234!")){
                Intent intent = new Intent(this, LandingPage.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Email/password combination does not match.", Toast.LENGTH_SHORT).show();
            }

        });



    }

    public static boolean isValidEmailId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
}