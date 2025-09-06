package com.iloen.melon.fragments.tabs;

import androidx.fragment.app.I;

public final class a implements Runnable {
    public final int a;
    public final BottomTabBaseFragment b;
    public final I c;
    public final I d;

    public a(BottomTabBaseFragment bottomTabBaseFragment0, I i0, I i1, int v) {
        this.a = v;
        this.b = bottomTabBaseFragment0;
        this.c = i0;
        this.d = i1;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            BottomTabBaseFragment.m(this.b, this.c, this.d);
            return;
        }
        BottomTabBaseFragment.n(this.b, this.c, this.d);
    }
}

