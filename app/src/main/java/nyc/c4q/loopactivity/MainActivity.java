package nyc.c4q.loopactivity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DoStuff test = new DoStuff();
        test.execute(num);

    }


    class DoStuff extends AsyncTask<Integer, Integer, Integer> {

        TextView view;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view = (TextView) view.findViewById(R.id.text);
        }

        @Override
        protected Integer doInBackground(Integer... value) {
            int count = 0;

            for (int i = num; i < 100000; i++) {
                publishProgress(i);
                count += 1;

            }

            return count;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            view.setText("Loops Completed :" + progress[0]);
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            view.setText("Loops Completed" + result);
        }


    }
}
