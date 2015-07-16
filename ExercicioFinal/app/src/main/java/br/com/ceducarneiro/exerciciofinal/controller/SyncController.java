package br.com.ceducarneiro.exerciciofinal.controller;

import java.util.ArrayList;
import java.util.List;

public final class SyncController {

    private static SyncController instance;
    private List<SyncListener> listeners;

    private SyncController() {
        listeners = new ArrayList<>();
    }

    public static synchronized SyncController getInstance() {
        if (instance == null) {
            instance = new SyncController();
        }

        return instance;
    }

    public void addListener(SyncListener listener) {
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public  void removeListener(SyncListener listener) {
        if (listeners.contains(listener))
            listeners.remove(listener);
    }

    public void notifyOnSyncSuccess() {
        for (SyncListener listener : listeners)
            listener.onSyncSuccess();
    }

    public void notifyOnSyncError() {
        for (SyncListener listener : listeners)
            listener.onSyncError();
    }

}
