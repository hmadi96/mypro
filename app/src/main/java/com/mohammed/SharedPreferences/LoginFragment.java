package com.mohammed.SharedPreferences;



import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends DialogFragment {


    SavingLogin savingLogin ;
    Button login;
    TextInputLayout passwordLayout;
    TextInputEditText name;
    CheckBox checkBox;
    TextInputEditText password;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

         login=view.findViewById(R.id.login);
         passwordLayout = view.findViewById(R.id.Password_layout);
         name = view.findViewById(R.id.userName);
         password = view.findViewById(R.id.userPassword);
         checkBox = view.findViewById(R.id.checkBox);
         savingLogin = new SavingLogin(getContext());
          password.addTextChangedListener(passwordWatcher);
         //check button login
        login.setOnClickListener(loginListener);

        //check Check Box
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    savingLogin.isLoggedIn();
                    ((Home)getActivity()).textView.setText(name.getText().toString());
                }
            }
        });

    }
//داله للتحقق من تسجيل الدخول
    View.OnClickListener loginListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str_userName=name.getText().toString();
            String str_password=password.getText().toString();
            String admin = "admin";
            String adminPassword = "12345678";

            if(str_userName.equals(admin) && str_password.equals(adminPassword))
            {

            ((Home)getActivity()).textView.setText(name.getText().toString());
            dismiss();
            }else
            {
             Toast.makeText(getContext(),"UserName and/or Password are not correct",Toast.LENGTH_LONG).show();
            }
        }
    };

    //داله لاظهار خطا الباسويرد اكبر من 8 احرف
    TextWatcher passwordWatcher =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.length()>passwordLayout.getCounterMaxLength())
            {
                passwordLayout.setError("Password is too long ...");
            }else {

                passwordLayout.setError(null);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}

