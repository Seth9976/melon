package Nb;

import Cb.i;
import H0.e;
import androidx.media3.session.w0;
import androidx.media3.session.y0;
import ie.H;
import we.k;

public final class q implements k {
    public final int a;
    public final y0 b;
    public final w0 c;
    public final h0 d;

    public q(y0 y00, w0 w00, h0 h00, int v) {
        this.a = v;
        this.b = y00;
        this.c = w00;
        this.d = h00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            kotlin.jvm.internal.q.g(((StringBuilder)object0), "$this$buildDebug");
            ((StringBuilder)object0).append("onConnect() " + ("MediaSession[" + this.b.a.j + "]"));
            i.a(((StringBuilder)object0), e.t(this.c));
            this.d.getClass();
            return H.a;
        }
        kotlin.jvm.internal.q.g(((StringBuilder)object0), "$this$buildDebug");
        ((StringBuilder)object0).append("onDisconnected() " + ("MediaSession[" + this.b.a.j + "]"));
        i.a(((StringBuilder)object0), e.t(this.c));
        this.d.getClass();
        return H.a;
    }
}

