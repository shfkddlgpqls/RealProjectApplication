package com.example.kuhyebin.projectapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private List<Item> items;
    private RecyclerView recyclerView;
    ImageView noticeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        noticeImageView = (ImageView)findViewById(R.id.image_notie);
      noticeImageView.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
              startActivity(intent);
              finish();
            }
       });

        initData();
    }

    private void initData(){
        items = new ArrayList<>();
        items.add(new Item("견적이요를 통해 진행된 외형복원 리얼 수기 후기!","외형복원 수리 사례",R.drawable.arrow));
        items.add(new Item("견적이요를 통해 진행된 리얼 정비 후기!","정비 수리 사례",R.drawable.arrow));
        items.add(new Item("견적이요를 통해 진행된 블랙박스 내비 광택 썬팅 후기!","블랙박스,내비,광택,썬팅 수리 사례",R.drawable.arrow));
        items.add(new Item("견적이요를 통해 진행된 타이어 구매 후기!","타이어구매 수리 사례",R.drawable.arrow));
        items.add(new Item("견적이요을 통해 진행된 보험 가입 후기!","보험 가입 사례",R.drawable.arrow));

        RecyclerAdapter adapter = new RecyclerAdapter(items, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }


}
