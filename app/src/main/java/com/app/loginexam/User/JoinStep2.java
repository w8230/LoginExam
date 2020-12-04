package com.app.loginexam.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.loginexam.Common.PopupActivity;
import com.app.loginexam.R;

public class JoinStep2 extends AppCompatActivity {

    TextView step;
    Button j_btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_step2);

        step = (TextView) findViewById(R.id.step);
        Animation trans = AnimationUtils.loadAnimation(this, R.anim.trans);
        step.startAnimation(trans);

        EditText brand_phone = (EditText) findViewById(R.id.edit_phone);
        brand_phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());


        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.j_btn_back :
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        break;
                }
            }
        };
        j_btn_back  = (Button) findViewById(R.id.j_btn_back);
        j_btn_back.setOnClickListener(onClickListener);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}