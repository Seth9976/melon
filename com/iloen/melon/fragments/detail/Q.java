package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;

public final class q implements View.OnClickListener {
    public final int a;
    public final LyricHighLightShareFragment b;

    public q(LyricHighLightShareFragment lyricHighLightShareFragment0, int v) {
        this.a = v;
        this.b = lyricHighLightShareFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            LyricHighLightShareFragment.initView$lambda$21$lambda$20(this.b, view0);
            return;
        }
        LyricHighLightShareFragment.initView$lambda$21$lambda$10(this.b, view0);
    }
}

