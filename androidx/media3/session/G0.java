package androidx.media3.session;

import I7.k;
import M6.B;
import M6.H;
import M6.r;
import M6.s;
import b3.E;
import e3.b;

public final class g0 implements r {
    public final int a;
    public final k0 b;

    public g0(k0 k00, int v) {
        this.a = v;
        this.b = k00;
        super();
    }

    @Override  // M6.r
    public final H apply(Object object0) {
        if(this.a != 0) {
            return k0.k(this.b, ((androidx.media3.session.r)object0));
        }
        b.h(((androidx.media3.session.r)object0), "LibraryResult must not be null");
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(((androidx.media3.session.r)object0).a == 0) {
            Object object1 = ((androidx.media3.session.r)object0).c;
            if(object1 != null) {
                byte[] arr_b = ((E)object1).d.k;
                if(arr_b == null) {
                    h0.k(q.a(((E)object1), null));
                    return h0;
                }
                B b0 = this.b.n.m.a(arr_b);
                h0.addListener(new h0(h0, b0, 0), s.a);
                b0.addListener(new k(b0, h0, ((E)object1), 12), s.a);
                return h0;
            }
        }
        h0.k(null);
        return h0;
    }
}

