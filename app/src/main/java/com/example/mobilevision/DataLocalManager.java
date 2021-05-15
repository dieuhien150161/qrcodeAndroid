package com.example.mobilevision;

import android.content.Context;

public class DataLocalManager {
    private  static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;

    public  static void init(Context context){
        instance = new DataLocalManager();
        instance.mySharedPreferences = new MySharedPreferences((context));
    }
    public static DataLocalManager getInstance(){
        if (instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }

}
