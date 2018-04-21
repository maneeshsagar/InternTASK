package com.example.maneeshsagar.interntask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by maneeshsagar on 21-04-2018.
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ListViewHolder>{

 List<MovieListItem> list;
 Context context;

    public ListViewAdapter(List<MovieListItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public int count=0;
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        Context context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View MovieVeiw=layoutInflater.inflate(R.layout.view_design,parent,false);

        ListViewHolder listViewHolder=new ListViewHolder(MovieVeiw);

      //  listViewHolder.movieName.setText("Inside Out");
      //  listViewHolder.sr_no.setText("# "+count++);

        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
       // holder.sr_no.setText(String.valueOf(position));

        MovieListItem movieListItem=list.get(position);
        holder.movieName.setText(movieListItem.getMovie_name());
        holder.sr_no.setText(String.valueOf(movieListItem.getRelase_date()));
    }

    @Override
    public int getItemCount() {


        return list.size();
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
