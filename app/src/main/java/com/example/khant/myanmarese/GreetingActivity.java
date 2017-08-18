package com.example.khant.myanmarese;

import android.media.MediaPlayer;
import android.support.constraint.solver.ArrayLinkedVariables;
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

public class GreetingActivity extends AppCompatActivity implements WordAdapter.WordItemClickListener{
    RecyclerView greetingRecycler;
    WordAdapter wordAdapter;
    ArrayList<Word> greetWord=new ArrayList<Word>();
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
        setContentView(R.layout.activity_greeting);
        greetingRecycler=(RecyclerView)findViewById(R.id.greetingRecycler);
        greetingRecycler.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        greetingRecycler.setLayoutManager(manager);
        Word greet1 = new Word(getString(R.string.greet_hello_english),getString(R.string.greet_hello_myanmar),R.raw.phrase_hello,R.color.greeting_cat);
        Word greet2 = new Word(getString(R.string.greet_morning_english),getString(R.string.greet_morning_myanmar),R.raw.phrase_goodmorning,R.color.greeting_cat);
        Word greet3 = new Word(getString(R.string.greet_afternoon_english),getString(R.string.greet_afternoon_myanmar),R.raw.phrase_goodafternoon,R.color.greeting_cat);
        Word greet4 = new Word(getString(R.string.greet_evening_english),getString(R.string.greet_evening_myanmar),R.raw.phrase_goodevening,R.color.greeting_cat);
        Word greet5 = new Word(getString(R.string.greet_night_english),getString(R.string.greet_night_myanmar),R.raw.phrase_goodnight,R.color.greeting_cat);
        Word greet6 = new Word(getString(R.string.greet_1_english),getString(R.string.greet_1_myanmar),R.raw.phrase_how_are_you,R.color.greeting_cat);
        Word greet7 = new Word(getString(R.string.greet_2_english),getString(R.string.greet_2_myanmar),R.raw.phrase_good,R.color.greeting_cat);
        Word greet8 = new Word(getString(R.string.greet_3_english),getString(R.string.greet_3_myanmar),R.raw.phrase_not_well,R.color.greeting_cat);
        Word greet9 = new Word(getString(R.string.greet_4_english),getString(R.string.greet_4_myanmar),R.raw.phrase_whatisyourname,R.color.greeting_cat);
        Word greet10 = new Word(getString(R.string.greet_5_english),getString(R.string.greet_5_myanmar),R.raw.phrase_mynameis,R.color.greeting_cat);
        Word greet11 = new Word(getString(R.string.greet_6_english),getString(R.string.greet_6_myanmar),R.raw.phrase_seeyou,R.color.greeting_cat);
        Word greet12 = new Word(getString(R.string.greet_7_english),getString(R.string.greet_7_myanmar),R.raw.phrase_bye,R.color.greeting_cat);
        Word greet13= new Word(getString(R.string.greet_8_english),getString(R.string.greet_8_myanmar),R.raw.phrase_nicetomeetyou,R.color.greeting_cat);
        Word greet14 = new Word(getString(R.string.greet_9_english),getString(R.string.greet_9_myanmar),R.raw.phrase_goodluck,R.color.greeting_cat);
        Word greet15 = new Word(getString(R.string.greet_10_english),getString(R.string.greet_10_myanmar),R.raw.phrase_takecare,R.color.greeting_cat);
        Word greet16 = new Word(getString(R.string.greet_11_english),getString(R.string.greet_11_myanmar),R.raw.phrase_longtimenosee,R.color.greeting_cat);
        Word greet17 = new Word(getString(R.string.greet_12_english),getString(R.string.greet_12_myanmar),R.raw.phrase_can_you_speak_english,R.color.greeting_cat);
        Word greet18= new Word(getString(R.string.greet_13_english),getString(R.string.greet_13_myanmar),R.raw.phrase_wherefrom,R.color.greeting_cat);
        Word greet19 = new Word(getString(R.string.greet_14_english),getString(R.string.greet_14_myanmar),R.raw.phrase_howoldareyou,R.color.greeting_cat);
        Word greet20 = new Word(getString(R.string.greet_15_english),getString(R.string.greet_15_myanmar),R.raw.phrase_year_old,R.color.greeting_cat);
        Word greet21 = new Word(getString(R.string.greet_16_english),getString(R.string.greet_16_myanmar),R.raw.phrase_thankyou,R.color.greeting_cat);
        Word greet22=new Word(getString(R.string.greet_17_english),getString(R.string.greet_17_myanmar),R.raw.phrase_iloveyou,R.color.greeting_cat);
        Word greet23 = new Word(getString(R.string.greet_18_english),getString(R.string.greet_18_myanmar),R.raw.phrase_getwellsoon,R.color.greeting_cat);
        Word greet24=new Word(getString(R.string.greet_19_english),getString(R.string.greet_19_myanmar),R.raw.phrase_happybirthday,R.color.greeting_cat);

        greetWord.add(greet1);
        greetWord.add(greet2);
        greetWord.add(greet3);
        greetWord.add(greet4);
        greetWord.add(greet5);
        greetWord.add(greet6);
        greetWord.add(greet7);
        greetWord.add(greet8);
        greetWord.add(greet9);
        greetWord.add(greet10);
        greetWord.add(greet11);
        greetWord.add(greet12);
        greetWord.add(greet13);
        greetWord.add(greet14);
        greetWord.add(greet15);
        greetWord.add(greet16);
        greetWord.add(greet17);
        greetWord.add(greet18);
        greetWord.add(greet19);
        greetWord.add(greet20);
        greetWord.add(greet21);
        greetWord.add(greet22);
        greetWord.add(greet23);
        greetWord.add(greet24);
        wordAdapter=new WordAdapter(greetWord,this);
        greetingRecycler.setAdapter(wordAdapter);
    }


    @Override
    public void onItemClick(Word itemClicked) {
        int audio = itemClicked.getmAudioResourceId();
        Log.d("click : ", String.valueOf(audio));

        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(GreetingActivity.this,itemClicked.getmAudioResourceId());
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
