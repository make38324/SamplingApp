package com.swntek.sampling.active;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddRepertoryActivity extends BaseActivity implements TextWatcher{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.rb_jing)
    RadioButton rbJing;
    @BindView(R.id.rb_ping)
    RadioButton rbPing;
    @BindView(R.id.rg_type)
    RadioGroup rgType;
    @BindView(R.id.et_space)
    EditText etSpace;
    @BindView(R.id.et_type)
    EditText etType;
    @BindView(R.id.tv_next)
    TextView tvNext;
    boolean ischeck;

    public static void launch(Context context) {
        Intent intent = new Intent(context, AddRepertoryActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_repertory);
        ButterKnife.bind(this);
        assignTitleBar("输入种植方式");
        checknull(etSpace,etType);
    }

    public void setNextState() {
        if (ischeck) {
            tvNext.setBackgroundColor(getResources().getColor(R.color.mainback));
        } else {
            tvNext.setBackgroundColor(getResources().getColor(R.color.uncheck));
        }
    }

    @OnClick(R.id.tv_next)
    public void onClick() {
        Checkarea.launch(this);
    }
    public void checknull(EditText... views){
        for(EditText v:views){
            v.addTextChangedListener(this);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        ischeck=!TextUtils.isEmpty(etType.getText())&&!TextUtils.isEmpty(etSpace.getText());
        setNextState();
    }
}
