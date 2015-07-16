package br.com.ceducarneiro.exerciciofinal;

import com.orm.SugarApp;

public class ExercicioApplication extends SugarApp {

    public static String LOG_TAG = "EXAPP";
    private static ExercicioApplication instance;

    public ExercicioApplication() {
        instance = this;
    }

    public static ExercicioApplication getInstance() {
        return instance;
    }

}
