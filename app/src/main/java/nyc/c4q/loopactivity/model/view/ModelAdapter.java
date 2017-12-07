package nyc.c4q.loopactivity.model.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.SupportActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;


import nyc.c4q.loopactivity.NextFragment;
import nyc.c4q.loopactivity.R;

/**
 * Created by jervon.arnoldd on 12/6/17.
 */

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelHOlder> {
    List<Model> list;

    public ModelAdapter(List<Model> list) {
        this.list = list;


    }

    @Override
    public ModelHOlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

        return new ModelHOlder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(ModelHOlder holder, int position) {
        Model model = list.get(position);
        holder.onBind(model);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ModelHOlder extends RecyclerView.ViewHolder {
        TextView view;
        int hello;
        Context context;
//        FragmentManager fragmentManager;
//        ModelHOlder myActivity;

        public ModelHOlder(View itemView, Context context) {
            super(itemView);
            view = (TextView) itemView.findViewById(R.id.itemview);
            context = itemView.getContext();

            FragmentManager fragmentManager = context.getApplicationContext();

            FragmentTransaction transaction = fragmentManager.beginTransaction();


        }


        public void onBind(Model model) {
            view.setText(model.getNum());
            hello = Integer.parseInt(model.getNum()) * 10;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    NextFragment frag = new NextFragment();

                    FragmentManager fragmentManager = context.get;

                    FragmentTransaction transaction = fragmentManager.beginTransaction();

                    Bundle bundle = new Bundle();
                    bundle.putString("val", hello + "");
                    frag.setArguments(bundle);

                    transaction.replace(R.id.bigfrag, frag);
                    transaction.addToBackStack("next");
                    transaction.commit();
                }
            });


        }


    }
}
