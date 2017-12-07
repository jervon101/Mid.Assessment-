package nyc.c4q.loopactivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView view;
    Button button;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = 0;

        DoStuff test = new DoStuff();
        test.execute(num);

        view = (TextView) findViewById(R.id.text);

        button = (Button) findViewById(R.id.buttonmain);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });



    }


    class DoStuff extends AsyncTask<Integer, Integer, Integer> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();

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
