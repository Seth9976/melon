package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e2.a;

public final class d extends a {
    public final int g;
    public final BottomAppBar h;

    public d(BottomAppBar bottomAppBar0, int v) {
        this.h = bottomAppBar0;
        this.g = v;
    }

    @Override  // e2.a
    public final void N(FloatingActionButton floatingActionButton0) {
        floatingActionButton0.setTranslationX(this.h.E(this.g));
        floatingActionButton0.l(new c(), true);  // 初始化器: Ljava/lang/Object;-><init>()V
    }
}

