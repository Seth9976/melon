package bd;

import Bc.d;
import Cc.c1;
import Cc.e0;
import M.v;
import P0.h;
import P0.j;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.c;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import ie.H;
import ie.m;
import r0.i;
import r0.n;
import r0.q;
import r1.f;
import wc.u;
import we.a;
import we.o;
import y0.M;
import y0.s;

public final class g implements o {
    public final long a;
    public final a b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final Content f;

    public g(long v, a a0, boolean z, String s, boolean z1, Content flexibleRes$RESPONSE$Flexible$Content0) {
        this.a = v;
        this.b = a0;
        this.c = z;
        this.d = s;
        this.e = z1;
        this.f = flexibleRes$RESPONSE$Flexible$Content0;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        Content flexibleRes$RESPONSE$Flexible$Content2;
        p p1;
        long v3;
        q q4;
        Content flexibleRes$RESPONSE$Flexible$Content1;
        int v = (int)(((Integer)object2));
        kotlin.jvm.internal.q.g(((v)object0), "$this$BoxWithConstraints");
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
        }
        p p0 = (p)(((l)object1));
        if(p0.Q(v & 1, (v & 19) != 18)) {
            b b0 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            q q0 = b0.b();
            long v1 = this.a;
            q q1 = androidx.compose.foundation.q.f(q0, v1, M.a);
            a a0 = this.b;
            boolean z = p0.g(a0);
            d d0 = p0.N();
            if(z || d0 == k.a) {
                d0 = new d(16, a0);
                p0.l0(d0);
            }
            q q2 = androidx.compose.foundation.q.n(q1, null, d0, 7);
            i i0 = r0.d.b;
            N0.M m0 = M.p.d(i0, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q3, j.d);
            float f = ((c)(((v)object0))).b();
            Content flexibleRes$RESPONSE$Flexible$Content0 = this.f;
            String s = "";
            n n0 = n.a;
            if(this.c) {
                String s1 = this.d;
                if(s1.length() > 0) {
                    p0.a0(-844980753);
                    if(this.e) {
                        f f1 = new f(f * 9.0f / 16.0f);
                        flexibleRes$RESPONSE$Flexible$Content1 = flexibleRes$RESPONSE$Flexible$Content0;
                        f f2 = new f(400.0f);
                        if(f1.compareTo(f2) > 0) {
                            f1 = f2;
                        }
                        q4 = b0.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), f1.a), i0);
                    }
                    else {
                        flexibleRes$RESPONSE$Flexible$Content1 = flexibleRes$RESPONSE$Flexible$Content0;
                        q4 = b0.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), f * 9.0f / 16.0f), i0);
                    }
                    q q5 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), f - 170.0f);
                    String s2 = flexibleRes$RESPONSE$Flexible$Content1.getImgUrl();
                    if(s2 != null) {
                        s = s2;
                    }
                    v3 = v1;
                    E.a(q4, q5, s1, s, String.valueOf(s1.hashCode()), e0.a0(((c)(((v)object0))).b(), p0), p0, 0x30000);
                    p1 = p0;
                    p1.p(false);
                }
                else {
                    flexibleRes$RESPONSE$Flexible$Content2 = flexibleRes$RESPONSE$Flexible$Content0;
                    p1 = p0;
                    v3 = v1;
                    goto label_69;
                }
            }
            else {
                flexibleRes$RESPONSE$Flexible$Content2 = flexibleRes$RESPONSE$Flexible$Content0;
                p1 = p0;
                v3 = v1;
            label_69:
                p1.a0(0xCDB1C605);
                q q6 = b0.a(androidx.compose.foundation.layout.d.h(n0, f - 170.0f), i0);
                String s3 = flexibleRes$RESPONSE$Flexible$Content2.getImgUrl();
                c1.n(q6, (s3 == null ? "" : s3), null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p1, 0x6C00, 0, 0x7FE4);
                p1.p(false);
            }
            M.p.a(androidx.compose.foundation.q.e(b0.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 280.0f), r0.d.h), u.g(new m[]{new m(0.0f, new s(s.c(v3, 0.0f))), new m(0.1f, new s(s.c(v3, 0.0f))), new m(0.1f, new s(s.c(v3, 0.0f))), new m(0.28f, new s(s.c(v3, 0.75f))), new m(0.28f, new s(s.c(v3, 0.75f))), new m(0.34f, new s(s.c(v3, 0.95f))), new m(0.34f, new s(s.c(v3, 0.95f))), new m(0.38f, new s(s.c(v3, 1.0f))), new m(0.38f, new s(s.c(v3, 1.0f))), new m(1.0f, new s(s.c(v3, 1.0f)))}), null, 6), p1, 0);
            p1.p(true);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

