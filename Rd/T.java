package rd;

import E9.g;
import W.p;
import androidx.compose.runtime.b1;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import x1.d;
import x1.e;
import x1.n;

public final class t implements k {
    public final int a;
    public final b1 b;
    public final e c;
    public final e d;

    public t(b1 b10, e e0, e e1, int v) {
        this.a = v;
        this.b = b10;
        this.c = e0;
        this.d = e1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((d)object0), "$this$constrainAs");
            p p0 = ((d)object0).f;
            e e0 = ((d)object0).c;
            p.l(((d)object0).d, e0.d, 0.0f, 6);
            if(((Boolean)this.b.getValue()).booleanValue()) {
                p.l(p0, this.c.d, 0.0f, 6);
            }
            else {
                p.l(p0, this.d.d, 0.0f, 6);
            }
            g.v(((d)object0).g, e0.g, 25.0f, 4);
            ((d)object0).d(new n(null, "spread"));
            return H.a;
        }
        q.g(((d)object0), "$this$constrainAs");
        p p1 = ((d)object0).f;
        e e1 = ((d)object0).c;
        p.l(((d)object0).d, e1.d, 0.0f, 6);
        if(((Boolean)this.b.getValue()).booleanValue()) {
            p.l(p1, this.c.d, 0.0f, 6);
        }
        else {
            p.l(p1, this.d.d, 0.0f, 6);
        }
        g.v(((d)object0).e, e1.e, 0.0f, 6);
        g.v(((d)object0).g, e1.g, 0.0f, 6);
        ((d)object0).d(new n(null, "spread"));
        return H.a;
    }
}

