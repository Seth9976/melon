package Ic;

import com.iloen.melon.net.v5x.response.DetailBaseRes.STATION;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;

public final class m0 implements a {
    public final int a;
    public final A0 b;
    public final STATION c;
    public final int d;

    public m0(A0 a00, STATION detailBaseRes$STATION0, int v, int v1) {
        this.a = v1;
        this.b = a00;
        this.c = detailBaseRes$STATION0;
        this.d = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        int v = this.d;
        STATION detailBaseRes$STATION0 = this.c;
        A0 a00 = this.b;
        if(this.a != 0) {
            String s = detailBaseRes$STATION0.castSeq;
            q.f(s, "castSeq");
            String s1 = detailBaseRes$STATION0.castTitle;
            q.f(s1, "castTitle");
            a00.onUserEvent(new X(s, s1, v));
            return h0;
        }
        String s2 = detailBaseRes$STATION0.castSeq;
        q.f(s2, "castSeq");
        String s3 = detailBaseRes$STATION0.castTitle;
        q.f(s3, "castTitle");
        a00.onUserEvent(new W(s2, s3, v));
        return h0;
    }
}

