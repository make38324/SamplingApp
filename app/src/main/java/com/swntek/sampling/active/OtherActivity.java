package com.swntek.sampling.active;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.swntek.sampling.utils.ConstactUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtherActivity extends BaseBottomActivity {

    @BindView(R.id.tv_numbertree)
    TextView tvNumbertree;
    @BindView(R.id.dietree)
    TextView dietree;
    @BindView(R.id.ll_content)
    LinearLayout llContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.bind(this);
    }

    public static void lanuch(Activity context) {
        context.startActivity(new Intent(context, OtherActivity.class));
    }

    @OnClick({R.id.tv_numbertree, R.id.dietree})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_numbertree:
                ConstactUtil.Flag=ConstactUtil.numbertree;
                finish();
                Checkarea.launch(this);
                break;
            case R.id.dietree:
                ConstactUtil.Flag=ConstactUtil.dietree;
                finish();
                Checkarea.launch(this);
                break;
        }
    }
}
