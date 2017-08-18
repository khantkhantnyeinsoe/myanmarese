package adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khant.myanmarese.R;

import java.util.ArrayList;
import java.util.StringTokenizer;

import data.Category;

/**
 * Created by khant on 4/12/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    ArrayList<Category> categoryData;
    CategoryItemClickListener mListener;

    public CategoryAdapter(ArrayList<Category> categoryData, CategoryItemClickListener mListener) {
        this.categoryData = categoryData;
        this.mListener = mListener;


    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.categoryTitle.setText(categoryData.get(position).getCategoryName());
        holder.categoryTitle.setBackgroundResource(categoryData.get(position).getColorResource());
        if(categoryData.get(position).hasImage()){
            holder.wordImage.setImageResource(categoryData.get(position).getmImageResourceId());
            holder.wordImage.setVisibility(View.VISIBLE);
        }
        else {
            holder.wordImage.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return categoryData.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView categoryTitle;
        ImageView wordImage;
        public CategoryViewHolder(View itemView) {
            super(itemView);
            categoryTitle = (TextView) itemView.findViewById(R.id.category_title);
            wordImage = (ImageView) itemView.findViewById(R.id.cat_image);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mListener.onItemClick(categoryData.get(getLayoutPosition()));
        }
    }

    public interface CategoryItemClickListener {
        public void onItemClick(Category itemClicked);
    }
}


