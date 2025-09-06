package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ToggleButton;

public final class p implements View.OnClickListener {
    public final int a;
    public final LyricHighLightShareFragment b;
    public final ToggleButton c;

    public p(LyricHighLightShareFragment lyricHighLightShareFragment0, ToggleButton toggleButton0, int v) {
        this.a = v;
        this.b = lyricHighLightShareFragment0;
        this.c = toggleButton0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                LyricHighLightShareFragment.initView$lambda$21$lambda$4(this.b, this.c, view0);
                return;
            }
            case 1: {
                LyricHighLightShareFragment.initView$lambda$21$lambda$6(this.b, this.c, view0);
                return;
            }
            case 2: {
                LyricHighLightShareFragment.initView$lambda$21$lambda$8(this.b, this.c, view0);
                return;
            }
            case 3: {
                LyricHighLightShareFragment.initView$lambda$21$lambda$12(this.b, this.c, view0);
                return;
            }
            case 4: {
                LyricHighLightShareFragment.initView$lambda$21$lambda$14(this.b, this.c, view0);
                return;
            }
            case 5: {
                LyricHighLightShareFragment.initView$lambda$21$lambda$16(this.b, this.c, view0);
                return;
            }
            default: {
                LyricHighLightShareFragment.initView$lambda$21$lambda$18(this.b, this.c, view0);
            }
        }
    }
}

