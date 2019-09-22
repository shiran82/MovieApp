package com.example.movieapp.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie_offers_table")
public class MovieOffer {

   @PrimaryKey
   @NonNull
   private String id;

   private String title;

   private String subTitle;

   private String price;

   public MovieOffer(@NonNull String id) {this.id = id;}

   @NonNull
   public String getId() {
      return id;
   }

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

   public String getPrice() {
      return price;
   }

   public void setPrice(String price) {
      this.price = price;
   }
}