package com.app.loginexam.User;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.app.loginexam.Common.PopupActivity;
import com.app.loginexam.R;

public class JoinStep1 extends AppCompatActivity {

    TextView step;
    Button j_btn_back;
    Button nextStep;
    Button btn_agr1;
    Button btn_agr2;
    Button btn_agr3;

    public int TERMS_AGREE_1 = 0; // No Check = 0, Check = 1
    public int TERMS_AGREE_2 = 0; // No Check = 0, Check = 1
    public int TERMS_AGREE_3 = 0; // No Check = 0, Check = 1
    public int TERMS_AGREE_4 = 0; // No Check = 0, Check = 1

    CheckBox check1; // 첫번쨰 동의
    CheckBox check2; // 두번쨰 동의
    CheckBox check3; // 전체 동의
    CheckBox check4; // 전체 동의

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_step1);

        step = (TextView) findViewById(R.id.step);
        Animation trans = AnimationUtils.loadAnimation(this, R.anim.trans);
        step.startAnimation(trans);

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.j_btn_back :
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        break;
                    case R.id.btn_agr1 :
                        PopupActivity customDialog = new PopupActivity(JoinStep1.this);
                        customDialog.callFunction();
                        break;
                    case  R.id.nextStep :
                        Intent nextStep = new Intent(getApplicationContext(), JoinStep2.class);
                        startActivity(nextStep);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                }
            }
        };


        j_btn_back  = (Button) findViewById(R.id.j_btn_back);
        btn_agr1    = (Button) findViewById(R.id.btn_agr1);
        btn_agr2    = (Button) findViewById(R.id.btn_agr2);
        btn_agr3    = (Button) findViewById(R.id.btn_agr3);
        nextStep    = (Button) findViewById(R.id.nextStep);

        check1      = (CheckBox) findViewById(R.id.checkbox);
        check2      = (CheckBox) findViewById(R.id.checkbox2);
        check3      = (CheckBox) findViewById(R.id.checkbox3);
        check4      = (CheckBox) findViewById(R.id.checkbox4);

        j_btn_back.setOnClickListener(onClickListener);
        btn_agr1.setOnClickListener(onClickListener);
        btn_agr2.setOnClickListener(onClickListener);
        btn_agr3.setOnClickListener(onClickListener);
        nextStep.setOnClickListener(onClickListener);

        check1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check2.setChecked(true);
                    check3.setChecked(true);
                    check4.setChecked(true);
                    TERMS_AGREE_1 = 1;
                    nextStep.setEnabled(true);
                } else {
                    check2.setChecked(false);
                    check3.setChecked(false);
                    check4.setChecked(false);
                    TERMS_AGREE_1 = 0;
                    nextStep.setEnabled(false);
                }
            }
        });
        check2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TERMS_AGREE_2 = 1;
                    if(TERMS_AGREE_2+TERMS_AGREE_3+TERMS_AGREE_4 == 3) {
                        check1.setChecked(true);
                    }
                } else {
                    check1.setChecked(false);
                    TERMS_AGREE_2 = 0;
                }
            }
        });
        check3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TERMS_AGREE_3 = 1;
                    if(TERMS_AGREE_2+TERMS_AGREE_3+TERMS_AGREE_4 == 3) {
                        check1.setChecked(true);
                    }
                } else {
                    check1.setChecked(false);
                    TERMS_AGREE_3 = 0;
                }
            }
        });
        check4.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TERMS_AGREE_4 = 1;
                    if(TERMS_AGREE_2+TERMS_AGREE_3+TERMS_AGREE_4 == 3) {
                        check1.setChecked(true);
                    }
                } else {
                    check1.setChecked(false);
                    TERMS_AGREE_4 = 0;
                }
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}