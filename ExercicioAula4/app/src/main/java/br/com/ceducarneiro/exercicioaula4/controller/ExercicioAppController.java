package br.com.ceducarneiro.exercicioaula4.controller;

import android.app.Application;

public final class ExercicioAppController extends Application {

    private static ExercicioAppController instance;

    public static synchronized ExercicioAppController getInstance() {
        if (instance == null) {
            instance = new ExercicioAppController();
        }

        return instance;
    }

}
