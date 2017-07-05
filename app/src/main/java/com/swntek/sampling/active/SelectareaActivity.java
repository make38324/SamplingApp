package com.swntek.sampling.active;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.swntek.sampling.dialog.TreeClickDialog;
import com.swntek.sampling.utils.ConstactUtil;

import org.kymjs.kjframe.ui.ViewInject;
import org.kymjs.kjframe.widget.AdapterHolder;
import org.kymjs.kjframe.widget.KJAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectareaActivity extends BaseActivity {

    @BindView(R.id.gv_trea)
    GridView gvTrea;
    @BindView(R.id.btn_addorreduce)
    TextView btnAddorreduce;

    private List<String> datas = new ArrayList<>();

    public static void launch(Context context) {
        Intent intent = new Intent(context, SelectareaActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectarea);
        ButterKnife.bind(this);
        assignTitleBar("选择树坑");
        checkState(ConstactUtil.Flag==ConstactUtil.add);//入库或出库
        initData();
        gvTrea.setAdapter(new KJAdapter<String>(gvTrea, datas, R.layout.item_gv_trea) {
            @Override
            public void convert(AdapterHolder helper, String item, boolean isScrolling, final int position) {
                super.convert(helper, item, isScrolling);
                ImageView iv_trea = helper.getView(R.id.iv_trea);
                TextView tv_trea = helper.getView(R.id.tv_trea);
                if (position >= 4) {
                    iv_trea.setImageResource(R.mipmap.treearea);
                } else {
                    iv_trea.setImageResource(R.mipmap.tree);
                }
                iv_trea.setTag("" + position);
                tv_trea.setText("A1-" + (position + 1));
            }
        });
        gvTrea.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 4) {
                    TreeinfoActivity.lanuch(SelectareaActivity.this);
                } else {
                    TreeClickDialog dialog=new TreeClickDialog(SelectareaActivity.this,"A1-"+(1+position));
                    dialog.show();
//                    ViewInject.toast(getApplicationContext(), "有树了");
                }
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            datas.add(i + "");
        }
    }

    @OnClick(R.id.btn_addorreduce)
    public void onClick() {
    }

    private void checkState(boolean isadd){
        if(isadd){
            btnAddorreduce.setText("种树");
        }else{
            btnAddorreduce.setText("出库");
        }
    }
}
