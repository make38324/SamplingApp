package com.swntek.sampling.active;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        jump();
    }

    private void jump() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WelcomeActivity.this.finish();
                LoginActivity.launch(WelcomeActivity.this);
            }
        },2000);
    }
}
