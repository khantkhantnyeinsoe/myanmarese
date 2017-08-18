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

import com.example.khant.myanmarese.R;

import java.util.ArrayList;

import adapter.WordAdapter;
import data.Word;

/**
 * A simple {@link Fragment} subclass.
 */
public class DateFragment extends Fragment implements WordAdapter.WordItemClickListener {
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

    public DateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_date, container, false);

        numberRecycler = (RecyclerView) view.findViewById(R.id.date_recycler);
        numberRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        numberRecycler.setLayoutManager(linearLayoutManager);

        Word word1 = new Word(getString(R.string.sunday_default),getString(R.string.sunday_myanmar),R.drawable.garuda,R.raw.day_sunday,R.color.category_timeanddate);
        Word word2 = new Word(getString(R.string.monday_default),getString(R.string.monday_myanmar),R.drawable.tiger,R.raw.day_monday,R.color.category_timeanddate);
        Word word3 = new Word(getString(R.string.tuesday_default),getString(R.string.tuesday_myanmar),R.drawable.lion,R.raw.day_tuesday,R.color.category_timeanddate);
        Word word4 = new Word(getString(R.string.wednesday_default),getString(R.string.wednesday_myanmar),R.drawable.elephant,R.raw.phrase_wednesday,R.color.category_timeanddate);
        Word word5 = new Word(getString(R.string.thursday_default),getString(R.string.thursday_myanmar),R.drawable.rat,R.raw.day_thursday,R.color.category_timeanddate);
        Word word6 = new Word(getString(R.string.friday_default),getString(R.string.friday_myanmar),R.drawable.gunipig,R.raw.day_friday,R.color.category_timeanddate);
        Word word7 = new Word(getString(R.string.sat_default),getString(R.string.sat_myanmar),R.drawable.dragon,R.raw.day_saturday,R.color.category_timeanddate);


        wordData.add(word1);
        wordData.add(word2);
        wordData.add(word3);
        wordData.add(word4);
        wordData.add(word5);
        wordData.add(word6);
        wordData.add(word7);

        wordAdapter = new WordAdapter(wordData,this);

        numberRecycler.setAdapter(wordAdapter);

        return view;
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
    private void releaseMediaPlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
