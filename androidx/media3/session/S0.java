package androidx.media3.session;

import b3.O;
import b3.P;
import b3.S;

public final class s0 implements t, P {
    public final MediaSessionService a;
    public final y0 b;

    public s0(MediaSessionService mediaSessionService0, y0 y00) {
        this.a = mediaSessionService0;
        this.b = y00;
    }

    @Override  // b3.P
    public final void M(S s0, O o0) {
        if(o0.a.a(new int[]{4, 5, 14, 0})) {
            this.a.h(this.b, false);
        }
    }

    @Override  // androidx.media3.session.t
    public final void a() {
        this.a.h(this.b, false);
    }

    @Override  // androidx.media3.session.t
    public final void d() {
        MediaSessionService mediaSessionService0 = this.a;
        y0 y00 = this.b;
        if(mediaSessionService0.e(y00)) {
            mediaSessionService0.i(y00);
        }
        mediaSessionService0.h(y00, false);
    }

    @Override  // androidx.media3.session.t
    public final void s() {
        this.a.h(this.b, false);
    }
}

