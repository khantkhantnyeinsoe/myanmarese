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
public class HandAndFingerFragment extends Fragment implements WordAdapter.WordItemClickListener {

    WordAdapter wordAdapter;
    RecyclerView handAndFingerRecycler;
    MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Log.d("release:","released..");
            releaseMediaPlayer();
        }
    };

    public HandAndFingerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_arm, container, false);
        ArrayList<Word> wordData = new ArrayList<Word>();

        handAndFingerRecycler = (RecyclerView) view.findViewById(R.id.arm_recycler);
        handAndFingerRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        handAndFingerRecycler.setLayoutManager(linearLayoutManager);

        Word word1 = new Word(getString(R.string.throat_default),getString(R.string.throat_myanmar),R.drawable.throat,R.raw.body_throat,R.color.category_bodypart);
        Word word2 = new Word(getString(R.string.tongue_default),getString(R.string.tongue_myanmar),R.drawable.tongue,R.raw.body_tongue,R.color.category_bodypart);
        Word word3 = new Word(getString(R.string.skin_default),getString(R.string.skin_myanmar),R.drawable.skin,R.raw.body_skin,R.color.category_bodypart);


        wordData.add(word1);
        wordData.add(word2);
        wordData.add(word3);



        wordAdapter = new WordAdapter(wordData,this);

        handAndFingerRecycler.setAdapter(wordAdapter);

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
