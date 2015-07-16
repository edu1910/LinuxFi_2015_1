package br.com.ceducarneiro.exerciciofinal.controller;

import android.content.Context;
import android.content.SharedPreferences;

import br.com.ceducarneiro.exerciciofinal.ExercicioApplication;

public abstract class PrefsController {

    private static final String PREFS_NAME = "prefs";
    private static final String KEY_LAST_SYNC_DATE = "last_sync_date";

    public static void setLastSyncDate(String lastSyncDate) {
        SharedPreferences.Editor editor = ExercicioApplication.getInstance()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();

        editor.putString(KEY_LAST_SYNC_DATE, lastSyncDate);
        editor.commit();
    }

    public static String getLastSyncDate() {
        SharedPreferences prefs = ExercicioApplication.getInstance()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        return prefs.getString(KEY_LAST_SYNC_DATE, "");
    }

}
