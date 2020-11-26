package lv.gints.learningmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToSaskaitisana100(View v) {
        Intent intent = new Intent(MainActivity.this, Saskaitisana.class);
        intent.putExtra("apjoms", "100");
        startActivity(intent);
    }
    public void goToSaskaitisana1000(View v) {
        Intent intent = new Intent(MainActivity.this, Saskaitisana.class);
        intent.putExtra("apjoms", "1000");
        startActivity(intent);
    }
    public void goToAtnemsana100(View v) {
        Intent intent = new Intent(MainActivity.this, Atnemsana.class);
        intent.putExtra("apjoms", "100");
        startActivity(intent);
    }
    public void goToAtnemsana1000(View v) {
        Intent intent = new Intent(MainActivity.this, Atnemsana.class);
        intent.putExtra("apjoms", "1000");
        startActivity(intent);
    }
    public void goToReizinasana100(View v) {
        Intent intent = new Intent(MainActivity.this, Reizinasana.class);
        intent.putExtra("apjoms", "100");
        startActivity(intent);
    }
    public void goToReizinasana1000(View v) {
        Intent intent = new Intent(MainActivity.this, Reizinasana.class);
        intent.putExtra("apjoms", "1000");
        startActivity(intent);
    }
    public void goToDalisana100(View v) {
        Intent intent = new Intent(MainActivity.this, Dalisana.class);
        intent.putExtra("apjoms", "100");
        startActivity(intent);
    }
    public void goToDalisana1000(View v) {
        Intent intent = new Intent(MainActivity.this, Dalisana.class);
        intent.putExtra("apjoms", "1000");
        startActivity(intent);
    }
}