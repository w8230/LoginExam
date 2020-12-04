package com.app.loginexam.Common;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.loginexam.R;
import com.lakue.lakuepopupactivity.PopupResult;

public class PopupActivity{
    private Context context;
    private WebView wv;
    private Button cancel;
    private CheckBox checkbox;
    private CheckBox checkbox2;
    private CheckBox checkbox3;
    private CheckBox checkbox4;

    public PopupActivity(Context context) {
        this.context = context;
    }

    public void callFunction() {
        final Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.activity_popup);
        dlg.show();

        wv = (WebView) dlg.findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        wv.loadUrl("http://nextmatch.kr/privacy/amanda/agreement.html");
        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClientClass());

        cancel = (Button) dlg.findViewById(R.id.pop_close);
        checkbox = (CheckBox) dlg.findViewById(R.id.checkbox);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });
    }
    private class WebViewClientClass extends WebViewClient {//페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }
    }
}