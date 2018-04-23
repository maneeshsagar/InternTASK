package com.example.maneeshsagar.interntask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class Detail extends AppCompatActivity {

    private ImageView backdrop;
    private TextView title;
    private TextView description;
    MovieListItem item;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        backdrop=(ImageView)findViewById(R.id.backdrop);
        title=(TextView)findViewById(R.id.title_detail);
        description=(TextView)findViewById(R.id.description_detail);
      //  linearLayout=(LinearLayout)findViewById(R.id.background);

        item= (MovieListItem) getIntent().getSerializableExtra("Item");




        Picasso.with(this)
                .load(item.getBackDropUrl())
                .into(backdrop);




        title.setText(item.getMovie_name());
         description.setText(item.getDescription());

    }
}
