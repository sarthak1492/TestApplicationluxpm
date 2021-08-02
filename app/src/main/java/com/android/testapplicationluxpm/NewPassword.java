package com.android.testapplicationluxpm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewPassword extends AppCompatActivity {

    @BindView(R.id.lblAppname)
    TextView lblAppname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
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
    }
}