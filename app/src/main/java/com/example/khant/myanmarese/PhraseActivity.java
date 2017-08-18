package com.example.khant.myanmarese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.CategoryAdapter;
import data.Category;

public class PhraseActivity extends AppCompatActivity implements CategoryAdapter.CategoryItemClickListener {
    RecyclerView phraseRecycler;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categoryData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);
        phraseRecycler = (RecyclerView) findViewById(R.id.phraseRecycler);
        phraseRecycler.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        phraseRecycler.setLayoutManager(manager);
        Category greetingCat = new Category(R.drawable.handshake,"Greetings", R.color.greeting_cat);
        Category conversationCat = new Category(R.drawable.conversation,"General Conversation", R.color.conversation_cat);
        Category directions = new Category(R.drawable.direction,"Directions", R.color.direction_cat);
        Category eating=new Category(R.drawable.eating,"Eating Out",R.color.category_eatingout);
        categoryData.add(greetingCat);
        categoryData.add(conversationCat);
        categoryData.add(directions);
        categoryData.add(eating);
        categoryAdapter = new CategoryAdapter(categoryData, this);
        phraseRecycler.setAdapter(categoryAdapter);
    }

    @Override
    public void onItemClick(Category itemClicked) {
        switch (itemClicked.getCategoryName()) {
            case "Greetings":
                Intent intent = new Intent(PhraseActivity.this, GreetingActivity.class);
                startActivity(intent);
                break;
            case "General Conversation":
                Intent intent1 = new Intent(PhraseActivity.this, ConversationActivity.class);
                startActivity(intent1);
                break;
            case "Directions":
                Intent intent2 = new Intent(PhraseActivity.this, DirectionActivity.class);
                startActivity(intent2);
                break;
            case "Eating Out":
                Intent intent4 = new Intent(PhraseActivity.this, EatingOutActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
