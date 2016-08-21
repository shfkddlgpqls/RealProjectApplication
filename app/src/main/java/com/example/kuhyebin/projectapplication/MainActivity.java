package com.example.kuhyebin.projectapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private List<Item> items;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.image_notie) ImageView noticeImageView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.btn_basiccar) Button appearance;
    @BindView(R.id.btn_oilcar) Button oilcar;
    @BindView(R.id.btn_sunting) Button sunting;
    @BindView(R.id.btn_tire) Button tire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        initData();

    }
    @OnClick(R.id.image_notie)
    void onVoticeClick(View view){
        Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.btn_basiccar)
    void onBasicClick(View view){
        Intent intent = new Intent(MainActivity.this, AppearanceActivity.class);
        startActivity(intent);

    }
    @OnClick(R.id.btn_oilcar)
    void onOilClick(View view){
        Intent intent = new Intent(MainActivity.this, OilActivity.class);
        startActivity(intent);

    }
    @OnClick(R.id.btn_sunting)
    void onBlackboxClick(View view){
        Intent intent = new Intent(MainActivity.this, BlackboxActivity.class);
        startActivity(intent);

    }
    @OnClick(R.id.btn_tire)
    void onTireClick(View view){
        Intent intent = new Intent(MainActivity.this, TireActivity.class);
        startActivity(intent);

    }
    private void initData() {  //리스트에 들어갈 내용들
        items = new ArrayList<>();
        items.add(new Item("견적이요를 통해 진행된 외형복원 리얼 수기 후기!", "외형복원 수리 사례", R.drawable.arrow));
        items.add(new Item("견적이요를 통해 진행된 리얼 정비 후기!", "정비 수리 사례", R.drawable.arrow));
        items.add(new Item("견적이요를 통해 진행된 블랙박스 내비 광택 썬팅 후기!", "블랙박스,내비,광택,썬팅 수리 사례", R.drawable.arrow));
        items.add(new Item("견적이요를 통해 진행된 타이어 구매 후기!", "타이어구매 수리 사례", R.drawable.arrow));
        items.add(new Item("견적이요을 통해 진행된 보험 가입 후기!", "보험 가입 사례", R.drawable.arrow));

        RecyclerAdapter adapter = new RecyclerAdapter(items, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }


}
