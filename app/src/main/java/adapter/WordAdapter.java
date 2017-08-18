package adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.khant.myanmarese.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import data.Category;
import data.Word;

/**
 * Created by khant on 4/13/17.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewholder> {
    ArrayList<Word> wordData;
    WordItemClickListener wordItemClickListener;

    public WordAdapter(ArrayList<Word> wordData, WordItemClickListener wordItemClickListener) {
        this.wordData = wordData;
        this.wordItemClickListener = wordItemClickListener;
    }

    @Override
    public WordViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_card,parent,false);
        return new WordViewholder(view);
    }

    @Override
    public void onBindViewHolder(WordViewholder holder, int position) {
        holder.defaultText.setText(wordData.get(position).getmDefaultTranslation());
        holder.myanmarText.setText(wordData.get(position).getmMyanmarTranslation());

        if(wordData.get(position).hasImage()){
            int imageResourceId = wordData.get(position).getmImageResourceId();
            Log.d("image resource id ::", String.valueOf(imageResourceId));
            if(imageResourceId == 7){
                Log.d("google drawable","drawable....");
                String defaultTranslation = wordData.get(position).getmDefaultTranslation();
                Log.d("Default Translation:::",defaultTranslation);
                String subString = defaultTranslation.substring(0,2);
                Log.d("sub string:::",subString);
                TextDrawable drawable = TextDrawable.builder()
                        .buildRound(subString, Color.rgb(33,9,9));
                holder.wordImage.setImageDrawable(drawable);
            }
            else{
                holder.wordImage.setImageResource(wordData.get(position).getmImageResourceId());
                holder.wordImage.setVisibility(View.VISIBLE);
            }

        }
        else {
            holder.wordImage.setVisibility(View.GONE);
        }


        holder.textContainer.setBackgroundResource(wordData.get(position).getColorResource());
    }

    @Override
    public int getItemCount() {
        return wordData.size();
    }

    public class WordViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout textContainer;
        TextView myanmarText;
        TextView defaultText;
        ImageView wordImage;
        public WordViewholder(View itemView) {
            super(itemView);
            myanmarText = (TextView) itemView.findViewById(R.id.myanmar_text);
            defaultText = (TextView) itemView.findViewById(R.id.default_text);
            wordImage = (ImageView) itemView.findViewById(R.id.word_image);
            textContainer = (LinearLayout) itemView.findViewById(R.id.text_container);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            wordItemClickListener.onItemClick(wordData.get(getLayoutPosition()));
        }
    }
    public interface WordItemClickListener {
        public void onItemClick(Word itemClicked);
    }
}
