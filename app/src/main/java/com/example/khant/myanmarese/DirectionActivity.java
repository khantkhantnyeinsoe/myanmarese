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

public class DirectionActivity extends AppCompatActivity implements WordAdapter.WordItemClickListener {
    RecyclerView directionRecycler;
    WordAdapter wordAdapter;
    ArrayList<Word> dirWord=new ArrayList<Word>();
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
        setContentView(R.layout.activity_direction);
        directionRecycler=(RecyclerView)findViewById(R.id.directionRecycler);
        directionRecycler.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        directionRecycler.setLayoutManager(manager);
        Word dir1 = new Word(getString(R.string.dir_1_english),getString(R.string.dir_1_myanmar),R.raw.phrase_go,R.color.direction_cat);
        Word dir2 = new Word(getString(R.string.dir_2_english),getString(R.string.dir_2_myanmar),R.raw.phrase_where_is,R.color.direction_cat);
        Word dir3 = new Word(getString(R.string.dir_3_english),getString(R.string.dir_3_myanmar),R.raw.phrase_left,R.color.direction_cat);
        Word dir4 = new Word(getString(R.string.dir_4_english),getString(R.string.dir_4_myanmar),R.raw.turn_right,R.color.direction_cat);
        Word dir5 = new Word(getString(R.string.dir_5_english),getString(R.string.dir_5_myanmar),R.raw.phrase_straight,R.color.direction_cat);
        Word dir6 = new Word(getString(R.string.dir_6_english),getString(R.string.dir_6_myanmar),R.raw.phrase_stop_here,R.color.direction_cat);
        Word dir7 = new Word(getString(R.string.dir_7_english),getString(R.string.dir_7_myanmar),R.raw.phrase_slow,R.color.direction_cat);
        Word dir8 = new Word(getString(R.string.dir_8_english),getString(R.string.dir_8_myanmar),R.raw.phrase_becareful,R.color.direction_cat);
        Word dir9 = new Word(getString(R.string.dir_9_english),getString(R.string.dir_9_myanmar),R.raw.phrase_driveslowly,R.color.direction_cat);
        Word dir10 = new Word(getString(R.string.dir_10_english),getString(R.string.dir_10_myanmar),R.raw.phrase_turn_back,R.color.direction_cat);
        Word dir11 = new Word(getString(R.string.dir_11_english),getString(R.string.dir_11_myanmar),R.raw.phrase_how_much,R.color.direction_cat);
        Word dir12 = new Word(getString(R.string.dir_12_english),getString(R.string.dir_12_myanmar),R.raw.phrase_keep_the_change,R.color.direction_cat);
        Word dir13 = new Word(getString(R.string.dir_13_english),getString(R.string.dir_13_myanmar),R.raw.phrase_whichway,R.color.direction_cat);
        Word dir14 = new Word(getString(R.string.dir_14_english),getString(R.string.dir_14_myanmar),R.raw.phrase_far,R.color.direction_cat);

        dirWord.add(dir1);
        dirWord.add(dir2);
        dirWord.add(dir3);
        dirWord.add(dir4);
        dirWord.add(dir5);
        dirWord.add(dir6);
        dirWord.add(dir7);
        dirWord.add(dir8);
        dirWord.add(dir9);
        dirWord.add(dir10);
        dirWord.add(dir11);
        dirWord.add(dir12);
        dirWord.add(dir13);
        dirWord.add(dir14);
        wordAdapter=new WordAdapter(dirWord,this);
        directionRecycler.setAdapter(wordAdapter);
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
        mediaPlayer = MediaPlayer.create(DirectionActivity.this,itemClicked.getmAudioResourceId());
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(mCompletionListener);
    }
}
