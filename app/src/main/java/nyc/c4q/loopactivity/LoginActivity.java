package nyc.c4q.loopactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREF_KEY = "test";

    private SharedPreferences log;
    Button button;
    CheckBox box;
    EditText edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        log = getSharedPreferences(SHARED_PREF_KEY, MODE_PRIVATE);

        button = (Button) findViewById(R.id.button);
        box = (CheckBox) findViewById(R.id.box);
        edit1 = (EditText) findViewById(R.id.edit01);
        edit2 = (EditText) findViewById(R.id.edit02);

        SharedPreferences.Editor editor = log.edit();


        button.setOnClickListener(new View.OnClickListener() {
            SharedPreferences.Editor editor = log.edit();

            @Override
            public void onClick(View v) {
                if (box.isChecked()) {
                    editor.putString(edit1.getText().toString(), edit2.getText().toString());
                    editor.commit();
                }
                if (edit1.getText().toString().equals("user@aol.com") && edit2.getText().toString().equals("password1234")) {
                    Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                    intent.putExtra("email", edit1.getText().toString());
                    startActivity(intent);
                }

            }
        });

    }
}
