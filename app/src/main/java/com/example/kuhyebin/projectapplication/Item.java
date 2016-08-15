package com.example.kuhyebin.projectapplication;

/**
 * Created by kuhyebin on 2016-08-14.
 */
public class Item {
    int image;
    String title;

    int getImage(){
        return this.image;
    }
    String getTitle(){
        return this.title;
    }
    Item(int image, String title){
        this.image = image;
        this.title = title;
    }
}
