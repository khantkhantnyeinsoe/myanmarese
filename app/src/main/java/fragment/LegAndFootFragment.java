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
public class LegAndFootFragment extends Fragment implements WordAdapter.WordItemClickListener {
    ArrayList<Word> wordData = new ArrayList<Word>();
    WordAdapter wordAdapter;
    RecyclerView legAndFootRecycler;
    MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Log.d("release:","released..");
            releaseMediaPlayer();
        }
    };

    public LegAndFootFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("stop fragment activity","Stop.......");
        releaseMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_leg_and_foot, container, false);

        legAndFootRecycler = (RecyclerView) view.findViewById(R.id.leg_and_foot_recycler);
        legAndFootRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        legAndFootRecycler.setLayoutManager(linearLayoutManager);

        Word word1 = new Word(getString(R.string.knee_default),getString(R.string.knee_myanmar),R.drawable.eye,R.raw.body_knee,R.color.category_bodypart);
        Word word2 = new Word(getString(R.string.leg_default),getString(R.string.leg_myanmar),R.drawable.eye,R.raw.body_leg,R.color.category_bodypart);
        Word word3 = new Word(getString(R.string.shin_default),getString(R.string.shin_myanmar),R.drawable.eye,R.raw.body_shin,R.color.category_bodypart);
        Word word4 = new Word(getString(R.string.ankle_default),getString(R.string.ankle_myanmar),R.drawable.eye,R.raw.body_ankle,R.color.category_bodypart);
        Word word5 = new Word(getString(R.string.heel_default),getString(R.string.heel_myanmar),R.drawable.eye,R.raw.body_heel,R.color.category_bodypart);
        Word word6 = new Word(getString(R.string.toe_default),getString(R.string.toe_myanmar),R.drawable.eye,R.raw.body_toe,R.color.category_bodypart);


        wordData.add(word1);
        wordData.add(word2);
        wordData.add(word3);
        wordData.add(word4);
        wordData.add(word5);
        wordData.add(word6);


        wordAdapter = new WordAdapter(wordData,this);

        legAndFootRecycler.setAdapter(wordAdapter);


        return view;
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
