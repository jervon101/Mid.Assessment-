package nyc.c4q.loopactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.loopactivity.model.view.Model;
import nyc.c4q.loopactivity.model.view.ModelAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    TextView fragview;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        fragview = (TextView) view.findViewById(R.id.fragtext);

        List<Model> models = new ArrayList<>();

        Bundle bundle = getArguments();

        String sometext = bundle.getString("email");

        fragview.setText(sometext);


        for (int i = 0; i <= 10; i++) {
            models.add(new Model(i + ""));
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.recycle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);

        ModelAdapter adapter = new ModelAdapter(models);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }

}
