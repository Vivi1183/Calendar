package org.calendar.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.calendar.R;

public class DayActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String BUTTON_ID = "BUTTON_ID";
    public static final String BACKGROUND_PREFIX = "day_layout_";

    private QuestManager questManager;
    private String buttonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_day);
        questManager = QuestManager.getInstance(this);
        buttonId = getIntent().getStringExtra(BUTTON_ID);

        int layoutResourceId = getResources().getIdentifier(BACKGROUND_PREFIX + buttonId, "layout", this.getPackageName());
        LinearLayout layout = (LinearLayout) findViewById(R.id.root_layout);

        LayoutInflater layoutInflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(layoutResourceId, layout, false);
        layout.addView(v);

        CheckBox checkBox = v.findViewById(R.id.cb_quest_complete);
        checkBox.setChecked(questManager.getComplete(buttonId));
        checkBox.setOnClickListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();

    }

    @Override
    public void onClick(View view) {
        CheckBox checkBox = (CheckBox) view;
        Log.w("onClick", "onClick: " + buttonId + " state: " + checkBox.isChecked());
        questManager.setComplete(buttonId, checkBox.isChecked());
    }
}
