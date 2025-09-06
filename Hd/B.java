package hd;

import B2.l;
import B2.n;
import J2.s;
import Q1.c;
import Tf.v;
import V4.u;
import a.a;
import androidx.compose.runtime.b0;
import androidx.fragment.app.FragmentActivity;
import cd.W1;
import ie.H;
import java.util.ArrayList;
import java.util.HashMap;
import kc.s2;
import kotlin.jvm.internal.F;
import ob.z;
import v9.j;
import w8.I;
import w8.J;
import w8.K;
import w8.Q;
import w8.q;
import we.k;
import we.o;

public final class b implements o {
    public final int a;
    public final boolean b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;
    public final Object h;

    public b(s2 s20, Q q0, b0 b00, boolean z, b0 b01, z z1, b0 b02) {
        this.a = 2;
        super();
        this.c = s20;
        this.d = q0;
        this.e = b00;
        this.b = z;
        this.f = b01;
        this.g = z1;
        this.h = b02;
    }

    public b(q q0, boolean z, z z1, s2 s20, b0 b00, b0 b01, b0 b02) {
        this.a = 1;
        super();
        this.c = q0;
        this.b = z;
        this.d = z1;
        this.e = s20;
        this.f = b00;
        this.g = b01;
        this.h = b02;
    }

    public b(boolean z, F f0, F f1, ArrayList arrayList0, HashMap hashMap0, FragmentActivity fragmentActivity0, k k0) {
        this.a = 0;
        super();
        this.b = z;
        this.c = f0;
        this.d = f1;
        this.e = arrayList0;
        this.f = hashMap0;
        this.g = fragmentActivity0;
        this.h = k0;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        String s1;
        switch(this.a) {
            case 0: {
                ArrayList arrayList0 = (ArrayList)this.e;
                HashMap hashMap0 = (HashMap)this.f;
                FragmentActivity fragmentActivity0 = (FragmentActivity)this.g;
                k k0 = (k)this.h;
                int v = (int)(((Integer)object0));
                int v1 = (int)(((Integer)object1));
                ((Integer)object2).getClass();
                if(this.b || v != ((F)this.c).a || v1 != ((F)this.d).a) {
                    String s = (String)arrayList0.get(v);
                    ArrayList arrayList1 = (ArrayList)hashMap0.get(s);
                    if(arrayList1 == null) {
                        s1 = null;
                    }
                    else {
                        j j0 = (j)arrayList1.get(v1);
                        s1 = j0 == null ? null : j0.c;
                    }
                    kotlin.jvm.internal.q.d(s);
                    kotlin.jvm.internal.q.f("년", "getString(...)");
                    k0.invoke(v.p0(s, "년", "") + s1);
                }
                return H.a;
            }
            case 1: {
                ((Integer)object2).getClass();
                kotlin.jvm.internal.q.g(((s)object0), "$this$Row");
                n n1 = ((s)object0).a(l.a);
                String s2 = (String)((b0)this.f).getValue();
                String s3 = (String)((b0)this.g).getValue();
                ((q)this.c).w(n1, s2, s3, this.b, false, ((androidx.compose.runtime.l)object1), 0x6000);
                boolean z = ((Boolean)((b0)this.h).getValue()).booleanValue();
                ((q)this.c).x(((z)this.d), ((s2)this.e), z, this.b, false, ((androidx.compose.runtime.l)object1), 0x6000);
                a.i(u.J(l.a, 6.0f), ((androidx.compose.runtime.l)object1), 0);
                return H.a;
            }
            default: {
                ((Integer)object2).getClass();
                kotlin.jvm.internal.q.g(((s)object0), "$this$Row");
                n n0 = u.G(44.0f);
                U4.F.f(c.M(((s)object0).a(l.a), 0.0f, 8.0f, 11), 2, 0, m0.c.e(0x358BA3D8, ((androidx.compose.runtime.l)object1), new J(((s2)this.c), n0, ((Q)this.d), ((b0)this.e), this.b, 0)), ((androidx.compose.runtime.l)object1), 0xC00, 4);
                U4.F.f(c.M(((s)object0).a(l.a), 0.0f, 8.0f, 11), 2, 0, m0.c.e(0x490D0C81, ((androidx.compose.runtime.l)object1), new I(n0, ((Q)this.d), ((b0)this.f), this.b, 3)), ((androidx.compose.runtime.l)object1), 0xC00, 4);
                U4.F.f(c.M(((s)object0).a(l.a), 0.0f, 8.0f, 11), 2, 0, m0.c.e(0xF25DCE60, ((androidx.compose.runtime.l)object1), new K(((Q)this.d), ((z)this.g), ((s2)this.c), this.b, n0, 1)), ((androidx.compose.runtime.l)object1), 0xC00, 4);
                U4.F.f(c.M(((s)object0).a(l.a), 0.0f, 8.0f, 11), 2, 0, m0.c.e(0x9BAE903F, ((androidx.compose.runtime.l)object1), new I(n0, ((Q)this.d), ((b0)this.f), this.b, 4)), ((androidx.compose.runtime.l)object1), 0xC00, 4);
                U4.F.f(c.M(((s)object0).a(l.a), 0.0f, 8.0f, 11), 2, 0, m0.c.e(0x44FF521E, ((androidx.compose.runtime.l)object1), new J(((s2)this.c), n0, ((Q)this.d), ((b0)this.h), this.b, 2)), ((androidx.compose.runtime.l)object1), 0xC00, 4);
                U4.F.f(c.M(((s)object0).a(l.a), 0.0f, 8.0f, 11), 2, 0, m0.c.e(0xEE5013FD, ((androidx.compose.runtime.l)object1), new W1(n0, ((Q)this.d), this.b)), ((androidx.compose.runtime.l)object1), 0xC00, 4);
                return H.a;
            }
        }
    }
}

