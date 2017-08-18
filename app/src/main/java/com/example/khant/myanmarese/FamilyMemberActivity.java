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

public class FamilyMemberActivity extends AppCompatActivity implements WordAdapter.WordItemClickListener {
    ArrayList<Word> wordData = new ArrayList<Word>();
    WordAdapter wordAdapter;
    RecyclerView familyRecycler;
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
        setContentView(R.layout.activity_family_member);

        familyRecycler = (RecyclerView) findViewById(R.id.family_recycler);
        familyRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        familyRecycler.setLayoutManager(linearLayoutManager);

        Word word1 = new Word(getString(R.string.family_father_default),getString(R.string.family_father_myanmar),R.drawable.family_father,R.raw.family_member_father,R.color.category_familymember);
        Word word2 = new Word(getString(R.string.family_mother_default),getString(R.string.family_mother_myanmar),R.drawable.family_mother,R.raw.family_member_mother,R.color.category_familymember);
        Word word3 = new Word(getString(R.string.family_son_default),getString(R.string.family_son_myanmar),R.drawable.family_son,R.raw.family_member_son,R.color.category_familymember);
        Word word4 = new Word(getString(R.string.family_daughter_default),getString(R.string.family_daughter_myanmar),R.drawable.family_daughter,R.raw.family_member_daughter,R.color.category_familymember);
        Word word5 = new Word(getString(R.string.family_older_brother_default),getString(R.string.family_older_brother_myanmar),R.drawable.family_older_brother,R.raw.family_member_brother,R.color.category_familymember);
        Word word6 = new Word(getString(R.string.family_younger_brother_default),getString(R.string.family_younger_brother_myanmar),R.drawable.family_younger_brother,R.raw.family_member_younger_brother,R.color.category_familymember);
        Word word7 = new Word(getString(R.string.family_older_sister_default),getString(R.string.family_older_sister_myanmar),R.drawable.family_older_sister,R.raw.family_member_sister,R.color.category_familymember);
        Word word8 = new Word(getString(R.string.family_younger_sister_default),getString(R.string.family_younger_sister_myanmar),R.drawable.family_younger_sister,R.raw.family_member_younger_sister,R.color.category_familymember);
        Word word9 = new Word(getString(R.string.family_grandmother_default),getString(R.string.family_grandmother_myanmar),R.drawable.family_grandmother,R.raw.family_member_grandmother,R.color.category_familymember);
        Word word10 = new Word(getString(R.string.family_grandfather_default),getString(R.string.family_grandfather_myanmar),R.drawable.family_grandfather,R.raw.family_member_grandfather,R.color.category_familymember);
        Word word11 = new Word(getString(R.string.family_uncle_default),getString(R.string.family_uncle_myanmar),R.drawable.family_uncle,R.raw.family_member_uncle,R.color.category_familymember);
        Word word12 = new Word(getString(R.string.family_aunty_default),getString(R.string.family_aunty_myanmar),R.drawable.family_aunty,R.raw.family_member_aunty,R.color.category_familymember);


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
        wordData.add(word11);
        wordData.add(word12);
        wordAdapter = new WordAdapter(wordData,this);

        familyRecycler.setAdapter(wordAdapter);
    }
    @Override
    public void onItemClick(Word itemClicked) {
        int audio = itemClicked.getmAudioResourceId();
        Log.d("click : ", String.valueOf(audio));

        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(FamilyMemberActivity.this,itemClicked.getmAudioResourceId());
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
