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

public class ColorsActivity extends AppCompatActivity implements WordAdapter.WordItemClickListener {
    ArrayList<Word> wordData = new ArrayList<Word>();
    WordAdapter wordAdapter;
    RecyclerView colorRecycler;
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
        setContentView(R.layout.activity_colors);

        colorRecycler = (RecyclerView) findViewById(R.id.color_recycler);
        colorRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        colorRecycler.setLayoutManager(linearLayoutManager);

        Word word1 = new Word(getString(R.string.color_red_default),getString(R.string.color_red_myanmar),R.drawable.color_red,R.raw.color_red,R.color.category_color);
        Word word2 = new Word(getString(R.string.color_mustard_yellow_default),getString(R.string.color_mustard_yellow_myanmar),R.drawable.color_mustard_yellow,R.raw.color_light_yellow,R.color.category_color);
        Word word3 = new Word(getString(R.string.color_dusty_yellow_default),getString(R.string.color_dusty_yellow_myanmar),R.drawable.color_dusty_yellow,R.raw.color_dark_yellow,R.color.category_color);
        Word word4 = new Word(getString(R.string.color_green_default),getString(R.string.color_green_myanmar),R.drawable.color_green,R.raw.color_green,R.color.category_color);
        Word word5 = new Word(getString(R.string.color_brown_default),getString(R.string.color_brown_myanmar),R.drawable.color_brown,R.raw.color_brown,R.color.category_color);
        Word word6 = new Word(getString(R.string.color_gray_default),getString(R.string.color_gray_myanmar),R.drawable.color_gray,R.raw.color_gray,R.color.category_color);
        Word word7 = new Word(getString(R.string.color_black_default),getString(R.string.color_black_myanmar),R.drawable.color_black,R.raw.color_black,R.color.category_color);
        Word word8 = new Word(getString(R.string.color_white_default),getString(R.string.color_white_myanmar),R.drawable.color_white,R.raw.color_white,R.color.category_color);


        wordData.add(word1);
        wordData.add(word2);
        wordData.add(word3);
        wordData.add(word4);
        wordData.add(word5);
        wordData.add(word6);
        wordData.add(word7);
        wordData.add(word8);

        wordAdapter = new WordAdapter(wordData,this);

        colorRecycler.setAdapter(wordAdapter);
    }
    @Override
    public void onItemClick(Word itemClicked) {
        int audio = itemClicked.getmAudioResourceId();
        Log.d("click : ", String.valueOf(audio));

        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(ColorsActivity.this,itemClicked.getmAudioResourceId());
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(mCompletionListener);
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
}
