package com.swntek.sampling.active;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by mac on 17/7/3.
 */
public abstract class BaseActivity extends Activity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.iv_right)
    ImageView ivRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void assignTitleBar(String title){
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvText.setText(title);
    }
}
