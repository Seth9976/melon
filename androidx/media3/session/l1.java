package androidx.media3.session;

import com.iloen.melon.utils.a;

public final class l1 implements Runnable {
    public final int a;
    public final m1 b;
    public final int c;

    public l1(m1 m10, int v, int v1) {
        this.a = v1;
        this.b = m10;
        this.c = v;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            o1 o10 = (o1)this.b.g;
            if(o10.Y(26) || o10.Y(34)) {
                int v = this.c;
                if(v != -100) {
                    switch(v) {
                        case -1: {
                            if(o10.Y(34)) {
                                o10.n(1);
                                return;
                            }
                            o10.e();
                            return;
                        }
                        case 1: {
                            if(o10.Y(34)) {
                                o10.f(1);
                                return;
                            }
                            o10.r();
                            return;
                        }
                        case 100: {
                            if(o10.Y(34)) {
                                o10.d(1, false);
                                return;
                            }
                            o10.q(false);
                            return;
                        }
                        case 101: {
                            if(o10.Y(34)) {
                                o10.d(1, !o10.r0());
                                return;
                            }
                            o10.q(!o10.r0());
                            return;
                        }
                        default: {
                            a.r(v, "onAdjustVolume: Ignoring unknown direction: ", "VolumeProviderCompat");
                            return;
                        }
                    }
                }
                if(o10.Y(34)) {
                    o10.d(1, true);
                    return;
                }
                o10.q(true);
            }
            return;
        }
        o1 o11 = (o1)this.b.g;
        if(o11.Y(25) || o11.Y(33)) {
            boolean z = o11.Y(33);
            int v1 = this.c;
            if(z) {
                o11.C(v1, 1);
                return;
            }
            o11.Q(v1);
        }
    }
}

