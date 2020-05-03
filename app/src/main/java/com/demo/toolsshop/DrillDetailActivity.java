package com.demo.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {
    ImageView imageViewDrill;
    TextView textViewDescription;
    TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        imageViewDrill=findViewById(R.id.imageViewDrill);
        textViewDescription=findViewById(R.id.textViewInfo);
        textViewTitle=findViewById(R.id.textViewTitle);

        Intent intent = getIntent();

        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("id")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int id = intent.getIntExtra("id", 0);

            textViewDescription.setText(info);
            textViewTitle.setText(title);
            imageViewDrill.setImageResource(id);
        }
         else {
             Intent backToCategory = new Intent(this,DrillCategoryActivity.class);
             startActivity(backToCategory);
        }

    }
}
