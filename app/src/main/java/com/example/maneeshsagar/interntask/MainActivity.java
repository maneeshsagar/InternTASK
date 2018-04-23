package com.example.maneeshsagar.interntask;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.maneeshsagar.interntask.R.id.comdey;

public class MainActivity extends AppCompatActivity  implements ListViewAdapter.ListItemClickListener{


    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<MovieListItem> listItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Addtion of toolbar
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //setting toolbar title
        getSupportActionBar().setTitle("InternTask");

        //giving a refernce to ReccyclerView
        recyclerView=(RecyclerView)findViewById(R.id.RecylistHolderlistHolder);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        loadRecyclerviewPopular();
    }

    //inflating menu to Mainactivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    //Action is setting to the Menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(this,"Menu",Toast.LENGTH_SHORT).show();
        int d=item.getItemId();
        if(d== R.id.animation)
        {
            Toast.makeText(this,"Animation",Toast.LENGTH_SHORT).show();
            loadRecyclerviewAnimation();
        }
     else    if(d== R.id.comdey)
        {
            Toast.makeText(this,"Comedy",Toast.LENGTH_SHORT).show();
            loadRecyclerviewComedy();
        }
     else    if(d== R.id.horror)
        {
            Toast.makeText(this,"Horror",Toast.LENGTH_SHORT).show();
            loadRecyclerviewHorror();
        }

        return super.onOptionsItemSelected(item);
    }

    final String URL_DATA="https://api.themoviedb.org/3/discover/movie?api_key=31892de385224ec9bc9710ce750ef7aa&sort_by=popularity.desc";
    final String URL_ANIMATION="https://api.themoviedb.org/3/discover/movie?api_key=31892de385224ec9bc9710ce750ef7aa&sort_by=popularity.desc&with_genres=16";
    final String URL_COMEDY="https://api.themoviedb.org/3/discover/movie?api_key=31892de385224ec9bc9710ce750ef7aa&sort_by=popularity.desc&with_genres=35";
    final String URL_HORROR="https://api.themoviedb.org/3/discover/movie?api_key=31892de385224ec9bc9710ce750ef7aa&sort_by=popularity.desc&with_genres=27";
    private void loadRecyclerviewPopular() {

        listItems=new ArrayList<>();
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading Data");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       progressDialog.dismiss();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray results=jsonObject.getJSONArray("results");

                            for(int i=0;i<results.length();i++)
                            {
                                JSONObject o=results.getJSONObject(i);
                                MovieListItem item=new MovieListItem(
                                        o.getString("title"),o.getString("release_date"),
                                        o.getString("backdrop_path"),o.getString("backdrop_path"),
                                        o.getString("overview"),o.getString("popularity")
                                );
                                listItems.add(item);
                            }
                          adapter= new ListViewAdapter(listItems,getApplicationContext(),MainActivity.this);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);

    }

    private void loadRecyclerviewAnimation() {
          listItems.clear();
        listItems=new ArrayList<>();
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading Data");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_ANIMATION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray results=jsonObject.getJSONArray("results");

                            for(int i=0;i<results.length();i++)
                            {
                                JSONObject o=results.getJSONObject(i);
                                MovieListItem item=new MovieListItem(
                                        o.getString("title"),o.getString("release_date"),
                                        o.getString("poster_path"),o.getString("backdrop_path"),
                                        o.getString("overview"),o.getString("popularity")
                                );
                                listItems.add(item);
                            }
                            adapter= new ListViewAdapter(listItems,getApplicationContext(),MainActivity.this);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);

    }

    private void loadRecyclerviewComedy() {
        listItems.clear();
        listItems=new ArrayList<>();
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading Data");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_COMEDY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray results=jsonObject.getJSONArray("results");

                            for(int i=0;i<results.length();i++)
                            {
                                JSONObject o=results.getJSONObject(i);
                                MovieListItem item=new MovieListItem(
                                        o.getString("title"),o.getString("release_date"),
                                        o.getString("poster_path"),o.getString("backdrop_path"),
                                        o.getString("overview"),o.getString("popularity")
                                );
                                listItems.add(item);
                            }
                            adapter= new ListViewAdapter(listItems,getApplicationContext(),MainActivity.this);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);

    }

    private void loadRecyclerviewHorror() {
        listItems.clear();
        listItems=new ArrayList<>();
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading Data");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_HORROR,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray results=jsonObject.getJSONArray("results");

                            for(int i=0;i<results.length();i++)
                            {
                                JSONObject o=results.getJSONObject(i);
                                MovieListItem item=new MovieListItem(
                                        o.getString("title"),o.getString("release_date"),
                                        o.getString("poster_path"),o.getString("backdrop_path"),
                                        o.getString("overview"),o.getString("popularity")
                                );
                                listItems.add(item);
                            }
                            adapter= new ListViewAdapter(listItems,getApplicationContext(),MainActivity.this);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);

    }




    @Override
    public void onListItemCLick(int position) {
        Intent intent=new Intent(this,Detail.class);
       // Bundle b=new Bundle();

        intent.putExtra("Item",listItems.get(position));
        startActivity(intent);

    }


}
