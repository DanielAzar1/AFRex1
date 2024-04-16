package com.example.afrex1;

import static java.sql.Types.NULL;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText aParam, bParam, cParam;
    Button randBtn, calcBtn;
    TextView formula, x1main, x2main;
    Random rand = new Random();
    int rnd1, rnd2, rnd3;
    int a, b, c;
    String temp;
    int numcheck = 0;
    double sol1, sol2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aParam = findViewById(R.id.aParam);
        bParam = findViewById(R.id.bParam);
        cParam = findViewById(R.id.cParam);
        x1main = findViewById(R.id.x1main);
        x2main = findViewById(R.id.x2main);
    }

    public void rand(View view) {
        rnd1 = rand.nextInt(10+1);
        rnd2 = rand.nextInt(10+1);
        rnd3 = rand.nextInt(10+1);
        aParam.setText(String.valueOf(rnd1));
        bParam.setText(String.valueOf(rnd2));
        cParam.setText(String.valueOf(rnd3));
    }

    public void calc(View view) {
        temp = aParam.getText().toString();
        if (!temp.isEmpty())
        {
            if(isInteger(temp))
            {
                if(temp.equals("0") || temp.equals("-0"))
                {
                    Toast.makeText(this, "The a parameter cannot be 0.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    a = Integer.parseInt(temp);
                    numcheck ++;
                }
            }
            else
            {
                Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
                numcheck = 0;
            }
        }
        else
        {
            Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
            numcheck = 0;
        }
        temp = bParam.getText().toString();
        if (!temp.isEmpty())
        {
            if(isInteger(temp))
            {
                b = Integer.parseInt(temp);
                numcheck ++;
            }
            else
            {
                Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
                numcheck = 0;
            }
        }
        else
        {
            Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
            numcheck = 0;
        }
        temp = cParam.getText().toString();
        if (!temp.isEmpty())
        {
            if(isInteger(temp))
            {
                c = Integer.parseInt(temp);
                numcheck ++;
            }
            else
            {
                Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
                numcheck = 0;
            }
        }
        else
        {
            Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
            numcheck = 0;
        }

        if  (numcheck == 3)
        {
            go();
        }

    }

    public boolean isInteger(String str) {
        if (str.length() == 1)
        {
            if (str.equals(".")) {return false;}
            if (str.equals("+")) {return false;}
            if (str.equals("-")) {return false;}
        }
        else
        {
            if (str.equals("-.")) {return false;}
            if (str.equals("+.")) {return false;}

        }
        return true;
    }

    public void go() {
        Intent si = new Intent(this,resultActivity.class);
        si.putExtra("aParam", a);
        si.putExtra("bParam", b);
        si.putExtra("cParam", c);
        startActivityForResult(si, 100);
    }

    protected void onActivityResult(int source, int result, @Nullable Intent data_back) {
        super.onActivityResult(source, result, data_back);
        if (result == RESULT_OK && data_back != null) {
            sol1 = data_back.getDoubleExtra("x1", 0); // Provide a suitable default value
            sol2 = data_back.getDoubleExtra("x2", 0); // Provide a suitable default value

            // Make TextViews visible and set the text
            x1main.setVisibility(View.VISIBLE);
            x2main.setVisibility(View.VISIBLE);
            x1main.setText("x1 = " + sol1);
            x2main.setText("x2 =  " + sol2);
        }
        else
        {
            x1main.setVisibility(View.VISIBLE);
            x2main.setVisibility(View.VISIBLE);
            x1main.setText("Bruh");
            x2main.setText("Bruh");
        }

    }


}