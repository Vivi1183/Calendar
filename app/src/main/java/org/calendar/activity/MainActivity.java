package org.calendar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.calendar.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNewDay(View v) {
        Button button = (Button) v;
        String buttonId = button.getText().toString();

        Intent intent = new Intent(getBaseContext(), DayActivity.class);
        intent.putExtra(DayActivity.BUTTON_ID, buttonId);
        startActivity(intent);
    }
}
