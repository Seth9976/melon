package j3;

import androidx.media3.common.b;
import androidx.media3.exoplayer.y;
import h4.c;
import i3.e;

public final class g implements Runnable {
    public final int a;
    public final E9.g b;

    public g(E9.g g0, int v, long v1, long v2) {
        this.a = 1;
        super();
        this.b = g0;
    }

    public g(E9.g g0, long v) {
        this.a = 9;
        super();
        this.b = g0;
    }

    public g(E9.g g0, b b0, androidx.media3.exoplayer.g g1) {
        this.a = 6;
        super();
        this.b = g0;
    }

    public g(E9.g g0, Object object0, int v) {
        this.a = v;
        this.b = g0;
        super();
    }

    public g(E9.g g0, String s, long v, long v1) {
        this.a = 7;
        super();
        this.b = g0;
    }

    @Override
    public final void run() {
        E9.g g0 = this.b;
        switch(this.a) {
            case 0: {
                e e1 = ((y)g0.b).a.s;
                e1.v(e1.u(), 0x407, new c(6));
                return;
            }
            case 1: {
                e e2 = ((y)g0.b).a.s;
                e2.v(e2.u(), 0x3F3, new c(24));
                return;
            }
            case 2: {
                e e3 = ((y)g0.b).a.s;
                e3.v(e3.u(), 0x408, new c(9));
                return;
            }
            case 3: {
                e e4 = ((y)g0.b).a.s;
                e4.v(e4.u(), 1007, new i3.c(13));
                return;
            }
            case 4: {
                e e5 = ((y)g0.b).a.s;
                e5.v(e5.u(), 0x405, new i3.c(27));
                return;
            }
            case 5: {
                e e6 = ((y)g0.b).a.s;
                e6.v(e6.u(), 0x3F6, new i3.c(29));
                return;
            }
            case 6: {
                e e7 = ((y)g0.b).a.s;
                e7.v(e7.u(), 1009, new i3.c(25));
                return;
            }
            case 7: {
                e e8 = ((y)g0.b).a.s;
                e8.v(e8.u(), 0x3F0, new i3.c(17));
                return;
            }
            case 8: {
                e e9 = ((y)g0.b).a.s;
                e9.v(e9.u(), 0x3F4, new i3.c(14));
                return;
            }
            default: {
                e e0 = ((y)g0.b).a.s;
                e0.v(e0.u(), 1010, new i3.c(16));
            }
        }
    }
}

