package com.iloen.melon.custom;

import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;

public final class q1 implements Animation.AnimationListener {
    public final int a;
    public final ToolBar b;

    public q1(ToolBar toolBar0, int v) {
        this.a = v;
        this.b = toolBar0;
        super();
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationEnd(Animation animation0) {
        if(this.a != 0) {
            LogU.d("ToolBar", "onAnimationEnd() hide down");
            ToolBar toolBar0 = this.b;
            r1 r10 = toolBar0.h;
            if(r10 != null) {
                r10.onToolBarAnimationEnd(false);
            }
            for(Object object0: toolBar0.i) {
                ViewUtils.setOnClickListener(((ToolBarItem)object0).b, null);
            }
            toolBar0.setVisibility(8);
            return;
        }
        LogU.d("ToolBar", "onAnimationEnd() show up");
        ToolBar toolBar1 = this.b;
        r1 r11 = toolBar1.h;
        if(r11 != null) {
            r11.onToolBarAnimationEnd(true);
        }
        toolBar1.c.setContentDescription(String.format("하단 툴바, 총 %1$s 곡 선택됨", toolBar1.d.getText().toString()));
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationRepeat(Animation animation0) {
        if(this.a != 0) {
            LogU.d("ToolBar", "onAnimationRepeat() hide down");
            return;
        }
        LogU.d("ToolBar", "onAnimationRepeat() show up");
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationStart(Animation animation0) {
        if(this.a != 0) {
            LogU.d("ToolBar", "onAnimationStart() hide down");
            r1 r10 = this.b.h;
            if(r10 != null) {
                r10.onToolBarAnimationStart(false);
            }
            return;
        }
        LogU.d("ToolBar", "onAnimationStart() show up");
        r1 r11 = this.b.h;
        if(r11 != null) {
            r11.onToolBarAnimationStart(true);
        }
    }
}

