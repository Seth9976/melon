package Y3;

import R6.d;
import androidx.media3.session.O;
import androidx.media3.session.Q;
import androidx.media3.session.c1;
import androidx.media3.session.e1;
import androidx.media3.session.f1;
import androidx.media3.session.n0;
import androidx.media3.session.o1;
import androidx.media3.session.w0;
import e3.b;
import e3.e;
import e3.j;
import i3.a;
import java.util.HashMap;
import java.util.List;
import s3.z;

public final class m implements O, c1, e1, e, j {
    public final int a;
    public final long b;
    public final Object c;

    public m(int v, long v1, Object object0) {
        this.c = object0;
        this.a = v;
        this.b = v1;
        super();
    }

    public m(n n0, long v, int v1) {
        this.c = n0;
        this.b = v;
        this.a = v1;
    }

    public m(a a0, int v, long v1, long v2) {
        this.c = a0;
        this.a = v;
        this.b = v1;
    }

    @Override  // e3.e
    public void accept(Object object0) {
        n n0 = (n)this.c;
        b.k(n0.h);
        byte[] arr_b = d.r(((Y3.a)object0).a, ((Y3.a)object0).c);
        n0.c.getClass();
        n0.c.E(arr_b, arr_b.length);
        boolean z = false;
        n0.a.d(n0.c, arr_b.length, 0);
        long v = ((Y3.a)object0).b;
        long v1 = this.b;
        if(Long.compare(v, 0x8000000000000001L) == 0) {
            if(n0.h.s == 0x7FFFFFFFFFFFFFFFL) {
                z = true;
            }
            b.j(z);
        }
        else {
            long v2 = n0.h.s;
            v1 = v2 == 0x7FFFFFFFFFFFFFFFL ? v1 + v : v + v2;
        }
        n0.a.c(v1, this.a, arr_b.length, 0, null);
    }

    @Override  // androidx.media3.session.O
    public void d(androidx.media3.session.m m0, int v) {
        m0.R(((Q)this.c).c, v, this.a, this.b);
    }

    @Override  // androidx.media3.session.e1
    public Object e(n0 n00, w0 w00, int v) {
        List list0 = (List)this.c;
        int v1 = this.a == -1 ? n00.t.L() : this.a;
        return this.a == -1 ? n00.A(w00, list0, v1, n00.t.getCurrentPosition()) : n00.A(w00, list0, v1, this.b);
    }

    @Override  // androidx.media3.session.c1
    public void f(o1 o10, w0 w00) {
        o10.seekTo(((f1)this.c).G0(w00, o10, this.a), this.b);
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        a a0 = (a)this.c;
        HashMap hashMap0 = ((i3.j)(((i3.b)object0))).g;
        HashMap hashMap1 = ((i3.j)(((i3.b)object0))).h;
        z z0 = a0.d;
        if(z0 != null) {
            String s = ((i3.j)(((i3.b)object0))).b.c(a0.b, z0);
            Long long0 = (Long)hashMap1.get(s);
            Long long1 = (Long)hashMap0.get(s);
            long v = 0L;
            hashMap1.put(s, ((long)((long0 == null ? 0L : ((long)long0)) + this.b)));
            if(long1 != null) {
                v = (long)long1;
            }
            hashMap0.put(s, ((long)(v + ((long)this.a))));
        }
    }
}

