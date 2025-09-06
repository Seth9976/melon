package androidx.appcompat.app;

import c2.W;
import c2.c0;

public final class p implements Runnable {
    public final int a;
    public final D b;

    public p(D d0, int v) {
        this.a = v;
        this.b = d0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            D d0 = this.b;
            d0.M.showAtLocation(d0.I, 55, 0, 0);
            c0 c00 = d0.S;
            if(c00 != null) {
                c00.b();
            }
            if(d0.T && (d0.V != null && d0.V.isLaidOut())) {
                d0.I.setAlpha(0.0f);
                c0 c01 = W.a(d0.I);
                c01.a(1.0f);
                d0.S = c01;
                c01.d(new r(this, 0));
                return;
            }
            d0.I.setAlpha(1.0f);
            d0.I.setVisibility(0);
            return;
        }
        D d1 = this.b;
        if((d1.v0 & 1) != 0) {
            d1.w(0);
        }
        if((d1.v0 & 0x1000) != 0) {
            d1.w(108);
        }
        d1.u0 = false;
        d1.v0 = 0;
    }
}

