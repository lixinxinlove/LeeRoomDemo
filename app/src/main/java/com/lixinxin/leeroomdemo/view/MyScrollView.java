package com.lixinxin.leeroomdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.lixinxin.leeroomdemo._interface.OnSizeChangedListener;

/**
 * Created by lixinxin on 2017/12/5.
 */

public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (listener != null) {
            listener.onSizeChanged(t,oldt);
        }
    }

    private OnSizeChangedListener listener;

    public void setOnSizeChangedListener(OnSizeChangedListener listener) {
        this.listener = listener;
    }

}
