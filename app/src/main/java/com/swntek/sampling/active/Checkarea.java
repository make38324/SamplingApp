package com.swntek.sampling.active;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.swntek.sampling.view.MeasureGridView;
import com.swntek.sampling.view.MeasureListView;

import org.kymjs.kjframe.widget.AdapterHolder;
import org.kymjs.kjframe.widget.KJAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Checkarea extends BaseActivity {

    @BindView(R.id.lv)
    ListView lv;
    private List<String> datas;

    public static void launch(Context context) {
        Intent intent = new Intent(context, Checkarea.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkarea);
        ButterKnife.bind(this);
        assignTitleBar("选择地块");
        datas = new ArrayList();
        initData();
        lv.setAdapter(new KJAdapter<String>(lv,datas,R.layout.item_lv_checkarea) {

            @Override
            public void convert(AdapterHolder helper, String item, boolean isScrolling,int position) {
                super.convert(helper, item, isScrolling);
                TextView tvTitle=helper.getView(R.id.tv_title);
//                tvTitle.setText("kk"+item);
                MeasureGridView gv = helper.getView(R.id.gv_area);
                gv.setAdapter(new KJAdapter<String>(gv,datas,R.layout.item_gv_emptyarea) {
                    @Override
                    public void convert(AdapterHolder helper, String item, boolean isScrolling) {
                        super.convert(helper, item, isScrolling);
                        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SelectareaActivity.launch(Checkarea.this);
                            }
                        });
                    }
                });
            }
        });
    }

    private void initData() {
        for(int i=0;i<10;i++){
            datas.add(i+"");
        }
    }
}
