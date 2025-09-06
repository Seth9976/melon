package androidx.media3.exoplayer;

import b3.P;
import e3.j;

public final class p implements j {
    public final int a;
    public final b0 b;

    public p(b0 b00, int v) {
        this.a = v;
        this.b = b00;
        super();
    }

    @Override  // e3.j
    public final void invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((P)object0).onLoadingChanged(this.b.g);
                ((P)object0).j0(this.b.g);
                return;
            }
            case 1: {
                ((P)object0).onPlayerStateChanged(this.b.l, this.b.e);
                return;
            }
            case 2: {
                ((P)object0).w(this.b.e);
                return;
            }
            case 3: {
                ((P)object0).p0(this.b.m, this.b.l);
                return;
            }
            case 4: {
                ((P)object0).onPlaybackSuppressionReasonChanged(this.b.n);
                return;
            }
            case 5: {
                ((P)object0).onIsPlayingChanged(this.b.k());
                return;
            }
            case 6: {
                ((P)object0).n(this.b.o);
                return;
            }
            case 7: {
                ((P)object0).p(this.b.f);
                return;
            }
            case 8: {
                ((P)object0).k0(this.b.f);
                return;
            }
            default: {
                ((P)object0).Y(this.b.i.d);
            }
        }
    }
}

