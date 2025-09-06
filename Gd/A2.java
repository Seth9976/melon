package gd;

import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import com.iloen.melon.custom.l1;
import d5.w;
import df.d;
import e1.b;
import e1.m;
import e1.n;
import e1.u;
import e1.x;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import we.k;
import we.p;

public final class a2 extends r implements p {
    public final int f;
    public final ArrayList g;
    public final k h;

    public a2(ArrayList arrayList0, k k0, int v) {
        this.f = v;
        this.g = arrayList0;
        this.h = k0;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        switch(this.f) {
            case 0: {
                int v3 = ((Number)object1).intValue();
                int v4 = ((Number)object3).intValue();
                int v5 = (v4 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v4 : v4;
                if((v4 & 0x30) == 0) {
                    v5 |= (((androidx.compose.runtime.p)(((l)object2))).e(v3) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v5 & 1, (v5 & 0x93) != 0x92)) {
                    e2 e20 = (e2)this.g.get(v3);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(998656029);
                    if(e20 instanceof d2) {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(998728940);
                        w.f(((d2)e20), ((androidx.compose.runtime.p)(((l)object2))), 0);
                        ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    }
                    else {
                        k k0 = this.h;
                        if(e20 instanceof b2) {
                            ((androidx.compose.runtime.p)(((l)object2))).a0(998892000);
                            w.c(((b2)e20), k0, ((androidx.compose.runtime.p)(((l)object2))), 0);
                            ((androidx.compose.runtime.p)(((l)object2))).p(false);
                        }
                        else if(e20 instanceof c2) {
                            ((androidx.compose.runtime.p)(((l)object2))).a0(999069661);
                            w.d(((c2)e20), k0, ((androidx.compose.runtime.p)(((l)object2))), 0);
                            ((androidx.compose.runtime.p)(((l)object2))).p(false);
                        }
                        else {
                            throw l1.c(((androidx.compose.runtime.p)(((l)object2))), 0xE0E34CA6, false);
                        }
                    }
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 1: {
                int v6 = ((Number)object1).intValue();
                int v7 = ((Number)object3).intValue();
                int v8 = (v7 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v7 : v7;
                if((v7 & 0x30) == 0) {
                    v8 |= (((androidx.compose.runtime.p)(((l)object2))).e(v6) ? 0x20 : 16);
                }
                androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)(((l)object2));
                if(p0.Q(v8 & 1, (v8 & 0x93) != 0x92)) {
                    B2 b20 = (B2)this.g.get(v6);
                    p0.a0(0xDACE17FD);
                    B b0 = (B)je.p.m0(b20.b);
                    k k1 = this.h;
                    if(b0 instanceof A) {
                        p0.a0(0xDACF5B10);
                        u.a(b20, k1, p0, 0);
                        p0.p(false);
                    }
                    else {
                        if(b0 instanceof v) {
                            p0.a0(-623782008);
                            b.b(b20, k1, p0, 0);
                            p0.p(false);
                            p0.p(false);
                            return H.a;
                        }
                        if(b0 instanceof y) {
                            p0.a0(-623517082);
                            u.e(b20, k1, p0, 0);
                            p0.p(false);
                            p0.p(false);
                            return H.a;
                        }
                        if(b0 instanceof z) {
                            p0.a0(0xDAD9BCF3);
                            x.k(b20, k1, p0, 0);
                            p0.p(false);
                            p0.p(false);
                            return H.a;
                        }
                        if(b0 instanceof gd.x) {
                            p0.a0(-623020400);
                            m.e(b20, k1, p0, 0);
                            p0.p(false);
                            p0.p(false);
                            return H.a;
                        }
                        if(b0 instanceof gd.w) {
                            p0.a0(-622765208);
                            n.e(b20, k1, p0, 0);
                            p0.p(false);
                            p0.p(false);
                            return H.a;
                        }
                        if(b0 instanceof gd.u) {
                            p0.a0(0xDAE53652);
                            e.k.b(b20, k1, p0, 0);
                            p0.p(false);
                            p0.p(false);
                            return H.a;
                        }
                        if(b0 instanceof t) {
                            p0.a0(0xDAE90BAA);
                            d.d(b20, k1, p0, 0);
                            p0.p(false);
                        }
                        else if(b0 == null) {
                            p0.a0(0xDAEC0403);
                            p0.p(false);
                        }
                        else {
                            throw l1.c(p0, 0x93720731, false);
                        }
                    }
                    p0.p(false);
                    return H.a;
                }
                p0.T();
                return H.a;
            }
            default: {
                int v = ((Number)object1).intValue();
                int v1 = ((Number)object3).intValue();
                int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    r4 r40 = (r4)this.g.get(v);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(1398504236);
                    if(r40 instanceof q4) {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x535C841F);
                        df.v.b(((q4)r40), v, this.h, ((androidx.compose.runtime.p)(((l)object2))), v2 & 0x70);
                    }
                    else if(r40 instanceof p4) {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x535EF117);
                        df.v.a(((p4)r40), ((androidx.compose.runtime.p)(((l)object2))), 0);
                    }
                    else {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x52CDF619);
                    }
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
        }
    }
}

