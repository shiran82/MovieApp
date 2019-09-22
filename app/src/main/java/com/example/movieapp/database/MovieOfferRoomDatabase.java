package com.example.movieapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MovieOffer.class, MovieData.class}, version = 4, exportSchema = false)
public abstract class MovieOfferRoomDatabase extends RoomDatabase {

   public abstract MovieOfferDao wordDao();
   private static MovieOfferRoomDatabase INSTANCE;

   public static MovieOfferRoomDatabase getDatabase(final Context context) {
       if (INSTANCE == null) {
           synchronized (MovieOfferRoomDatabase.class) {
               if (INSTANCE == null) {
                   INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                           MovieOfferRoomDatabase.class, "movie_offers_database")
                             // Wipes and rebuilds instead of migrating 
                             // if no Migration object.
                            // Migration is not part of this practical.
                           .fallbackToDestructiveMigration()
                           .build();                
               }
           }
       }
       return INSTANCE;
   }
}