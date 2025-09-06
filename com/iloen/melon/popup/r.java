package com.iloen.melon.popup;

import androidx.compose.runtime.l;
import e1.x;
import ie.H;
import r0.q;
import we.a;
import we.n;

public final class r implements n {
    public final int a;
    public final q b;
    public final a c;
    public final int d;
    public final int e;

    public r(q q0, a a0, int v, int v1) {
        this.a = 1;
        super();
        this.b = q0;
        this.c = a0;
        this.d = v;
        this.e = v1;
    }

    public r(a a0, q q0, int v, int v1) {
        this.a = 0;
        super();
        this.c = a0;
        this.b = q0;
        this.d = v;
        this.e = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            x.u(this.c, this.b, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)), this.e);
            return H.a;
        }
        ((Integer)object1).intValue();
        CommonFilterPopupKt.CommonFilterCloseBtn(this.c, this.b, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)), this.e);
        return H.a;
    }
}

