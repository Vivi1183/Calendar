package org.calendar.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;
import java.util.Map;

public class QuestManager {

    private static volatile QuestManager INSTANCE;

    private Map<String, Quest> questMap = new HashMap<>();
    private SharedPreferences settings;

    private QuestManager(Context context) {
        settings = context.getSharedPreferences("QUESTS", Context.MODE_PRIVATE);
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        for (int i = 1; i <= 31; i++) {
            String day = String.valueOf(i);
            if (i < 10)
                day = "0".concat(day);
            boolean complete = settings.getBoolean(day, false);
            questMap.put(day, new Quest(complete));
        }

    }

    public boolean getComplete(String questId) {
        return questMap.get(questId).isComplete();
    }

    public void setComplete(String questId, boolean complete) {
        questMap.get(questId).setComplete(complete);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(questId, complete).commit();
    }

    public static QuestManager getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (QuestManager.class) {
                if (INSTANCE == null) {
                    QuestManager instance = new QuestManager(context);
                    INSTANCE = instance;
                    return instance;
                }
            }
        }
        return INSTANCE;
    }

    private class Quest {
        public boolean isComplete() {
            return complete;
        }

        public void setComplete(boolean complete) {
            this.complete = complete;
        }

        private boolean complete;

        Quest(boolean complete) {
            this.complete = complete;
        }
    }
}
