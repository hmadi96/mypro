package com.mohammed.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

  public  TextView textView;
    boolean setAdmin=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Toolbar toolbar=findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        textView=findViewById(R.id.textView);
        SavingLogin savingLogin = new SavingLogin(getApplicationContext());
          // شرط عرض الدايلوك
        if(savingLogin.getReadLoggedIn()){
           showStartDialog();
           setAdmin=false;
        }

      if(setAdmin){
          String setAdmin = getString(R.string.admin);
       textView.setText(savingLogin.prefs.getString(setAdmin,setAdmin));
      }
    }
//داله لعرض الدايلوك تسجيل الدخول
    private void showStartDialog() {

        LoginFragment loginFragment =new LoginFragment();
        loginFragment.show(getSupportFragmentManager(),null);

    }
    

}
