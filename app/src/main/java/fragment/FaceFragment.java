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
public class FaceFragment extends Fragment implements WordAdapter.WordItemClickListener {
    ArrayList<Word> wordData = new ArrayList<Word>();
    WordAdapter wordAdapter;
    RecyclerView faceRecycler;
    MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Log.d("release:","released..");
            releaseMediaPlayer();
        }
    };

    public FaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_face, container, false);

        ArrayList<Word> wordData = new ArrayList<Word>();
        faceRecycler = (RecyclerView) view.findViewById(R.id.face_recycler);
        faceRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        faceRecycler.setLayoutManager(linearLayoutManager);


        Word word1 = new Word(getString(R.string.eye_default),getString(R.string.eye_myanmar),R.drawable.eye,R.raw.body_eye,R.color.category_bodypart);
        Word word2 = new Word(getString(R.string.nose_default),getString(R.string.nose_myanmar),R.drawable.nose,R.raw.body_nose,R.color.category_bodypart);
        Word word3 = new Word(getString(R.string.mouth_default),getString(R.string.mouth_myanmar),R.drawable.mouth,R.raw.body_mouth,R.color.category_bodypart);
        Word word4 = new Word(getString(R.string.ear_default),getString(R.string.ear_myanmar),R.drawable.ear,R.raw.body_ear,R.color.category_bodypart);
        Word word5 = new Word(getString(R.string.cheek_default),getString(R.string.cheek_myanmar),R.drawable.cheek,R.raw.body_cheek,R.color.category_bodypart);
        Word word6 = new Word(getString(R.string.chin_default),getString(R.string.chin_myanmar),R.drawable.chin,R.raw.body_chin,R.color.category_bodypart);
        Word word7 = new Word(getString(R.string.eyebrow_default),getString(R.string.eyebrow_myanmar),R.drawable.eyebrow,R.raw.body_eyebrow,R.color.category_bodypart);
        Word word8 = new Word(getString(R.string.eyelid_default),getString(R.string.eyelid_myanmar),R.drawable.eyelid,R.raw.body_eyelid,R.color.category_bodypart);
        Word word9 = new Word(getString(R.string.eyelash_default),getString(R.string.eyelash_myanmar),R.drawable.eyelash,R.raw.body_eyelash,R.color.category_bodypart);
        Word word10 = new Word(getString(R.string.lips_default),getString(R.string.lips_myanmar),R.drawable.lips,R.raw.body_lips,R.color.category_bodypart);

        Word word11 = new Word(getString(R.string.wrist_default),getString(R.string.wrist_myanmar),R.drawable.wrist,R.raw.body_wrist,R.color.category_bodypart);
        Word word12 = new Word(getString(R.string.forearm_default),getString(R.string.forearm_myanmar),R.drawable.forearm,R.raw.body_forearm,R.color.category_bodypart);
        Word word13 = new Word(getString(R.string.elbow_default),getString(R.string.elbow_myanmar),R.drawable.elbow,R.raw.body_elbow,R.color.category_bodypart);
        Word word14 = new Word(getString(R.string.upperarm_default),getString(R.string.upperarm_myanmar),R.drawable.upperarm,R.raw.body_elbow,R.color.category_bodypart);
        Word word15 = new Word(getString(R.string.shoulder_default),getString(R.string.shoulder_myanmar),R.drawable.shoulder,R.raw.body_shoulder,R.color.category_bodypart);
        Word word16 = new Word(getString(R.string.thumb_default),getString(R.string.thumb_myanmar),R.drawable.thumb,R.raw.body_thumb,R.color.category_bodypart);

        Word word17 = new Word(getString(R.string.fingers_default),getString(R.string.fingers_myanmar),R.drawable.fingers,R.raw.body_fingers,R.color.category_bodypart);
        Word word18 = new Word(getString(R.string.palm_default),getString(R.string.palm_myanmar),R.drawable.palm,R.raw.body_palm,R.color.category_bodypart);
        Word word19 = new Word(getString(R.string.hand_default),getString(R.string.hand_myanmar),R.drawable.hand,R.raw.body_hand,R.color.category_bodypart);
        Word word20 = new Word(getString(R.string.index_finger_default),getString(R.string.index_finger_myanmar),R.drawable.indexfinger,R.raw.body_indexfinger,R.color.category_bodypart);
        Word word21 = new Word(getString(R.string.ring_finger_default),getString(R.string.ring_finger_myanmar),R.drawable.ringfinger,R.raw.body_ringfinger,R.color.category_bodypart);
        Word word22 = new Word(getString(R.string.knuckle_default),getString(R.string.knuckle_myanmar),R.drawable.knuckles,R.raw.body_knuckle,R.color.category_bodypart);

        Word word23 = new Word(getString(R.string.knee_default),getString(R.string.knee_myanmar),R.drawable.knee,R.raw.body_knee,R.color.category_bodypart);
        Word word24 = new Word(getString(R.string.leg_default),getString(R.string.leg_myanmar),R.drawable.leg,R.raw.body_leg,R.color.category_bodypart);
        Word word25 = new Word(getString(R.string.shin_default),getString(R.string.shin_myanmar),R.drawable.skin,R.raw.body_shin,R.color.category_bodypart);
        Word word26 = new Word(getString(R.string.ankle_default),getString(R.string.ankle_myanmar),R.drawable.ankle,R.raw.body_ankle,R.color.category_bodypart);
        Word word27 = new Word(getString(R.string.heel_default),getString(R.string.heel_myanmar),R.drawable.heel,R.raw.body_heel,R.color.category_bodypart);
        Word word28 = new Word(getString(R.string.toe_default),getString(R.string.toe_myanmar),R.drawable.toe,R.raw.body_toe,R.color.category_bodypart);

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
        wordData.add(word25);
        wordData.add(word26);
        wordData.add(word27);
        wordData.add(word28);


        wordAdapter = new WordAdapter(wordData,this);

        faceRecycler.setAdapter(wordAdapter);

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
