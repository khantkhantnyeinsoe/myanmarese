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

public class ConversationActivity extends AppCompatActivity implements WordAdapter.WordItemClickListener {
    RecyclerView conservationRecycler;
    WordAdapter wordAdapter;
    ArrayList<Word> conWord=new ArrayList<Word>();
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
        setContentView(R.layout.activity_conversation);
        conservationRecycler=(RecyclerView)findViewById(R.id.conservationRecycler);
        conservationRecycler.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        conservationRecycler.setLayoutManager(manager);
        Word con1 = new Word(getString(R.string.con_1_english),getString(R.string.con_1_myanmar),R.raw.phrase_sorry,R.color.conversation_cat);
        Word con2 = new Word(getString(R.string.con_2_english),getString(R.string.con_2_myanmar),R.raw.phrase_excuseme,R.color.conversation_cat);
        Word con3 = new Word(getString(R.string.con_3_english),getString(R.string.con_3_myanmar),R.raw.phrase_thankyou_somuch,R.color.conversation_cat);
        Word con4 = new Word(getString(R.string.con_4_english),getString(R.string.con_4_myanmar),R.raw.phrase_not_myanmar,R.color.conversation_cat);
        Word con5 = new Word(getString(R.string.con_5_english),getString(R.string.con_5_myanmar),R.raw.phrase_understand,R.color.conversation_cat);
        Word con6 = new Word(getString(R.string.con_6_english),getString(R.string.con_6_myanmar),R.raw.phrase_photo,R.color.conversation_cat);
        Word con7 = new Word(getString(R.string.con_7_english),getString(R.string.con_7_myanmar),R.raw.phrase_phone,R.color.conversation_cat);
        Word con8 = new Word(getString(R.string.con_8_english),getString(R.string.con_8_myanmar),R.raw.phrase_toilet,R.color.conversation_cat);
        Word con9 = new Word(getString(R.string.con_9_english),getString(R.string.con_9_myanmar),R.raw.phrase_how_much,R.color.conversation_cat);
        Word con10 = new Word(getString(R.string.con_10_english),getString(R.string.con_10_myanmar),R.raw.phrase_what_is_this,R.color.conversation_cat);
        Word con11 = new Word(getString(R.string.con_11_english),getString(R.string.con_11_myanmar),R.raw.phrase_expensive,R.color.conversation_cat);
        Word con12 = new Word(getString(R.string.con_12_english),getString(R.string.con_12_myanmar),R.raw.phrase_yes,R.color.conversation_cat);
        Word con13 = new Word(getString(R.string.con_13_english),getString(R.string.con_13_myanmar),R.raw.phrase_yes_female,R.color.conversation_cat);
        Word con14 = new Word(getString(R.string.con_14_english),getString(R.string.con_14_myanmar),R.raw.phrase_no,R.color.conversation_cat);
        Word con15 = new Word(getString(R.string.con_15_english),getString(R.string.con_15_myanmar),R.raw.phrase_really,R.color.conversation_cat);
        Word con16 = new Word(getString(R.string.con_16_english),getString(R.string.con_16_myanmar),R.raw.phrase_impossible,R.color.conversation_cat);
        Word con17 = new Word(getString(R.string.con_17_english),getString(R.string.con_17_myanmar),R.raw.phrase_possible,R.color.conversation_cat);
        Word con18 = new Word(getString(R.string.con_18_english),getString(R.string.con_18_myanmar),R.raw.phrase_help,R.color.conversation_cat);
        Word con19 = new Word(getString(R.string.con_19_english),getString(R.string.con_19_myanmar),R.raw.phrase_beautiful,R.color.conversation_cat);
        Word con20 = new Word(getString(R.string.con_20_english),getString(R.string.con_20_myanmar),R.raw.phrase_want,R.color.conversation_cat);
        Word con21=new Word(getString(R.string.con_21_english),getString(R.string.con_21_myanmar),R.raw.phrase_whocanspeakenglish,R.color.conversation_cat);
        Word con22=new Word(getString(R.string.con_22_english),getString(R.string.con_22_myanmar),R.raw.phrase_what_time,R.color.conversation_cat);
        Word con23=new Word(getString(R.string.con_23_english),getString(R.string.con_23_myanmar),R.raw.phrase_noproblem,R.color.conversation_cat);
        Word con24=new Word(getString(R.string.con_24_english),getString(R.string.con_24_myanmar),R.raw.phrase_donotmind,R.color.conversation_cat);
        Word con25=new Word(getString(R.string.con_25_english),getString(R.string.con_25_myanmar),R.raw.phrase_may_i_go,R.color.conversation_cat);
        Word con26=new Word(getString(R.string.con_26_english),getString(R.string.con_26_myanmar),R.raw.phrase_bill,R.color.conversation_cat);
        Word con28=new Word(getString(R.string.con_28_english),getString(R.string.con_28_myanmar),R.raw.phrase_who,R.color.conversation_cat);
        Word con29=new Word(getString(R.string.con_29_english),getString(R.string.con_29_myanmar),R.raw.phrase_why,R.color.conversation_cat);
        Word con30=new Word(getString(R.string.con_30_english),getString(R.string.con_30_myanmar),R.raw.pharse_which,R.color.conversation_cat);
        Word con31=new Word(getString(R.string.con_31_english),getString(R.string.con_31_myanmar),R.raw.phrase_what,R.color.conversation_cat);
        Word con32=new Word(getString(R.string.con_32_english),getString(R.string.con_32_myanmar),R.raw.phrase_doyouhave,R.color.conversation_cat);
        Word con33=new Word(getString(R.string.con_33_english),getString(R.string.con_33_myanmar),R.raw.phrase_how,R.color.conversation_cat);
        Word con34=new Word(getString(R.string.con_34_english),getString(R.string.con_34_myanmar),R.raw.phrase_howmany,R.color.conversation_cat);

        conWord.add(con1);
        conWord.add(con2);
        conWord.add(con3);
        conWord.add(con4);
        conWord.add(con5);
        conWord.add(con6);
        conWord.add(con7);
        conWord.add(con8);
        conWord.add(con9);
        conWord.add(con10);
        conWord.add(con11);
        conWord.add(con12);
        conWord.add(con13);
        conWord.add(con14);
        conWord.add(con15);
        conWord.add(con16);
        conWord.add(con17);
        conWord.add(con18);
        conWord.add(con19);
        conWord.add(con20);
        conWord.add(con21);
        conWord.add(con22);
        conWord.add(con23);
        conWord.add(con24);
        conWord.add(con25);
        conWord.add(con26);

        conWord.add(con28);
        conWord.add(con29);
        conWord.add(con30);
        conWord.add(con31);
        conWord.add(con33);
        conWord.add(con34);
        conWord.add(con32);

        wordAdapter=new WordAdapter(conWord,this);
        conservationRecycler.setAdapter(wordAdapter);
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
        mediaPlayer = MediaPlayer.create(ConversationActivity.this,itemClicked.getmAudioResourceId());
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(mCompletionListener);

    }
}
