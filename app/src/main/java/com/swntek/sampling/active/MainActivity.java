package com.swntek.sampling.active;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.swntek.sampling.utils.ConstactUtil;
import com.swntek.sampling.utils.SystemUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.ll_add)
    LinearLayout llAdd;
    @BindView(R.id.ll_min)
    LinearLayout llMin;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.ll_other)
    LinearLayout llOther;

    public static void launch(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemUtil.initSystemBar(this, R.color.mainback);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ll_add, R.id.ll_min, R.id.ll_search, R.id.ll_other})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_add:
                ConstactUtil.Flag=ConstactUtil.add;
                AddRepertoryActivity.launch(this);
                break;
            case R.id.ll_min:
                ConstactUtil.Flag=ConstactUtil.reduce;
                Checkarea.launch(this);
                break;
            case R.id.ll_search:
                SearchActivity.launch(this);
                break;
            case R.id.ll_other:
                OtherActivity.lanuch(this);
                break;
        }
    }
}
