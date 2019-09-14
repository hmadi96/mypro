package com.mohammed.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;



public class SavingLogin {


 public   SharedPreferences prefs ;
  private SharedPreferences.Editor editor;
  private   Context context;


    public SavingLogin(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences(context.getResources().getString(R.string.prefs),Context.MODE_PRIVATE);
    }

   public void writeLogin(boolean status)
   {
     SharedPreferences.Editor editor = prefs.edit();
     editor.putBoolean(context.getResources().getString(R.string.login_status_preferences),status);
     editor.putString(context.getResources().getString(R.string.admin),context.getResources().getString(R.string.admin));
     editor.commit();

   }

    public boolean getReadLoggedIn(){
        boolean  status ;
        status =prefs.getBoolean(context.getResources().getString(R.string.login_status_preferences),true);
        return status;
    }

}
