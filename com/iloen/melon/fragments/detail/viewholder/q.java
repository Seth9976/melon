package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;

public final class q implements View.OnClickListener {
    public final int a;
    public final String b;
    public final LyricHolder c;

    public q(LyricHolder lyricHolder0, String s, int v) {
        this.a = v;
        this.c = lyricHolder0;
        this.b = s;
        super();
    }

    public q(String s, LyricHolder lyricHolder0, int v) {
        this.a = v;
        this.b = s;
        this.c = lyricHolder0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                LyricHolder.c(this.c, this.b, view0);
                return;
            }
            case 1: {
                LyricHolder.b(this.c, this.b, view0);
                return;
            }
            case 2: {
                LyricHolder.onBindView$lambda$2(this.c, this.b, view0);
                return;
            }
            default: {
                LyricHolder.onBindView$lambda$3(this.c, this.b, view0);
            }
        }
    }
}

