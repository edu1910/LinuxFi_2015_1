package br.com.ceducarneiro.exerciciofinal.controller;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import br.com.ceducarneiro.exerciciofinal.ExercicioApplication;
import br.com.ceducarneiro.exerciciofinal.receiver.AlarmReceiver;

public class AlarmController {

    private static AlarmController instance;

    private AlarmController() {
    }

    public static synchronized AlarmController getInstance() {
        if (instance == null) {
            instance = new AlarmController();
        }

        return instance;
    }

    public void registerSyncAlarm() {
        Context context = ExercicioApplication.getInstance();
        AlarmManager manager = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                1000 * 30, pendingIntent);
    }

    public void cancelSyncAlarm() {
        Context context = ExercicioApplication.getInstance();
        AlarmManager manager = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        manager.cancel(pendingIntent);
    }

}
