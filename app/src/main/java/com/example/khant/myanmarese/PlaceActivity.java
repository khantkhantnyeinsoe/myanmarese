package com.example.khant.myanmarese;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import adapter.WordAdapter;
import data.Word;

public class PlaceActivity extends AppCompatActivity implements WordAdapter.WordItemClickListener {
    RecyclerView placeRecycler;
    WordAdapter wordAdapter;
    ArrayList<Word> placeWord=new ArrayList<Word>();
    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Log.d("release:","released..");
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        placeRecycler=(RecyclerView)findViewById(R.id.placeRecycler);
        placeRecycler.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        placeRecycler.setLayoutManager(manager);
        Word place1 = new Word(getString(R.string.place_1_english),getString(R.string.place_1_myanmar),R.drawable.airport_icon,R.raw.place_airport,R.color.place_cat);
        Word place2 = new Word(getString(R.string.place_2_english),getString(R.string.place_2_myanmar),R.drawable.bustop_icon,R.raw.place_bustop,R.color.place_cat);
        Word place3 = new Word(getString(R.string.place_3_english),getString(R.string.place_3_myanmar),R.drawable.station_icon,R.raw.place_station,R.color.place_cat);
        Word place4 = new Word(getString(R.string.place_4_english),getString(R.string.place_4_myanmar),R.drawable.hotel_icon,R.raw.place_hotel,R.color.place_cat);
        Word place5 = new Word(getString(R.string.place_5_english),getString(R.string.place_5_myanmar),R.drawable.embassy_icon,R.raw.place_embassy,R.color.place_cat);
        Word place6 = new Word(getString(R.string.place_6_english),getString(R.string.place_6_myanmar),R.drawable.hospital_icon,R.raw.place_hospital,R.color.place_cat);
        Word place7 = new Word(getString(R.string.place_7_english),getString(R.string.place_7_myanmar),R.drawable.clinic_icon,R.raw.place_clinic,R.color.place_cat);
        Word place8 = new Word(getString(R.string.place_8_english),getString(R.string.place_8_myanmar),R.drawable.police_icon,R.raw.place_police,R.color.place_cat);
        Word place9 = new Word(getString(R.string.place_9_english),getString(R.string.place_9_myanmar),R.drawable.post_icon,R.raw.place_post,R.color.place_cat);
        Word place10 = new Word(getString(R.string.place_10_english),getString(R.string.place_10_myanmar),R.drawable.market_icon,R.raw.place_market,R.color.place_cat);
        Word place11 = new Word(getString(R.string.place_11_english),getString(R.string.place_11_myanmar),R.drawable.river_icon,R.raw.place_river,R.color.place_cat);
        Word place12 = new Word(getString(R.string.place_12_english),getString(R.string.place_12_myanmar),R.drawable.guest_icon,R.raw.place_guest,R.color.place_cat);
        Word place13 = new Word(getString(R.string.place_13_english),getString(R.string.place_13_myanmar),R.drawable.restaurant_icon,R.raw.place_restaurant,R.color.place_cat);
        Word place14 = new Word(getString(R.string.place_14_english),getString(R.string.place_14_myanmar),R.drawable.pagoda_icon,R.raw.place_pagoda,R.color.place_cat);

        placeWord.add(place1);
        placeWord.add(place2);
        placeWord.add(place3);
        placeWord.add(place4);
        placeWord.add(place5);
        placeWord.add(place6);
        placeWord.add(place7);
        placeWord.add(place8);
        placeWord.add(place9);
        placeWord.add(place10);
        placeWord.add(place11);
        placeWord.add(place12);
        placeWord.add(place13);
        placeWord.add(place14);
        wordAdapter=new WordAdapter(placeWord,this);
        placeRecycler.setAdapter(wordAdapter);
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    /*Clean up media player by releasing its resources*/
    private void releaseMediaPlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onItemClick(Word itemClicked) {
        int audio = itemClicked.getmAudioResourceId();
        Log.d("click : ", String.valueOf(audio));
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(PlaceActivity.this,itemClicked.getmAudioResourceId());
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(mCompletionListener);
    }
}
