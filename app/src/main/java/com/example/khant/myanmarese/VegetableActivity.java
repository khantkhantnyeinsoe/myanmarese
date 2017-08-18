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

public class VegetableActivity extends AppCompatActivity implements WordAdapter.WordItemClickListener {
    ArrayList<Word> wordData = new ArrayList<Word>();
    WordAdapter wordAdapter;
    RecyclerView vegetableRecycler;
    MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Log.d("release:", "released..");
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable);

        vegetableRecycler = (RecyclerView) findViewById(R.id.vegetable_recycler);
        vegetableRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        vegetableRecycler.setLayoutManager(linearLayoutManager);

        Word word1 = new Word(getString(R.string.cabbage_default), getString(R.string.cabbage_myanmar), R.drawable.cabbage, R.raw.cabbage, R.color.category_vegetable);
        Word word2 = new Word(getString(R.string.carrot_default), getString(R.string.carrot_myanmar), R.drawable.carrot, R.raw.carrot, R.color.category_vegetable);
        Word word3 = new Word(getString(R.string.cauliflower_default), getString(R.string.cauliflower_myanmar), R.drawable.cauliflower, R.raw.calu, R.color.category_vegetable);
        Word word4 = new Word(getString(R.string.cucumber_default), getString(R.string.cucumber_myanmar), R.drawable.cucumber, R.raw.cucumber, R.color.category_vegetable);
        Word word5 = new Word(getString(R.string.eggplant_default), getString(R.string.eggplant_myanmar), R.drawable.eggplant, R.raw.eggplant, R.color.category_vegetable);
        Word word6 = new Word(getString(R.string.garlic_default), getString(R.string.garlic_myanmar), R.drawable.garlic, R.raw.garlic, R.color.category_vegetable);
        Word word7 = new Word(getString(R.string.onion_default), getString(R.string.onion_myanmar), R.drawable.onion, R.raw.body_onion, R.color.category_vegetable);
        Word word8 = new Word(getString(R.string.pea_default), getString(R.string.pea_myanmar), R.drawable.pea, R.raw.bean, R.color.category_vegetable);
        Word word9 = new Word(getString(R.string.tomato_default), getString(R.string.tomato_myanmar), R.drawable.tomato, R.raw.tomato, R.color.category_vegetable);



        wordData.add(word1);
        wordData.add(word2);
        wordData.add(word3);
        wordData.add(word4);
        wordData.add(word5);
        wordData.add(word6);
        wordData.add(word7);
        wordData.add(word8);
        wordData.add(word9);


        wordAdapter = new WordAdapter(wordData, this);

        vegetableRecycler.setAdapter(wordAdapter);
    }


    @Override
    public void onItemClick(Word itemClicked) {
        int audio = itemClicked.getmAudioResourceId();
        Log.d("click : ", String.valueOf(audio));

        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(VegetableActivity.this, itemClicked.getmAudioResourceId());
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(mCompletionListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /*Clean up media player by releasing its resources*/
    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
