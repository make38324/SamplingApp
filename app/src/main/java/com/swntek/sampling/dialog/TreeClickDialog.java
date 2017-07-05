package com.swntek.sampling.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.swntek.sampling.active.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mac on 17/7/5.
 */
public class TreeClickDialog extends Dialog {
    @BindView(R.id.dialog_title)
    TextView dialogTitle;
    private String title;

    public TreeClickDialog(Context context, String title) {
        super(context, R.style.dialog);
        this.title = title;
    }

    public TreeClickDialog(Context context, int themeResId) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treeinfo);
        ButterKnife.bind(this);
        dialogTitle.setText(title);
    }
}
