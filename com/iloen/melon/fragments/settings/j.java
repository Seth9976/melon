package com.iloen.melon.fragments.settings;

import kotlin.jvm.internal.H;
import we.a;

public final class j implements a {
    public final int a;
    public final Object b;
    public final Object c;

    public j(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? SettingBannedContentsFragment.onToolBarClick$lambda$15$lambda$14(((SettingBannedContentsFragment)this.b), ((BannedContentsAdapter)this.c)) : SettingServerPhaseFragment.initView$lambda$1$lambda$0(((H)this.b), ((SettingServerPhaseFragment)this.c));
    }
}

