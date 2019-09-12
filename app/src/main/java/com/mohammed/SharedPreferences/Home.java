package com.mohammed.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

  public  TextView textView;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Toolbar toolbar=findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

// صناعه ملف للتخزين
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
// متغير يحفض الحاله
        boolean firstStart = prefs.getBoolean("firstStart", true);
// اذا كان المتغير صحيح فسوف تظهر الدايلوك وبالعكس
        if (firstStart) {
            showStartDialog();
        }


        textView=findViewById(R.id.textView);
//صنع متغير لتخزين واضافته للتاكس فيو
        String myAdmin = prefs.getString("admin","admin");
        textView.setText(myAdmin);


    }
//داله لعرض الدايلوك تسجيل الدخول
    private void showStartDialog() {

        LoginFragment loginFragment =new LoginFragment();
        loginFragment.show(getSupportFragmentManager(),null);

    }
    

}
