package com.google.android.flexbox;

import H0.b;

public final class f {
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final FlexboxLayoutManager h;

    public f(FlexboxLayoutManager flexboxLayoutManager0) {
        this.h = flexboxLayoutManager0;
        this.d = 0;
    }

    public static void a(f f0) {
        FlexboxLayoutManager flexboxLayoutManager0 = f0.h;
        if(!flexboxLayoutManager0.m() && flexboxLayoutManager0.e) {
            f0.c = f0.e ? flexboxLayoutManager0.m.g() : flexboxLayoutManager0.getWidth() - flexboxLayoutManager0.m.k();
            return;
        }
        f0.c = f0.e ? flexboxLayoutManager0.m.g() : flexboxLayoutManager0.m.k();
    }

    public static void b(f f0) {
        f0.a = -1;
        f0.b = -1;
        f0.c = 0x80000000;
        boolean z = false;
        f0.f = false;
        f0.g = false;
        FlexboxLayoutManager flexboxLayoutManager0 = f0.h;
        if(flexboxLayoutManager0.m()) {
            int v = flexboxLayoutManager0.b;
            if(v == 0) {
                if(flexboxLayoutManager0.a == 1) {
                    z = true;
                }
                f0.e = z;
                return;
            }
            if(v == 2) {
                z = true;
            }
            f0.e = z;
            return;
        }
        int v1 = flexboxLayoutManager0.b;
        if(v1 == 0) {
            if(flexboxLayoutManager0.a == 3) {
                z = true;
            }
            f0.e = z;
            return;
        }
        if(v1 == 2) {
            z = true;
        }
        f0.e = z;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AnchorInfo{mPosition=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", mFlexLinePosition=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", mCoordinate=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", mPerpendicularCoordinate=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", mLayoutFromEnd=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", mValid=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", mAssignedFromSavedState=");
        return b.k(stringBuilder0, this.g, '}');
    }
}

