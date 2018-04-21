package com.example.maneeshsagar.interntask;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by maneeshsagar on 21-04-2018.
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ListViewHolder>{




    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }










    // ViewHolder to hold the data which is to be displayed on the screen

    class ListViewHolder extends RecyclerView.ViewHolder{


        TextView movieName;
        TextView sr_no;

        public ListViewHolder(View itemView) {
            super(itemView);

            movieName=(TextView)itemView.findViewById(R.id.movie_name);
            sr_no=(TextView)itemView.findViewById(R.id.sr_no);
        }
    }

}
