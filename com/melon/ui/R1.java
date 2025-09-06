package com.melon.ui;

import Sc.b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.e;

public final class r1 implements e {
    public final u1 a;

    public r1(u1 u10) {
        this.a = u10;
    }

    @Override  // com.google.android.material.appbar.e
    public final void onOffsetChanged(AppBarLayout appBarLayout0, int v) {
        ((b)this.a.getViewModel()).b = v == 0;
    }
}

