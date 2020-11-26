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

public class Atnemsana extends AppCompatActivity {

    int mazinamais;
    int mazinatajs;
    int starpiba;
    int apjomsInt;
    String Randstarpiba, EditStarpiba;
    Random mazinamaisRandom, starpibaRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atnemsana);
        Intent data = getIntent();
        String apjomsStr = data.getStringExtra("apjoms");
        try {
            apjomsInt = Integer.parseInt(apjomsStr);
        } catch(NumberFormatException nfe) {}

        TextView saskaitisanasTitleText = (TextView) findViewById(R.id.textView51);
        saskaitisanasTitleText.append(" " + apjomsStr);

        mazinamaisRandom = new Random();
        mazinamais = (mazinamaisRandom.nextInt(apjomsInt) + 1);
        starpibaRandom = new Random();
        starpiba = (starpibaRandom.nextInt(mazinamais) + 1);
        mazinatajs = mazinamais - starpiba;

        TextView mazinamaisText = (TextView) findViewById(R.id.textView56);
        mazinamaisText.setText(String.valueOf(mazinamais));
        TextView mazinatajsText = (TextView) findViewById(R.id.textView45);
        mazinatajsText.setText(String.valueOf(mazinatajs));
        TextView atnemsanaText = (TextView) findViewById(R.id.textView62);

        Button buttonAtnemsana = (Button) findViewById(R.id.button24);
        buttonAtnemsana.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                EditText summaText = (EditText)findViewById(R.id.editTextNumber5);
                EditStarpiba = String.valueOf(summaText.getText());
                Randstarpiba = String.valueOf(starpiba);
                if (Randstarpiba.equals(EditStarpiba)) {
                    atnemsanaText.setText(String.valueOf(mazinamais));
                    atnemsanaText.append(" - " + mazinatajs);
                    atnemsanaText.append(" = " + summaText.getText());
                } else {
                    atnemsanaText.setText(String.valueOf(mazinamais));
                    atnemsanaText.append(" - " + mazinatajs);
                    atnemsanaText.append(" NAV " + summaText.getText());
                }
            }
        });

        Button buttonRefreshAtn = (Button) findViewById(R.id.button26);
        buttonRefreshAtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        Button buttonBackAtn = (Button) findViewById(R.id.button25);
        buttonBackAtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Atnemsana.this, MainActivity.class);
                intent.putExtra("activity_2_msg", "I clicked the button");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}