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

public class Reizinasana extends AppCompatActivity {

    int reizinatajs1;
    int reizinatajs2;
    int reizinajums;
    int apjomsInt;
    int reizinatajs2Max;
    String RandReizinajums, EditReizinajums;
    Random reizinatajs1Random, reizinatajs2Random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reizinasana);
        Intent data = getIntent();
        String apjomsStr = data.getStringExtra("apjoms");
        try {
            apjomsInt = Integer.parseInt(apjomsStr);
        } catch(NumberFormatException nfe) {}

        TextView saskaitisanasTitleText = (TextView) findViewById(R.id.textView51);
        saskaitisanasTitleText.append(" " + apjomsStr);

        reizinatajs1Random = new Random();
        reizinatajs1 = (reizinatajs1Random.nextInt(apjomsInt/2) + 1);
        reizinatajs2Max = apjomsInt / reizinatajs1;
        reizinatajs2Random = new Random();
        reizinatajs2 = (reizinatajs2Random.nextInt(reizinatajs2Max) + 1);
        reizinajums = reizinatajs1 * reizinatajs2;

        TextView reizinatajs1Text = (TextView) findViewById(R.id.textView56);
        reizinatajs1Text.setText(String.valueOf(reizinatajs1));
        TextView reizinatajs2Text = (TextView) findViewById(R.id.textView45);
        reizinatajs2Text.setText(String.valueOf(reizinatajs2));
        TextView reizinasanaText = (TextView) findViewById(R.id.textView62);

        Button buttonReizinasana = (Button) findViewById(R.id.button24);
        buttonReizinasana.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                EditText summaText = (EditText)findViewById(R.id.editTextNumber5);
                EditReizinajums = String.valueOf(summaText.getText());
                RandReizinajums = String.valueOf(reizinajums);
                if (RandReizinajums.equals(EditReizinajums)) {
                    reizinasanaText.setText(String.valueOf(reizinatajs1));
                    reizinasanaText.append(" * " + reizinatajs2);
                    reizinasanaText.append(" = " + summaText.getText());
                } else {
                    reizinasanaText.setText(String.valueOf(reizinatajs1));
                    reizinasanaText.append(" * " + reizinatajs2);
                    reizinasanaText.append(" NAV " + summaText.getText());
                }
            }
        });

        Button buttonRefreshReiz = (Button) findViewById(R.id.button26);
        buttonRefreshReiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        Button buttonBackReiz = (Button) findViewById(R.id.button25);
        buttonBackReiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Reizinasana.this, MainActivity.class);
                intent.putExtra("activity_2_msg", "I clicked the button");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}