package com.example.maneeshsagar.interntask;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.widget.Toast.*;

/**
 * Created by maneeshsagar on 21-04-2018.
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ListViewHolder>{


    ListItemClickListener listItemClickListener;
 List<MovieListItem> list;
 Context context;

    public ListViewAdapter(List<MovieListItem> list, Context context,ListItemClickListener listener) {
        this.list = list;
        this.context = context;
        listItemClickListener=listener;
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


    // Interface

    public interface ListItemClickListener{
        void onListItemCLick(int position);
    }












    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
       // holder.sr_no.setText(String.valueOf(position));

        MovieListItem movieListItem=list.get(position);

    //    holder.releasedate.setText(String.valueOf(movieListItem.getRelase_date()));

        Picasso.with(context)
                .load(movieListItem.getImageurl())
                 .into(holder.poster);
        holder.title.setText(movieListItem.getMovie_name());

    }

    @Override
    public int getItemCount() {


        return list.size();
    }










    // ViewHolder to hold the data which is to be displayed on the screen

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView title;
     //   TextView releasedate;
        ImageView poster;

        public ListViewHolder(View itemView) {
            super(itemView);

            title=(TextView)itemView.findViewById(R.id.title);
          //  releasedate=(TextView)itemView.findViewById(R.id.release_date);
            poster=(ImageView)itemView.findViewById(R.id.poster);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            System.out.println(getAdapterPosition());
            listItemClickListener.onListItemCLick(getAdapterPosition());

        }
    }

}
