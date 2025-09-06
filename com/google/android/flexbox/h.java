package com.google.android.flexbox;

import androidx.appcompat.app.o;

public final class h {
    public int a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LayoutState{mAvailable=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", mFlexLinePosition=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", mPosition=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", mOffset=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", mScrollingOffset=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", mLastScrollDelta=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", mItemDirection=1, mLayoutDirection=");
        return o.q(stringBuilder0, this.h, '}');
    }
}

