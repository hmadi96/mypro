package com.mohammed.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;



public class SavingLogin {


    SharedPreferences prefs ;
    SharedPreferences.Editor editor;
    Context context;


    public SavingLogin(Context context) {
        this.context = context;

    }
// داله لحفظ تسجيل الدخول

    public void isLoggedIn(){
         prefs = context.getSharedPreferences("prefs",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.putString("admin","admin");
        editor.apply();


    }

}
