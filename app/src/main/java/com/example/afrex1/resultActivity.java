package com.example.afrex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
    TextView x1,x2;
    int aParam, bParam, cParam;
    float sol1, sol2;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
        img = findViewById(R.id.img);

        Intent gi = getIntent();
        aParam = gi.getIntExtra("aParam", 1);
        bParam = gi.getIntExtra("bParam", 1);
        cParam = gi.getIntExtra("cParam", 1);

        double sol1 = 0;
        double sol2 = 0;


        if ((bParam*bParam +(-4*aParam*cParam)) > 0)
        {
            sol1 = ((-bParam + Math.sqrt(bParam*bParam +(-4*aParam*cParam))) / (2*aParam));
            sol2 = ((-bParam - Math.sqrt(bParam*bParam +(-4*aParam*cParam))) / (2*aParam));
            x1.setText("x1 = "+String.valueOf(sol1));
            x2.setText("x2 = "+String.valueOf(sol2));
        }

        if  ((bParam*bParam +(-4*aParam*cParam)) == 0)
        {
            sol1 = ((-bParam + Math.sqrt(bParam*bParam +(-4*aParam*cParam))) / (2*aParam));
            x1.setText("x1 = "+String.valueOf(sol1));
            x2.setText("x2 = No answer.");
        }

        if  ((bParam*bParam +(-4*aParam*cParam)) < 0)
        {
            x1.setText("x1 = No answer.");
            x2.setText("x2 = No answer.");
        }

        if (aParam > 0)
        {
            if(cParam > 0)
            {
                img.setImageResource(R.drawable.parab3);
            }

            if(cParam == 0)
            {
                img.setImageResource(R.drawable.parab1);
            }

            if(cParam < 0)
            {
                img.setImageResource(R.drawable.parab4);
            }
        }

        if (aParam < 0)
        {
            if(cParam > 0)
            {
                img.setImageResource(R.drawable.parab2);
            }

            if(cParam == 0)
            {
                img.setImageResource(R.drawable.parab6);
            }

            if(cParam < 0)
            {
                img.setImageResource(R.drawable.parab5);
            }
        }
    }

    public void dodge(View view) {
        Intent gi = new Intent();
        gi.putExtra("x1", sol1);
        gi.putExtra("x2", sol2);
        setResult(RESULT_OK, gi);
        finish();
    }


}