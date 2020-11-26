package lv.gints.learningmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Saskaitisana extends AppCompatActivity {

    int saskaitamais1;
    int saskaitamais2;
    int summa, apjomsInt;
    String RandSum, EditSum;
    Random saskaitamais1Random, summaRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saskaitisana);
        Intent data = getIntent();
        String apjomsStr = data.getStringExtra("apjoms");
        try {
            apjomsInt = Integer.parseInt(apjomsStr);
        } catch(NumberFormatException nfe) {}

        TextView saskaitisanasTitleText = (TextView) findViewById(R.id.textView51);
        saskaitisanasTitleText.append(" " + apjomsStr);

        summaRandom = new Random();
        summa = (summaRandom.nextInt(apjomsInt) + 1);
        saskaitamais1Random = new Random();
        saskaitamais1 = (saskaitamais1Random.nextInt(summa) + 1);
        saskaitamais2 = summa - saskaitamais1;

        TextView saskaitamais1Text = (TextView) findViewById(R.id.textView56);
        saskaitamais1Text.setText(String.valueOf(saskaitamais1));
        TextView saskaitamais2Text = (TextView) findViewById(R.id.textView45);
        saskaitamais2Text.setText(String.valueOf(saskaitamais2));
        TextView saskaitisanaText = (TextView) findViewById(R.id.textView62);

        Button buttonSaskaita = (Button) findViewById(R.id.button24);
        buttonSaskaita.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                EditText summaText = (EditText)findViewById(R.id.editTextNumber5);
                EditSum = String.valueOf(summaText.getText());
                RandSum = String.valueOf(summa);
                if (RandSum.equals(EditSum)) {
                    saskaitisanaText.setText(String.valueOf(saskaitamais1));
                    saskaitisanaText.append(" + " + saskaitamais2);
                    saskaitisanaText.append(" = " + summaText.getText());
                } else {
                    saskaitisanaText.setText(String.valueOf(saskaitamais1));
                    saskaitisanaText.append(" + " + saskaitamais2);
                    saskaitisanaText.append(" NAV " + summaText.getText());
                }
            }
        });

        Button buttonRefreshSas = (Button) findViewById(R.id.button26);
        buttonRefreshSas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        Button buttonBackSas = (Button) findViewById(R.id.button25);
        buttonBackSas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Saskaitisana.this, MainActivity.class);
                intent.putExtra("activity_2_msg", "I clicked the button");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}