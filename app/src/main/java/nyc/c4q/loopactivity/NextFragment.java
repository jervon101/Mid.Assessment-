package nyc.c4q.loopactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextFragment extends Fragment  {
    View view;
    TextView text;

    public NextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_next, container, false);
        text = (TextView) view.findViewById(R.id.nexttext);

        Bundle bundle = getArguments();

        String sometext = bundle.getString("val");

        text.setText(sometext);


        return view;
    }

}
