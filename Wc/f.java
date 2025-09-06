package wc;

import Ic.W;
import Ic.X;
import com.iloen.melon.net.v5x.response.DetailBaseRes.STATION;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;

public final class f implements a {
    public final int a;
    public final w b;
    public final STATION c;
    public final int d;

    public f(w w0, STATION detailBaseRes$STATION0, int v, int v1) {
        this.a = v1;
        this.b = w0;
        this.c = detailBaseRes$STATION0;
        this.d = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        int v = this.d;
        STATION detailBaseRes$STATION0 = this.c;
        w w0 = this.b;
        if(this.a != 0) {
            String s = detailBaseRes$STATION0.castSeq;
            q.f(s, "castSeq");
            String s1 = detailBaseRes$STATION0.castTitle;
            q.f(s1, "castTitle");
            w0.onUserEvent(new X(s, s1, v));
            return h0;
        }
        String s2 = detailBaseRes$STATION0.castSeq;
        q.f(s2, "castSeq");
        String s3 = detailBaseRes$STATION0.castTitle;
        q.f(s3, "castTitle");
        w0.onUserEvent(new W(s2, s3, v));
        return h0;
    }
}

