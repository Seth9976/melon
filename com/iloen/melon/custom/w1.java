package com.iloen.melon.custom;

import android.view.View.OnClickListener;
import android.view.View;

public final class w1 implements View.OnClickListener {
    public final int a;
    public final VideoEndingView b;

    public w1(VideoEndingView videoEndingView0, int v) {
        this.a = v;
        this.b = videoEndingView0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        VideoEndingView videoEndingView0 = this.b;
        if(this.a != 0) {
            videoEndingView0.c();
            y1 y10 = videoEndingView0.B;
            if(y10 != null) {
                y10.onCancel();
            }
            return;
        }
        y1 y11 = videoEndingView0.B;
        if(y11 != null) {
            y11.onPlay((videoEndingView0.D == null ? null : videoEndingView0.D.a));
        }
    }
}

