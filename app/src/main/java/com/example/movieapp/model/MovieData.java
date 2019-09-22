package com.example.movieapp.model;

import com.google.gson.annotations.SerializedName;

public class MovieData extends MovieOffer {
    String title;
    @SerializedName("sub_title")
    String subTitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
