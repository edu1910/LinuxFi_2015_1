package br.com.ceducarneiro.exerciciofinal.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import br.com.ceducarneiro.exerciciofinal.ExercicioApplication;
import br.com.ceducarneiro.exerciciofinal.service.SyncService;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(ExercicioApplication.LOG_TAG, "Alarme recebido!");
        if (!SyncService.isRunning()) {
            Intent it = new Intent(context, SyncService.class);
            context.startService(it);
        }
    }
}
