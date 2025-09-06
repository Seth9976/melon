package com.iloen.melon.popup;

import androidx.compose.runtime.l;
import ie.H;
import ie.f;
import java.util.List;
import r0.q;
import we.k;
import we.n;

public final class i implements n {
    public final int a;
    public final List b;
    public final int c;
    public final int d;
    public final f e;
    public final boolean f;
    public final q g;
    public final int h;
    public final int i;

    public i(List list0, int v, int v1, n n0, boolean z, q q0, int v2, int v3, int v4) {
        this.a = v4;
        this.b = list0;
        this.c = v;
        this.d = v1;
        this.e = n0;
        this.f = z;
        this.g = q0;
        this.h = v2;
        this.i = v3;
        super();
    }

    public i(List list0, int v, int v1, boolean z, k k0, q q0, int v2, int v3) {
        this.a = 2;
        super();
        this.b = list0;
        this.c = v;
        this.d = v1;
        this.f = z;
        this.e = k0;
        this.g = q0;
        this.h = v2;
        this.i = v3;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).intValue();
                CommonFilterPopupKt.CommonFilterListTwoDepthAlyac(this.b, this.c, this.d, ((n)this.e), this.f, this.g, ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)), this.i);
                return H.a;
            }
            case 1: {
                ((Integer)object1).intValue();
                CommonFilterPopupKt.CommonFilterListTowDepthHorizontal(this.b, this.c, this.d, ((n)this.e), this.f, this.g, ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)), this.i);
                return H.a;
            }
            default: {
                ((Integer)object1).intValue();
                CommonFilterPopupKt.CommonFilterList(this.b, this.c, this.d, this.f, ((k)this.e), this.g, ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)), this.i);
                return H.a;
            }
        }
    }
}

