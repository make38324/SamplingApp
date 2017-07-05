package com.swntek.sampling.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;


/**
 * Created by caozhimin on 2015/12/16.
 */
public class MeasureListView extends ListView {
    public MeasureListView(Context context) {
        // TODO Auto-generated method stub
        super(context);
    }

    public MeasureListView(Context context, AttributeSet attrs) {
        // TODO Auto-generated method stub
        super(context, attrs);
    }

    public MeasureListView(Context context, AttributeSet attrs, int defStyle) {
        // TODO Auto-generated method stub
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
