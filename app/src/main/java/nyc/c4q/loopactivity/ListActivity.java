package nyc.c4q.loopactivity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        Intent intent = getIntent();
       String val= intent.getStringExtra("email");



        BlankFragment frag = new BlankFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction franTran = fragmentManager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("email", val);

        frag.setArguments(bundle);

        franTran.replace(R.id.container, frag);
        franTran.commit();


//        view = (TextView) findViewById(R.id.itemview);
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                String hello =view.getText().toString();
//                NextFragment frag = new NextFragment();
//
//
//                FragmentManager fragmentManager = getSupportFragmentManager();
//
//
//                FragmentTransaction franTran = fragmentManager.beginTransaction();
//                Bundle bundle = new Bundle();
//                bundle.putString("val", hello+"");
//                frag.setArguments(bundle);
//
//                franTran.replace(R.id.bigfrag, frag);
//                franTran.addToBackStack("next");
//                franTran.commit();
//            }
//        });


    }
}
