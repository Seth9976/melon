package com.kakao.emoticon.ui;

import android.view.View.OnClickListener;
import android.view.View;

public abstract class DoubleClickListener implements View.OnClickListener {
    private static final long DOUBLE_CLICK_TIME_DELTA = 800L;
    private long lastClickTime;

    public DoubleClickListener() {
        this.lastClickTime = 0L;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        long v = System.currentTimeMillis();
        if(v - this.lastClickTime < 800L) {
            this.onDoubleClick(view0);
            this.lastClickTime = 0L;
            return;
        }
        this.onSingleClick(view0);
        this.lastClickTime = v;
    }

    public abstract void onDoubleClick(View arg1);

    public abstract void onSingleClick(View arg1);
}

