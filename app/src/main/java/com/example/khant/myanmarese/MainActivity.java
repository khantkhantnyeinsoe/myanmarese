package com.example.khant.myanmarese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import adapter.CategoryAdapter;
import data.Category;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.CategoryItemClickListener {

    RecyclerView categoryRecycler;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categoryData = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryRecycler = (RecyclerView) findViewById(R.id.categoryRecycler);
        categoryRecycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        categoryRecycler.setLayoutManager(linearLayoutManager);



        Category category1 = new Category(R.drawable.number_icon,getString(R.string.category_numbers),R.color.category_number);
        Category category2 = new Category(R.drawable.color_icon,getString(R.string.category_colors),R.color.category_color);
        Category category3 = new Category(R.drawable.day_icon,getString(R.string.category_timeanddate),R.color.category_timeanddate);
        Category category4 = new Category(R.drawable.body_icon,getString(R.string.category_bodyparts),R.color.category_bodypart);
        Category category5=new Category(R.drawable.place,"Places",R.color.place_cat);
        Category category6 = new Category(R.drawable.fruit_icon,getString(R.string.category_fruits),R.color.category_fruit);
        Category category7 = new Category(R.drawable.vegetable_icon,getString(R.string.category_vegetables),R.color.category_vegetable);
        Category category8 = new Category(R.drawable.family_icon,getString(R.string.category_family),R.color.category_familymember);
        Category category9 = new Category(R.drawable.phrase_icon,getString(R.string.category_phrases),R.color.category_phrase);

        categoryData.add(category1);
        categoryData.add(category2);
        categoryData.add(category3);
        categoryData.add(category4);
        categoryData.add(category5);
        categoryData.add(category6);
        categoryData.add(category7);
        categoryData.add(category8);
        categoryData.add(category9);

        categoryAdapter = new CategoryAdapter(categoryData,this);
        categoryRecycler.setAdapter(categoryAdapter);


    }

    @Override
    public void onItemClick(Category itemClicked) {
        Log.d("category name : ",itemClicked.getCategoryName());
        switch (itemClicked.getCategoryName()){
            case "Numbers":
                Intent intent = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(intent);
                break;
            case "Colors":
                Intent intent1 = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(intent1);
                break;
            case "Time and Day":
                Intent intent2 = new Intent(MainActivity.this,TimeAndDateActivity.class);
                startActivity(intent2);
                break;
            case "Body Parts":
                Intent intent3 = new Intent(MainActivity.this,BodyPartsActivity.class);
                startActivity(intent3);
                break;
            case "Places":
                Intent intent4 = new Intent(MainActivity.this, PlaceActivity.class);
                startActivity(intent4);
                break;
            case "Fruits":
                Intent intent5 = new Intent(MainActivity.this,FruitActivity.class);
                startActivity(intent5);
                break;
            case "Vegetables":
                Intent intent6 = new Intent(MainActivity.this,VegetableActivity.class);
                startActivity(intent6);
                break;
            case "Family Members":
                Intent intent7 = new Intent(MainActivity.this,FamilyMemberActivity.class);
                startActivity(intent7);
                break;
            case "Phrases":
                Intent intent8 = new Intent(MainActivity.this,PhraseActivity.class);
                startActivity(intent8);
        }
    }
}
