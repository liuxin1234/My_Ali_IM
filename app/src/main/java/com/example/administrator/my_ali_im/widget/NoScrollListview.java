package com.example.administrator.my_ali_im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 项目：My_Ali_IM
 * 作者：Administrator
 * 时间：2017/7/19
 * 功能：
 */

public class NoScrollListview extends ListView {

    public NoScrollListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }

}
