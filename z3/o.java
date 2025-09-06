package z3;

import androidx.media3.exoplayer.g;
import androidx.media3.exoplayer.y;
import ea.b;
import i3.c;
import i3.e;
import s3.z;

public final class o implements Runnable {
    public final int a;
    public final b b;

    public o(b b0, int v, long v1) {
        this.a = 1;
        super();
        this.b = b0;
    }

    public o(b b0, long v, int v1) {
        this.a = 2;
        super();
        this.b = b0;
    }

    public o(b b0, androidx.media3.common.b b1, g g0) {
        this.a = 5;
        super();
        this.b = b0;
    }

    public o(b b0, Object object0, int v) {
        this.a = v;
        this.b = b0;
        super();
    }

    public o(b b0, String s, long v, long v1) {
        this.a = 0;
        super();
        this.b = b0;
    }

    @Override
    public final void run() {
        b b0 = this.b;
        switch(this.a) {
            case 0: {
                e e1 = ((y)b0.b).a.s;
                e1.v(e1.u(), 0x3F8, new c(28));
                return;
            }
            case 1: {
                e e2 = ((y)b0.b).a.s;
                e2.v(e2.q(((z)e2.d.e)), 0x3FA, new c(20));
                return;
            }
            case 2: {
                e e3 = ((y)b0.b).a.s;
                e3.v(e3.q(((z)e3.d.e)), 0x3FD, new c(22));
                return;
            }
            case 3: {
                e e4 = ((y)b0.b).a.s;
                e4.v(e4.u(), 1030, new c(15));
                return;
            }
            case 4: {
                e e5 = ((y)b0.b).a.s;
                e5.v(e5.u(), 0x3F7, new c(26));
                return;
            }
            case 5: {
                e e6 = ((y)b0.b).a.s;
                e6.v(e6.u(), 0x3F9, new c(24));
                return;
            }
            default: {
                e e0 = ((y)b0.b).a.s;
                e0.v(e0.u(), 0x3FB, new c(18));
            }
        }
    }
}

