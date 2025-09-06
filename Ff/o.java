package Ff;

import A1.g;
import Df.B;
import Df.i;
import Pe.z;
import Q1.c;
import Sf.n;
import U4.F;
import e1.G;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.w;
import lf.A;
import lf.I;
import lf.V;
import lf.a;
import lf.h0;
import lf.h;
import nf.d;
import nf.f;
import qf.e;
import we.k;

public final class o implements k {
    public final int a;
    public final q b;

    public o(q q0, int v) {
        this.a = v;
        this.b = q0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                kotlin.jvm.internal.q.g(((e)object0), "it");
                a a1 = A.T;
                kotlin.jvm.internal.q.f(a1, "PARSER");
                r r1 = this.b.i;
                byte[] arr_b1 = (byte[])this.b.a.get(((e)object0));
                Collection collection0 = arr_b1 == null ? w.a : n.p0(n.l0(new Ac.k(a1, new ByteArrayInputStream(arr_b1), r1, 7)));
                ArrayList arrayList1 = new ArrayList(collection0.size());
                for(Object object2: collection0) {
                    Df.r r2 = (Df.r)r1.b.i;
                    kotlin.jvm.internal.q.d(((A)object2));
                    u u0 = r2.e(((A)object2));
                    if(!r1.r(u0)) {
                        u0 = null;
                    }
                    if(u0 != null) {
                        arrayList1.add(u0);
                    }
                }
                r1.j(arrayList1, ((e)object0));
                return Qf.k.d(arrayList1);
            }
            case 1: {
                kotlin.jvm.internal.q.g(((e)object0), "it");
                a a2 = I.Y;
                kotlin.jvm.internal.q.f(a2, "PARSER");
                r r3 = this.b.i;
                byte[] arr_b2 = (byte[])this.b.b.get(((e)object0));
                Collection collection1 = arr_b2 == null ? w.a : n.p0(n.l0(new Ac.k(a2, new ByteArrayInputStream(arr_b2), r3, 7)));
                ArrayList arrayList2 = new ArrayList(collection1.size());
                for(Object object3: collection1) {
                    Df.r r4 = (Df.r)r3.b.i;
                    kotlin.jvm.internal.q.d(((I)object3));
                    arrayList2.add(r4.f(((I)object3), false));
                }
                r3.k(arrayList2, ((e)object0));
                return Qf.k.d(arrayList2);
            }
            default: {
                kotlin.jvm.internal.q.g(((e)object0), "it");
                g g0 = this.b.i.b;
                byte[] arr_b = (byte[])this.b.c.get(((e)object0));
                if(arr_b != null) {
                    ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(arr_b);
                    rf.a a0 = V.w.b(byteArrayInputStream0, ((i)g0.a).p);
                    if(((V)a0) != null) {
                        Df.r r0 = (Df.r)g0.i;
                        g g1 = r0.a;
                        f f0 = (f)g1.b;
                        z z0 = (z)g1.d;
                        List list0 = ((V)a0).k;
                        kotlin.jvm.internal.q.f(list0, "getAnnotationList(...)");
                        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
                        for(Object object1: list0) {
                            kotlin.jvm.internal.q.d(((h)object1));
                            arrayList0.add(r0.b.j(((h)object1), f0));
                        }
                        Ne.f f1 = arrayList0.isEmpty() ? Ne.g.a : new Ne.i(arrayList0, 0);
                        Me.o o0 = F.q(((h0)d.d.d(((V)a0).d)));
                        v v0 = new v(((i)g1.a).a, ((Me.k)g1.c), f1, c.B(f0, ((V)a0).e), o0, ((V)a0), ((f)g1.b), z0, ((nf.h)g1.e), ((m)g1.g));
                        List list1 = ((V)a0).f;
                        kotlin.jvm.internal.q.f(list1, "getTypeParameterList(...)");
                        B b0 = (B)g.b(g1, v0, list1).h;
                        v0.w1(b0.b(), b0.d(G.L(((V)a0), z0), false), b0.d(G.o(((V)a0), z0), false));
                        return v0;
                    }
                }
                return null;
            }
        }
    }
}

