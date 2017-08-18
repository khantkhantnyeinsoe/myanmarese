package com.example.khant.myanmarese;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import adapter.CategoryAdapter;
import adapter.WordAdapter;
import data.Category;
import data.Word;

public class EatingOutActivity extends AppCompatActivity implements WordAdapter.WordItemClickListener {
    RecyclerView eatingoutRecycler;
    WordAdapter wordAdapter;
    ArrayList<Word> eatingWord=new ArrayList<Word>();
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
        setContentView(R.layout.activity_eating_out);
        eatingoutRecycler=(RecyclerView)findViewById(R.id.eatingoutRecycler);
        eatingoutRecycler.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        eatingoutRecycler.setLayoutManager(manager);
        Word eating1=new Word(getString(R.string.con_27_english),getString(R.string.con_27_myanmar),R.raw.phrase_nospicy,R.color.category_eatingout);
        Word eating2=new Word(getString(R.string.con_35_english),getString(R.string.con_35_myanmar),R.raw.phrase_hungry,R.color.category_eatingout);
        Word eating3=new Word(getString(R.string.con_36_english),getString(R.string.con_36_myanmar),R.raw.phrase_are_you_hungry,R.color.category_eatingout);
        Word eating4=new Word(getString(R.string.con_37_english),getString(R.string.con_37_myanmar),R.raw.phrase_eat,R.color.category_eatingout);
        Word eating5=new Word(getString(R.string.con_38_english),getString(R.string.con_38_myanmar),R.raw.phrase_how_was_the_food,R.color.category_eatingout);
        Word eating6=new Word(getString(R.string.con_39_english),getString(R.string.con_39_myanmar),R.raw.phrase_delicious,R.color.category_eatingout);
        Word eating7=new Word(getString(R.string.con_40_english),getString(R.string.con_40_myanmar),R.raw.phrase_notbad,R.color.category_eatingout);
        Word eating8=new Word(getString(R.string.con_41_english),getString(R.string.con_41_myanmar),R.raw.phrase_good,R.color.category_eatingout);
        Word eating9=new Word(getString(R.string.con_42_english),getString(R.string.con_42_myanmar),R.raw.phrase_eaten_already,R.color.category_eatingout);
        Word eating10=new Word(getString(R.string.con_43_english),getString(R.string.con_43_myanmar),R.raw.phrase_noteat,R.color.category_eatingout);
        Word eating11=new Word(getString(R.string.con_44_english),getString(R.string.con_44_myanmar),R.raw.phrase_alreadyeat,R.color.category_eatingout);
        eatingWord.add(eating1);
        eatingWord.add(eating2);
        eatingWord.add(eating3);
        eatingWord.add(eating4);
        eatingWord.add(eating5);
        eatingWord.add(eating6);
        eatingWord.add(eating7);
        eatingWord.add(eating8);
        eatingWord.add(eating9);
        eatingWord.add(eating10);
        eatingWord.add(eating11);

        wordAdapter=new WordAdapter(eatingWord,this);
        eatingoutRecycler.setAdapter(wordAdapter);
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
        mediaPlayer = MediaPlayer.create(EatingOutActivity.this,itemClicked.getmAudioResourceId());
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(mCompletionListener);
    }
}
