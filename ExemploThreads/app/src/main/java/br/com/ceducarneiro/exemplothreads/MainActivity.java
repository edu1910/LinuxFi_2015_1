package br.com.ceducarneiro.exemplothreads;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MinhaTask().execute(100);
    }

    class MinhaTask extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected void onPreExecute() {
            Toast.makeText(MainActivity.this, "Pre!", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            int rnd = (int) (Math.random() * params[0]);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return rnd;
        }

        @Override
        protected void onPostExecute(Integer num) {
            Toast.makeText(MainActivity.this, "Post: " + num, Toast.LENGTH_SHORT).show();
        }
    }

}
