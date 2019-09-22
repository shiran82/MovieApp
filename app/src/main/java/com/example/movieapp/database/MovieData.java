package com.example.movieapp.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie_data_table")
public class MovieData {

   @PrimaryKey
   @NonNull
   private String id;

   private String title;

   private String subTitle;

   public MovieData(@NonNull String id) {this.id = id;}

   public String getId(){return this.id;}

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