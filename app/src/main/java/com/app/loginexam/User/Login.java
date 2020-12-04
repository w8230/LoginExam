package com.app.loginexam.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.loginexam.Common.BackPressHandler;
import com.app.loginexam.R;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    private BackPressHandler backPressHandler = new BackPressHandler(this);
    TextInputEditText userID;
    TextInputEditText userPW;
    Button loginSubmit;
    TextView joinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText.OnEditorActionListener onEditorActionListener = new  TextInputEditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_NEXT :
                        Toast.makeText(v.getContext(),"IME_ACTION_NEXT",Toast.LENGTH_LONG).show();
                        userPW.requestFocus();
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                        break;
                    case EditorInfo.IME_ACTION_DONE :
                        InputMethodManager immhide = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                        immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        loginEvent(v);
                        break;
                    default:
                        return false;
                }

                return false;
            }
        };

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.joinBtn :
                        Intent intent = new Intent(getApplicationContext(), JoinStep1.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case R.id.loginSubmit :
                        Toast.makeText(v.getContext(),"로그인 버튼 눌림",Toast.LENGTH_LONG).show();
                }
            }
        };

        userID = (TextInputEditText) findViewById(R.id.userID);
        userID.setOnEditorActionListener(onEditorActionListener);
        userPW = (TextInputEditText) findViewById(R.id.userPW);
        userPW.setOnEditorActionListener(onEditorActionListener);
        joinBtn = (TextView) findViewById(R.id.joinBtn);
        joinBtn.setOnClickListener(onClickListener);
        loginSubmit = (Button) findViewById(R.id.loginSubmit);
    }

    public void loginEvent(View v) {
        Toast.makeText(this,"로그인 버튼 눌림",Toast.LENGTH_LONG).show();
    }

    // 뒤로가기 종료 함수
    @Override
    public void onBackPressed() {
        backPressHandler.onBackPressed();
    }
}