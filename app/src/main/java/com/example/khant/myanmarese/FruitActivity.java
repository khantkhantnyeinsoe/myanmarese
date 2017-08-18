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

public class FruitActivity extends AppCompatActivity implements WordAdapter.WordItemClickListener {
    ArrayList<Word> wordData = new ArrayList<Word>();
    WordAdapter wordAdapter;
    RecyclerView fruitRecycler;
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
        setContentView(R.layout.activity_fruit);

        fruitRecycler = (RecyclerView) findViewById(R.id.fruit_recycler);
        fruitRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        fruitRecycler.setLayoutManager(linearLayoutManager);

        Word word1 = new Word(getString(R.string.apple_default),getString(R.string.apple_myanmar),R.drawable.apple,R.raw.fruit_apple,R.color.category_fruit);
        Word word2 = new Word(getString(R.string.avocado_default),getString(R.string.avocado_myanmar),R.drawable.avocado,R.raw.fruit_avocado,R.color.category_fruit);
        Word word3 = new Word(getString(R.string.banana_default),getString(R.string.banana_myanmar),R.drawable.banana,R.raw.fruit_banana,R.color.category_fruit);
        Word word4 = new Word(getString(R.string.coconut_default),getString(R.string.coconut_myanmar),R.drawable.coconut,R.raw.fruit_coconut,R.color.category_fruit);
        Word word5 = new Word(getString(R.string.grape_default),getString(R.string.grape_myanmar),R.drawable.grape,R.raw.fruit_grapes,R.color.category_fruit);
        Word word6 = new Word(getString(R.string.mango_default),getString(R.string.mango_myanmar),R.drawable.mango,R.raw.fruit_mango,R.color.category_fruit);
        Word word7 = new Word(getString(R.string.orange_default),getString(R.string.orange_myanmar),R.drawable.orange,R.raw.fruit_orange,R.color.category_fruit);
        Word word8 = new Word(getString(R.string.papaya_default),getString(R.string.papaya_myanmar),R.drawable.papaya,R.raw.fruit_papaya,R.color.category_fruit);
        Word word9 = new Word(getString(R.string.peach_default),getString(R.string.peach_myanmar),R.drawable.peach,R.raw.fruit_peach,R.color.category_fruit);
        Word word10 = new Word(getString(R.string.watermelon_default),getString(R.string.watermelon_myanmar),R.drawable.watermelon,R.raw.fruit_watermelon,R.color.category_fruit);





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

        fruitRecycler.setAdapter(wordAdapter);
    }
    @Override
    public void onItemClick(Word itemClicked) {
        int audio = itemClicked.getmAudioResourceId();
        Log.d("click : ", String.valueOf(audio));

        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(FruitActivity.this,itemClicked.getmAudioResourceId());
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
