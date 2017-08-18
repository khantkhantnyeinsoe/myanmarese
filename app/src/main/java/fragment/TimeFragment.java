package fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khant.myanmarese.NumbersActivity;
import com.example.khant.myanmarese.R;

import java.util.ArrayList;

import adapter.WordAdapter;
import data.Word;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeFragment extends Fragment implements WordAdapter.WordItemClickListener{
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

    public TimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_time, container, false);

        numberRecycler = (RecyclerView) view.findViewById(R.id.time_recycler);
        numberRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        numberRecycler.setLayoutManager(linearLayoutManager);

        Word word1 = new Word(getString(R.string.one_am_default),getString(R.string.one_am_myanmar),7,R.raw.time_1am,R.color.category_timeanddate);
        Word word2 = new Word(getString(R.string.two_am_default),getString(R.string.two_am_myanmar),7,R.raw.time_2am,R.color.category_timeanddate);
        Word word3 = new Word(getString(R.string.three_am_default),getString(R.string.three_am_myanmar),7,R.raw.time_3am,R.color.category_timeanddate);
        Word word4 = new Word(getString(R.string.four_am_default),getString(R.string.four_am_myanmar),7,R.raw.time_4am,R.color.category_timeanddate);
        Word word5 = new Word(getString(R.string.five_am_default),getString(R.string.five_am_myanmar),7,R.raw.time_5am,R.color.category_timeanddate);
        Word word6 = new Word(getString(R.string.six_am_default),getString(R.string.six_am_myanmar),7,R.raw.time_6am,R.color.category_timeanddate);
        Word word7 = new Word(getString(R.string.seven_am_default),getString(R.string.seven_am_myanmar),7,R.raw.time_7am,R.color.category_timeanddate);
        Word word8 = new Word(getString(R.string.eight_am_default),getString(R.string.eight_am_myanmar),7,R.raw.time_8am,R.color.category_timeanddate);
        Word word9 = new Word(getString(R.string.nine_am_default),getString(R.string.nine_am_myanmar),7,R.raw.time_9am,R.color.category_timeanddate);
        Word word10 = new Word(getString(R.string.ten_am_default),getString(R.string.ten_am_myanmar),7,R.raw.time_10am,R.color.category_timeanddate);
        Word word11 = new Word(getString(R.string.eleven_am_default),getString(R.string.eleven_am_myanmar),7,R.raw.time_11am,R.color.category_timeanddate);
        Word word12 = new Word(getString(R.string.twelve_am_default),getString(R.string.twelve_am_myanmar),7,R.raw.time_12am,R.color.category_timeanddate);

        Word word13 = new Word(getString(R.string.one_pm_default),getString(R.string.one_pm_myanmar),7,R.raw.time_1pm,R.color.category_timeanddate);
        Word word14 = new Word(getString(R.string.two_pm_default),getString(R.string.two_pm_myanmar),7,R.raw.time_2pm,R.color.category_timeanddate);
        Word word15 = new Word(getString(R.string.three_pm_default),getString(R.string.three_pm_myanmar),7,R.raw.time_3pm,R.color.category_timeanddate);
        Word word16 = new Word(getString(R.string.four_pm_default),getString(R.string.four_pm_myanmar),7,R.raw.time_4pm,R.color.category_timeanddate);
        Word word17 = new Word(getString(R.string.five_pm_default),getString(R.string.five_pm_myanmar),7,R.raw.time_5pm,R.color.category_timeanddate);
        Word word18 = new Word(getString(R.string.six_pm_default),getString(R.string.six_pm_myanmar),7,R.raw.time_6pm,R.color.category_timeanddate);
        Word word19 = new Word(getString(R.string.seven_pm_default),getString(R.string.seven_pm_myanmar),7,R.raw.time_7pm,R.color.category_timeanddate);
        Word word20 = new Word(getString(R.string.eight_pm_default),getString(R.string.eight_pm_myanmar),7,R.raw.time_8pm,R.color.category_timeanddate);
        Word word21 = new Word(getString(R.string.nine_pm_default),getString(R.string.nine_pm_myanmar),7,R.raw.time_9pm,R.color.category_timeanddate);
        Word word22 = new Word(getString(R.string.ten_pm_default),getString(R.string.ten_pm_myanmar),7,R.raw.time_10pm,R.color.category_timeanddate);
        Word word23 = new Word(getString(R.string.eleven_pm_default),getString(R.string.eleven_pm_myanmar),7,R.raw.time_11pm,R.color.category_timeanddate);
        Word word24 = new Word(getString(R.string.twelve_pm_default),getString(R.string.twelve_pm_myanmar),7,R.raw.time_12pm,R.color.category_timeanddate);

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

        wordData.add(word13);
        wordData.add(word14);
        wordData.add(word15);
        wordData.add(word16);
        wordData.add(word17);
        wordData.add(word18);
        wordData.add(word19);
        wordData.add(word20);
        wordData.add(word21);
        wordData.add(word22);
        wordData.add(word23);
        wordData.add(word24);


        wordAdapter = new WordAdapter(wordData,this);

        numberRecycler.setAdapter(wordAdapter);

        return view;
    }
    private void releaseMediaPlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("stop fragment activity","Stop.......");
        releaseMediaPlayer();
    }

    @Override
    public void onItemClick(Word itemClicked) {
        int audio = itemClicked.getmAudioResourceId();
        Log.d("click : ", String.valueOf(audio));

        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(getContext(),itemClicked.getmAudioResourceId());
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(mCompletionListener);
    }
}
