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
public class InternalPartsFragment extends Fragment implements WordAdapter.WordItemClickListener {

    ArrayList<Word> wordData = new ArrayList<Word>();
    WordAdapter wordAdapter;
    RecyclerView internalPartsRecycler;
    MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Log.d("release:","released..");
            releaseMediaPlayer();
        }
    };

    public InternalPartsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_internal_parts, container, false);

        internalPartsRecycler = (RecyclerView) view.findViewById(R.id.internal_parts_recycler);
        internalPartsRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        internalPartsRecycler.setLayoutManager(linearLayoutManager);

        Word word1 = new Word(getString(R.string.heart_default),getString(R.string.heart_myanmar),R.drawable.eye,R.raw.body_heart,R.color.category_bodypart);
        Word word2 = new Word(getString(R.string.lungs_default),getString(R.string.lungs_myanmar),R.drawable.eye,R.raw.body_lungs,R.color.category_bodypart);
        Word word3 = new Word(getString(R.string.veins_default),getString(R.string.veins_myanmar),R.drawable.eye,R.raw.number_three,R.color.category_bodypart);
        Word word4 = new Word(getString(R.string.brain_default),getString(R.string.brain_myanmar),R.drawable.eye,R.raw.body_brain,R.color.category_bodypart);
        Word word5 = new Word(getString(R.string.throat_default),getString(R.string.throat_myanmar),R.drawable.eye,R.raw.body_throat,R.color.category_bodypart);
        Word word6 = new Word(getString(R.string.liver_default),getString(R.string.liver_myanmar),R.drawable.eye,R.raw.body_liver,R.color.category_bodypart);
        Word word7 = new Word(getString(R.string.stomach_default),getString(R.string.stomach_myanmar),R.drawable.eye,R.raw.body_stomach,R.color.category_bodypart);
        Word word8 = new Word(getString(R.string.kidneys_default),getString(R.string.kidneys_myanmar),R.drawable.eye,R.raw.body_kidney,R.color.category_bodypart);
        Word word9 = new Word(getString(R.string.skeleton_default),getString(R.string.skeleton_myanmar),R.drawable.eye,R.raw.number_three,R.color.category_bodypart);
        Word word10 = new Word(getString(R.string.ribs_default),getString(R.string.ribs_myanmar),R.drawable.eye,R.raw.number_four,R.color.category_bodypart);
        Word word11 = new Word(getString(R.string.bones_default),getString(R.string.bones_myanmar),R.drawable.eye,R.raw.number_five,R.color.category_bodypart);
        Word word12 = new Word(getString(R.string.skin_default),getString(R.string.skin_myanmar),R.drawable.eye,R.raw.body_skin,R.color.category_bodypart);


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

        internalPartsRecycler.setAdapter(wordAdapter);

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
