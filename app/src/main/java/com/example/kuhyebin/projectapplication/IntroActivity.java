package com.example.kuhyebin.projectapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class IntroActivity extends AppCompatActivity {

    ImageView introView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        introView = (ImageView)findViewById(R.id.image_intro);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide(); //인트로 화면에는 액션바가 필요 없으니 숨긴다.

        Handler handler = new Handler(); //2초후에 인트로 액티비티를 제거하기 위해 사용
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); //인트로 액티비티를 종료, 뒤로 버튼으로도 돌아오지 못하도록
            }
         },1000); //2초후에 메인액티비티가 실행되도록

    }
}
