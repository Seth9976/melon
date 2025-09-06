package com.kakao.emoticon.ui.tab;

import android.view.animation.Interpolator;

public final class d implements Interpolator {
    public final int a;

    public d(int v) {
        this.a = v;
        super();
    }

    @Override  // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return this.a == 0 ? TabItemTouchHelperCallback.a(f) : TabItemTouchHelperCallback.b(f);
    }
}

