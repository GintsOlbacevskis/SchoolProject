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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dalisana extends AppCompatActivity {

    int dalamais;
    int dalitajs;
    int dalijums;
    int apjomsInt;
    int count = 0;
    int dalitajsI;
    int i;
    String Randdalijums, Editdalijums;
    Random dalamaisRandom, dalitajsRandom;
    List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dalisana);
        Intent data = getIntent();
        String apjomsStr = data.getStringExtra("apjoms");
        try {
            apjomsInt = Integer.parseInt(apjomsStr);
        } catch(NumberFormatException nfe) {}

        TextView saskaitisanasTitleText = (TextView) findViewById(R.id.textView51);
        saskaitisanasTitleText.append(" " + apjomsStr);

        dalamaisRandom = new Random();
        dalamais = (dalamaisRandom.nextInt(apjomsInt) + 1);

        list = new ArrayList<Integer>();
        for (i=1; i <= dalamais; i++) {
            dalijums = dalamais % i;
            if (dalijums == 0) {
                list.add(i);
                count += 1;
            }
        }
        dalitajsRandom = new Random();
        dalitajsI = (dalitajsRandom.nextInt(count) + 1);
        dalitajs = list.get(dalitajsI);
        dalijums = dalamais / dalitajs;

        TextView dalamaisText = (TextView) findViewById(R.id.textView56);
        dalamaisText.setText(String.valueOf(dalamais));
        TextView dalitajsText = (TextView) findViewById(R.id.textView45);
        dalitajsText.setText(String.valueOf(dalitajs));
        TextView dalisanaText = (TextView) findViewById(R.id.textView62);

        Button buttonDalisana = (Button) findViewById(R.id.button24);
        buttonDalisana.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                EditText summaText = (EditText)findViewById(R.id.editTextNumber5);
                Editdalijums = String.valueOf(summaText.getText());
                Randdalijums = String.valueOf(dalijums);
                if (Randdalijums.equals(Editdalijums)) {
                    dalisanaText.setText(String.valueOf(dalamais));
                    dalisanaText.append(" / " + dalitajs);
                    dalisanaText.append(" = " + summaText.getText());
                } else {
                    dalisanaText.setText(String.valueOf(dalamais));
                    dalisanaText.append(" / " + dalitajs);
                    dalisanaText.append(" NAV " + summaText.getText());
                }
            }
        });

        Button buttonRefreshDal = (Button) findViewById(R.id.button26);
        buttonRefreshDal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        Button buttonBackDal = (Button) findViewById(R.id.button25);
        buttonBackDal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Dalisana.this, MainActivity.class);
                intent.putExtra("activity_2_msg", "I clicked the button");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}