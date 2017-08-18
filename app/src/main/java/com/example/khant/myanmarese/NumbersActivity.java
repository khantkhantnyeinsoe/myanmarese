package com.example.khant.myanmarese;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.WordAdapter;
import data.Word;

public class NumbersActivity extends AppCompatActivity implements WordAdapter.WordItemClickListener {
    ArrayList<Word> wordData = new ArrayList<Word>();
    WordAdapter wordAdapter;
    RecyclerView numberRecycler;
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
        setContentView(R.layout.activity_numbers);


        numberRecycler = (RecyclerView) findViewById(R.id.numbar_recycler);
        numberRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        numberRecycler.setLayoutManager(linearLayoutManager);

        Word word1 = new Word(getString(R.string.number_one_default),getString(R.string.number_one_myanmar),R.drawable.number_one,R.raw.number_one,R.color.category_number);
        Word word2 = new Word(getString(R.string.number_two_default),getString(R.string.number_two_myanmar),R.drawable.number_two,R.raw.number_two,R.color.category_number);
        Word word3 = new Word(getString(R.string.number_three_default),getString(R.string.number_three_myanmar),R.drawable.number_three,R.raw.number_three,R.color.category_number);
        Word word4 = new Word(getString(R.string.number_four_default),getString(R.string.number_four_myanmar),R.drawable.number_four,R.raw.number_four,R.color.category_number);
        Word word5 = new Word(getString(R.string.number_five_default),getString(R.string.number_five_myanmar),R.drawable.number_five,R.raw.number_five,R.color.category_number);
        Word word6 = new Word(getString(R.string.number_six_default),getString(R.string.number_six_myanmar),R.drawable.number_six,R.raw.number_six,R.color.category_number);
        Word word7 = new Word(getString(R.string.number_seven_default),getString(R.string.number_seven_myanmar),R.drawable.number_seven,R.raw.number_seven,R.color.category_number);
        Word word8 = new Word(getString(R.string.number_eight_default),getString(R.string.number_eight_myanmar),R.drawable.number_eight,R.raw.number_eight,R.color.category_number);
        Word word9 = new Word(getString(R.string.number_nine_default),getString(R.string.number_nine_myanmar),R.drawable.number_nine,R.raw.number_nine,R.color.category_number);
        Word word10 = new Word(getString(R.string.number_ten_default),getString(R.string.number_ten_myanmar),R.drawable.number_ten,R.raw.number_ten,R.color.category_number);




        wordData.add(word1);
        wordData.add(word2);
        wordData.add(word3);
        wordData.add(word4);
        wordData.add(word5);
        wordData.add(word6);
        wordData.add(word7);
        wordData.add(word8);
        wordData.add(word9);
        wordData.add(word10);



        wordAdapter = new WordAdapter(wordData,this);

        numberRecycler.setAdapter(wordAdapter);

    }

    @Override
    public void onItemClick(Word itemClicked) {
        int audio = itemClicked.getmAudioResourceId();
        Log.d("click : ", String.valueOf(audio));

        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(NumbersActivity.this,itemClicked.getmAudioResourceId());
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
