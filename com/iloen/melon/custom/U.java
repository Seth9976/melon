package com.iloen.melon.custom;

import android.view.animation.AnimationUtils;
import we.a;

public final class u implements a {
    public final int a;
    public final CrossFadingViewSwitcher b;

    public u(CrossFadingViewSwitcher crossFadingViewSwitcher0, int v) {
        this.a = v;
        this.b = crossFadingViewSwitcher0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? AnimationUtils.loadAnimation(this.b.getContext(), 0x10A0000) : AnimationUtils.loadAnimation(this.b.getContext(), 0x10A0001);
    }
}

