package org.calendar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import org.calendar.R;

public class DayActivity extends AppCompatActivity {

    public static final String BUTTON_ID = "BUTTON_ID";
    public static final String BACKGROUND_PREFIX = "background_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_day);

        String buttonId = getIntent().getStringExtra(BUTTON_ID);

        int drawableResourceId = getResources().getIdentifier(BACKGROUND_PREFIX + buttonId, "drawable", this.getPackageName());

        ImageView backgroundImage = findViewById(R.id.iv_background);
        backgroundImage.setImageResource(drawableResourceId);
    }
}
