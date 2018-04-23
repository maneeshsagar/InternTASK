package com.example.maneeshsagar.interntask;

import java.io.Serializable;

/**
 * Created by maneeshsagar on 22-04-2018.
 */

public class MovieListItem implements Serializable{
//"https://image.tmdb.org/t/p/w45"
    private String title;
    private String relase_date;
    private String imageurl;
    private String rootimg="https://image.tmdb.org/t/p/w45";;
    private String backdroproot="https://image.tmdb.org/t/p/w1280";
    private String backDropUrl;
    private String description;
    private String popularity;



    //constructor
    public MovieListItem(String title, String relase_date,String imageurl,String backDropUrl,String description,String popularity) {
        this.title = title;
        this.relase_date=relase_date;
        this.imageurl=rootimg+imageurl;
        this.backDropUrl=backdroproot+backDropUrl;
        this.description=description;
        this.popularity=popularity;


    }



// Getter and Setter for the Backdrop images
    public String getBackDropUrl() {
        return backDropUrl;
    }

    public void setBackDropUrl(String backDropUrl) {
        this.backDropUrl = backDropUrl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }


    // Getter Setter for Realease date

    public String getRelase_date() {
        return relase_date;
    }

    public void setNo(String relase_date) {
        this.relase_date = relase_date;
    }




    // Getter Setter for Movie Name
    public String getMovie_name() {
        return title;
    }

    public void setMovie_name(String movie_name) {
        this.title = title;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }



}
