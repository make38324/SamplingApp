package com.swntek.sampling.active;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class TreeinfoActivity extends BaseActivity {
    public static void lanuch(Activity activity){
        activity.startActivity(new Intent(activity,TreeinfoActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treeinfo);
        ButterKnife.bind(this);
        assignTitleBar("输入树木基本信息");
    }
}
