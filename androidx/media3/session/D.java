package androidx.media3.session;

import I6.G0;
import I6.J;
import I6.b0;
import Nb.h0;
import androidx.media3.exoplayer.x;
import com.iloen.melon.utils.log.LogConstantsKt;
import kotlin.jvm.internal.q;

public final class d implements Runnable {
    public final int a;
    public final n0 b;
    public final w0 c;

    public d(n0 n00, w0 w00, int v) {
        this.a = v;
        this.b = n00;
        this.c = w00;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                n0 n00 = this.b;
                if(!n00.l()) {
                    J j0 = n00.H;
                    w0 w00 = this.c;
                    w00.d.getClass();
                    G0 g00 = b0.p(j0.k(w00.d)).k();
                    while(g00.hasNext()) {
                        Object object0 = g00.next();
                        w00.d.getClass();
                        n00.G.c(((String)object0), w00);
                        j0.c(w00.d, ((String)object0));
                    }
                    if(!n00.A) {
                    label_20:
                        ((h0)n00.e).getClass();
                        q.g(n00.k, "session");
                        Nb.q q0 = new Nb.q(n00.k, w00, ((h0)n00.e), 0);
                        LogConstantsKt.buildDebug$default(((h0)n00.e).h, false, q0, 1, null);
                    }
                    else if(!n0.m(w00)) {
                        if(n00.k(w00)) {
                            n00.A = false;
                        }
                        goto label_20;
                    }
                }
                return;
            }
            case 1: {
                a0 a01 = f1.K0(new x(20));
                this.b.g.I0(this.c, 0x80000000, 9, a01);
                return;
            }
            case 2: {
                a0 a02 = f1.K0(new x(17));
                this.b.g.I0(this.c, 0x80000000, 7, a02);
                return;
            }
            case 3: {
                a0 a03 = f1.K0(new x(19));
                this.b.g.I0(this.c, 0x80000000, 12, a03);
                return;
            }
            case 4: {
                a0 a04 = f1.K0(new x(16));
                this.b.g.I0(this.c, 0x80000000, 11, a04);
                return;
            }
            case 5: {
                a0 a05 = f1.K0(new x(24));
                this.b.g.I0(this.c, 0x80000000, 3, a05);
                return;
            }
            case 6: {
                a0 a06 = f1.K0(new x(13));
                this.b.g.I0(this.c, 0x80000000, 1, a06);
                return;
            }
            case 7: {
                this.b.g.getClass();
                a0 a07 = f1.K0(new H0(3, this.b.g, this.c));
                this.b.g.I0(this.c, 0x80000000, 1, a07);
                return;
            }
            case 8: {
                this.b.g.getClass();
                a0 a08 = f1.K0(new H0(3, this.b.g, this.c));
                this.b.g.I0(this.c, 0x80000000, 1, a08);
                return;
            }
            default: {
                a0 a00 = f1.K0(new x(13));
                this.b.g.I0(this.c, 0x80000000, 1, a00);
            }
        }
    }
}

