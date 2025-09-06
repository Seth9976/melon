package androidx.compose.foundation;

import A0.a;
import A0.h;
import A0.i;
import Ld.p;
import M6.B;
import P0.C0;
import P0.K;
import Q0.P;
import android.content.Context;
import androidx.collection.F;
import androidx.compose.foundation.lazy.layout.E;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.P0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.o0;
import androidx.compose.runtime.u0;
import androidx.compose.ui.draw.ShadowGraphicsLayerElement;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import androidx.fragment.app.FragmentContainerView;
import androidx.media3.session.legacy.V;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerApi31Ext9Impl;
import e1.n;
import i.n.i.b.a.s.e.M3;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import k8.Y;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import l2.X;
import l2.l0;
import o0.l;
import r1.f;
import r1.m;
import v0.d;
import we.k;
import x0.c;
import x0.e;
import y0.C;
import y0.G;
import y0.I;
import y0.L;
import y0.M;
import y0.N;
import y0.T;
import y0.b;
import y0.g;
import y0.j;
import y0.o;
import y0.s;

public final class w extends r implements k {
    public final int f;
    public final Object g;

    public w(int v, Object object0, Object object1) {
        this.f = v;
        this.g = object0;
        super(1);
    }

    public w(Object object0, int v) {
        this.f = v;
        this.g = object0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s1;
        long v4;
        boolean z3;
        int v2;
        y0.k k0;
        float f3;
        float f = 1.0f;
        boolean z = false;
        boolean z1 = true;
        Object object1 = null;
        switch(this.f) {
            case 0: {
                d d0 = (d)object0;
                x x0 = (x)this.g;
                float f2 = x0.d;
                if(d0.b() * f2 >= 0.0f && e.c(d0.a.c()) > 0.0f) {
                    if(f.a(x0.d, 0.0f)) {
                        f3 = 1.0f;
                    }
                    else {
                        float f4 = x0.d;
                        f3 = (float)Math.ceil(d0.b() * f4);
                    }
                    float f5 = Math.min(f3, ((float)Math.ceil(e.c(d0.a.c()) / 2.0f)));
                    long v = ((long)Float.floatToRawIntBits(f5 / 2.0f)) << 0x20 | ((long)Float.floatToRawIntBits(f5 / 2.0f)) & 0xFFFFFFFFL;
                    long v1 = ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(d0.a.c() >> 0x20))) - f5)) << 0x20 | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(d0.a.c() & 0xFFFFFFFFL))) - f5)) & 0xFFFFFFFFL;
                    boolean z2 = f5 * 2.0f > e.c(d0.a.c());
                    M m0 = x0.f.i(d0.a.c(), d0.a.getLayoutDirection(), d0);
                    if(m0 instanceof G) {
                        o o0 = x0.e;
                        L l0 = ((G)m0).e;
                        if(z2) {
                            return d0.a(new p(28, ((G)m0), o0));
                        }
                        if(o0 instanceof T) {
                            k0 = new y0.k(s.c(((T)o0).a, 1.0f), 5);
                            v2 = 1;
                        }
                        else {
                            v2 = 0;
                            k0 = null;
                        }
                        c c0 = ((g)l0).c();
                        float f6 = c0.b;
                        float f7 = c0.a;
                        if(x0.c == null) {
                            x0.c = new t();
                        }
                        t t0 = x0.c;
                        q.d(t0);
                        g g0 = t0.d;
                        if(g0 == null) {
                            g0 = j.a();
                            t0.d = g0;
                        }
                        g0.g();
                        L.b(g0, c0);
                        g0.f(g0, l0, 0);
                        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        long v3 = ((long)(((int)(((float)Math.ceil(c0.c - f7)))))) << 0x20 | ((long)(((int)(((float)Math.ceil(c0.d - f6)))))) & 0xFFFFFFFFL;
                        t t1 = x0.c;
                        q.d(t1);
                        y0.e e0 = t1.a;
                        b b0 = t1.b;
                        C c1 = e0 == null ? null : new C(e0.a());
                        if(c1 != null && c1.a == 0) {
                            z3 = true;
                        }
                        else {
                            C c2 = e0 == null ? null : new C(e0.a());
                            z3 = c2 != null && v2 == c2.a;
                        }
                        if(e0 == null || b0 == null) {
                            v4 = v3;
                            e0 = M.g(((int)(v4 >> 0x20)), ((int)(v4 & 0xFFFFFFFFL)), v2);
                            t1.a = e0;
                            b0 = M.a(e0);
                            t1.b = b0;
                        }
                        else {
                            v4 = v3;
                            if(Float.intBitsToFloat(((int)(d0.a.c() >> 0x20))) > ((float)e0.a.getWidth()) || Float.intBitsToFloat(((int)(d0.a.c() & 0xFFFFFFFFL))) > ((float)e0.a.getHeight()) || !z3) {
                                e0 = M.g(((int)(v4 >> 0x20)), ((int)(v4 & 0xFFFFFFFFL)), v2);
                                t1.a = e0;
                                b0 = M.a(e0);
                                t1.b = b0;
                            }
                        }
                        A0.b b1 = t1.c;
                        if(b1 == null) {
                            b1 = new A0.b();
                            t1.c = b1;
                        }
                        V v5 = b1.b;
                        a a0 = b1.a;
                        long v6 = n.E(v4);
                        m m1 = d0.a.getLayoutDirection();
                        r1.c c3 = a0.a;
                        m m2 = a0.b;
                        y0.q q0 = a0.c;
                        long v7 = a0.d;
                        a0.a = d0;
                        a0.b = m1;
                        a0.c = b0;
                        a0.d = v6;
                        b0.q();
                        A0.f.d0(b1, s.b, v6, 0.0f, null, 0, 58);
                        ((A0.c)v5.a).M(-f7, -f6);
                        try {
                            i i0 = new i(0, 0, f5 * 2.0f, 0.0f, 30);
                            A0.f.M(b1, ((G)m0).e, o0, 0.0f, i0, 52);
                            float f8 = (Float.intBitsToFloat(((int)(b1.c() >> 0x20))) + 1.0f) / Float.intBitsToFloat(((int)(b1.c() >> 0x20)));
                            float f9 = (Float.intBitsToFloat(((int)(b1.c() & 0xFFFFFFFFL))) + 1.0f) / Float.intBitsToFloat(((int)(b1.c() & 0xFFFFFFFFL)));
                            long v9 = b1.g0();
                            long v10 = v5.l();
                            v5.h().q();
                            try {
                                ((A0.c)v5.a).J(f8, f9, v9);
                                A0.f.M(b1, g0, o0, 0.0f, null, 28);
                            }
                            catch(Throwable throwable0) {
                                v5.h().j();
                                v5.x(v10);
                                throw throwable0;
                            }
                            v5.h().j();
                            v5.x(v10);
                        }
                        finally {
                            ((A0.c)v5.a).M(--f7, --f6);
                        }
                        b0.j();
                        a0.a = c3;
                        a0.b = m2;
                        a0.c = q0;
                        a0.d = v7;
                        e0.a.prepareToDraw();
                        h0.a = e0;
                        return d0.a(new a1.x(c0, h0, v4, k0, 1));
                    }
                    if(m0 instanceof I) {
                        o o1 = x0.e;
                        x0.d d1 = ((I)m0).e;
                        if(e1.b.E(d1)) {
                            i i1 = new i(0, 0, f5, 0.0f, 30);
                            return d0.a(new v(z2, o1, d1.e, f5 / 2.0f, f5, v, v1, i1));
                        }
                        if(x0.c == null) {
                            x0.c = new t();
                        }
                        t t2 = x0.c;
                        q.d(t2);
                        g g1 = t2.d;
                        if(g1 == null) {
                            g1 = j.a();
                            t2.d = g1;
                        }
                        g1.g();
                        L.a(g1, d1);
                        if(!z2) {
                            g g2 = j.a();
                            L.a(g2, new x0.d(f5, f5, d1.b() - f5, d1.a() - f5, androidx.compose.foundation.q.w(d1.e, f5), androidx.compose.foundation.q.w(d1.f, f5), androidx.compose.foundation.q.w(d1.g, f5), androidx.compose.foundation.q.w(d1.h, f5)));
                            g1.f(g1, g2, 0);
                        }
                        return d0.a(new p(29, g1, o1));
                    }
                    if(!(m0 instanceof y0.H)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    o o2 = x0.e;
                    if(z2) {
                        v = 0L;
                    }
                    if(z2) {
                        v1 = d0.a.c();
                    }
                    return z2 ? d0.a(new F.T(o2, h.b, 1, v, v1)) : d0.a(new F.T(o2, new i(0, 0, f5, 0.0f, 30), 1, v, v1));
                }
                return d0.a(u.g);
            }
            case 1: {
                x0.b b2 = (x0.b)object0;
                androidx.compose.foundation.C c4 = (androidx.compose.foundation.C)this.g;
                if(c4.g) {
                    c4.h.invoke();
                }
                return ie.H.a;
            }
            case 2: {
                A0.f f10 = (A0.f)object0;
                ((K)this.g).a();
                return ie.H.a;
            }
            case 3: {
                float f11 = ((Number)object0).floatValue();
                Q0 q00 = (Q0)this.g;
                float f12 = ((float)q00.g()) + f11 + q00.e;
                float f13 = P4.a.i(f12, 0.0f, ((K0)q00.d).m());
                if(f12 == f13) {
                    z = true;
                }
                float f14 = f13 - ((float)q00.g());
                int v11 = Math.round(f14);
                int v12 = q00.g();
                ((K0)q00.a).n(v12 + v11);
                q00.e = f14 - ((float)v11);
                if(!z) {
                    f11 = f14;
                }
                return f11;
            }
            case 4: {
                androidx.compose.runtime.H h1 = (androidx.compose.runtime.H)object0;
                return new P(((androidx.compose.foundation.lazy.layout.t)this.g), 2);
            }
            case 5: {
                androidx.compose.runtime.H h2 = (androidx.compose.runtime.H)object0;
                return new P(((E)this.g), 4);
            }
            case 6: {
                o0.i i2 = (o0.i)this.g;
                if(i2 != null) {
                    z1 = i2.a(object0);
                }
                return Boolean.valueOf(z1);
            }
            case 7: {
                CancellationException cancellationException0 = ExceptionsKt.CancellationException("Recomposer effect job completed", ((Throwable)object0));
                u0 u00 = (u0)this.g;
                synchronized(u00.c) {
                    Job job0 = u00.d;
                    if(job0 == null) {
                        u00.e = cancellationException0;
                        u00.u.setValue(o0.a);
                    }
                    else {
                        u00.u.setValue(o0.b);
                        job0.cancel(cancellationException0);
                        u00.r = null;
                        job0.invokeOnCompletion(new S(6, u00, ((Throwable)object0)));
                    }
                    return ie.H.a;
                }
            }
            case 8: {
                ((androidx.compose.runtime.v)this.g).x(object0);
                return ie.H.a;
            }
            case 9: {
                e1.K k1 = new e1.K(null, ((e1.K)object0).b, ((e1.K)object0).c, ((e1.K)object0).d, ((e1.K)object0).e);
                return ((e1.k)this.g).a(k1).getValue();
            }
            case 10: {
                StringBuilder stringBuilder0 = Y.p((((f1.g)this.g) == ((f1.g)object0) ? " > " : "   "));
                if(((f1.g)object0) instanceof f1.a) {
                    StringBuilder stringBuilder1 = new StringBuilder("CommitTextCommand(text.length=");
                    stringBuilder1.append(((f1.a)(((f1.g)object0))).a.b.length());
                    stringBuilder1.append(", newCursorPosition=");
                    s1 = androidx.appcompat.app.o.q(stringBuilder1, ((f1.a)(((f1.g)object0))).b, ')');
                }
                else if(((f1.g)object0) instanceof f1.u) {
                    StringBuilder stringBuilder2 = new StringBuilder("SetComposingTextCommand(text.length=");
                    stringBuilder2.append(((f1.u)(((f1.g)object0))).a.b.length());
                    stringBuilder2.append(", newCursorPosition=");
                    s1 = androidx.appcompat.app.o.q(stringBuilder2, ((f1.u)(((f1.g)object0))).b, ')');
                }
                else if(((f1.g)object0) instanceof f1.t) {
                    s1 = ((f1.g)object0).toString();
                }
                else if(((f1.g)object0) instanceof f1.e) {
                    s1 = ((f1.g)object0).toString();
                }
                else if(((f1.g)object0) instanceof f1.f) {
                    s1 = ((f1.g)object0).toString();
                }
                else if(((f1.g)object0) instanceof f1.v) {
                    s1 = ((f1.g)object0).toString();
                }
                else if(((f1.g)object0) instanceof f1.h) {
                    ((f1.h)(((f1.g)object0))).getClass();
                    s1 = "FinishComposingTextCommand()";
                }
                else if(((f1.g)object0) instanceof f1.d) {
                    ((f1.d)(((f1.g)object0))).getClass();
                    s1 = "DeleteAllCommand()";
                }
                else {
                    Class class0 = ((f1.g)object0).getClass();
                    String s2 = kotlin.jvm.internal.I.a.b(class0).m();
                    if(s2 == null) {
                        s2 = "{anonymous EditCommand}";
                    }
                    s1 = "Unknown EditCommand: " + s2;
                }
                stringBuilder0.append(s1);
                return stringBuilder0.toString();
            }
            case 11: {
                l2.M m3 = (l2.M)this.g;
                if(((Throwable)object0) != null) {
                    X x1 = new X(((Throwable)object0));
                    m3.h.d(x1);
                }
                if(m3.j.b != ie.C.a) {
                    ((l0)m3.j.getValue()).close();
                }
                return ie.H.a;
            }
            case 12: {
                ComposeViewAdapter composeViewAdapter0 = (ComposeViewAdapter)this.g;
                if(!q.b(((q1.c)object0).b, "remember") && ComposeViewAdapter.b(composeViewAdapter0, ((q1.c)object0))) {
                    z = true;
                }
                else {
                    Iterable iterable0 = (Iterable)((q1.c)object0).g;
                    if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                        for(Object object3: iterable0) {
                            if(!q.b(((q1.c)object3).b, "remember") || !ComposeViewAdapter.b(composeViewAdapter0, ((q1.c)object3))) {
                                continue;
                            }
                            return true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
            case 13: {
                LinkedHashMap linkedHashMap0 = (LinkedHashMap)this.g;
                Object object4 = ((m1.o)object0).b.f;
                P0.I i3 = object4 instanceof P0.I ? ((P0.I)object4) : null;
                if(i3 != null) {
                    object1 = i3.u();
                }
                List list0 = (List)linkedHashMap0.get(object1);
                return list0 == null ? je.w.a : list0;
            }
            case 14: {
                return Boolean.valueOf(!q.b(((m1.o)((ie.m)object0).b).a(), ((m1.o)this.g)));
            }
            case 15: {
                if(((r0.o)object0).getClass().getName().equals("androidx.compose.animation.SizeAnimationModifierElement")) {
                    ((n1.e)this.g).b.add(((r0.o)object0));
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            case 16: {
                ((n1.q)this.g).a();
                return ie.H.a;
            }
            case 17: {
                if(!(((b0)object0) instanceof p0.n)) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                if(((b0)object0).getValue() != null) {
                    Object object5 = ((b0)object0).getValue();
                    q.d(object5);
                    object1 = ((l)this.g).d(object5);
                }
                P0 p00 = ((p0.n)(((b0)object0))).h();
                q.e(p00, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver?>");
                return androidx.compose.runtime.w.r(object1, p00);
            }
            case 18: {
                o0.i i4 = ((o0.f)this.g).c;
                if(i4 != null) {
                    z1 = i4.a(object0);
                }
                return Boolean.valueOf(z1);
            }
            case 19: {
                synchronized(((p0.s)this.g).g) {
                    p0.r r0 = ((p0.s)this.g).i;
                    q.d(r0);
                    Object object7 = r0.b;
                    q.d(object7);
                    int v15 = r0.d;
                    F f15 = r0.c;
                    if(f15 == null) {
                        f15 = new F();
                        r0.c = f15;
                        r0.f.l(object7, f15);
                    }
                    r0.c(object0, v15, object7, f15);
                    return ie.H.a;
                }
            }
            case 20: {
                if(!((u0.e)object0).getNode().isAttached()) {
                    return C0.b;
                }
                u0.e e1 = ((u0.e)object0).b;
                if(e1 != null) {
                    w w0 = new w(((pc.t)this.g), 20);
                    if(w0.invoke(e1) == C0.a) {
                        P0.f.z(e1, w0);
                    }
                }
                ((u0.e)object0).b = null;
                ((u0.e)object0).a = null;
                return C0.a;
            }
            case 21: {
                androidx.fragment.app.l0 l00 = (androidx.fragment.app.l0)this.g;
                if(l00 != null) {
                    object1 = l00.D(((FragmentContainerView)object0).getId());
                }
                if(object1 != null && !l00.T()) {
                    androidx.fragment.app.a a1 = new androidx.fragment.app.a(l00);
                    a1.f(((androidx.fragment.app.I)object1));
                    a1.m();
                }
                return ie.H.a;
            }
            case 22: {
                ((P0.I)this.g).Z(((r1.c)object0));
                return ie.H.a;
            }
            case 23: {
                q.g(((Context)object0), "it");
                return new MeasurementManagerApi31Ext9Impl(((Context)this.g));
            }
            case 24: {
                ((N)object0).y(((N)object0).b() * ((ShadowGraphicsLayerElement)this.g).a);
                ((N)object0).A(((ShadowGraphicsLayerElement)this.g).b);
                ((N)object0).f(((ShadowGraphicsLayerElement)this.g).c);
                ((N)object0).d(((ShadowGraphicsLayerElement)this.g).d);
                ((N)object0).C(((ShadowGraphicsLayerElement)this.g).e);
                return ie.H.a;
            }
            case 25: {
                Throwable throwable1 = (Throwable)object0;
                ((B)this.g).cancel(false);
                return ie.H.a;
            }
            case 26: {
                float f16 = 0.5f;
                C1.k k2 = (C1.k)this.g;
                if(!Float.isNaN(k2.d) || !Float.isNaN(k2.e)) {
                    float f17 = Float.isNaN(k2.d) ? 0.5f : k2.d;
                    if(!Float.isNaN(k2.e)) {
                        f16 = k2.e;
                    }
                    ((N)object0).D(M.i(f17, f16));
                }
                if(!Float.isNaN(k2.f)) {
                    ((N)object0).l(k2.f);
                }
                if(!Float.isNaN(k2.g)) {
                    ((N)object0).o(k2.g);
                }
                if(!Float.isNaN(k2.h)) {
                    ((N)object0).q(k2.h);
                }
                if(!Float.isNaN(k2.i)) {
                    ((N)object0).G(k2.i);
                }
                if(!Float.isNaN(k2.j)) {
                    ((N)object0).I(k2.j);
                }
                if(!Float.isNaN(k2.k)) {
                    ((N)object0).y(k2.k);
                }
                if(!Float.isNaN(k2.l) || !Float.isNaN(k2.m)) {
                    ((N)object0).r((Float.isNaN(k2.l) ? 1.0f : k2.l));
                    if(!Float.isNaN(k2.m)) {
                        f = k2.m;
                    }
                    ((N)object0).s(f);
                }
                if(!Float.isNaN(k2.n)) {
                    ((N)object0).a(k2.n);
                }
                return ie.H.a;
            }
            default: {
                y0.S s0 = (y0.S)this.g;
                ((N)object0).r(s0.a);
                ((N)object0).s(s0.b);
                ((N)object0).a(s0.c);
                ((N)object0).G(0.0f);
                ((N)object0).I(0.0f);
                ((N)object0).y(s0.d);
                ((N)object0).l(0.0f);
                ((N)object0).o(0.0f);
                ((N)object0).q(s0.e);
                float f1 = s0.f;
                if(((N)object0).m != f1) {
                    ((N)object0).a |= 0x800;
                    ((N)object0).m = f1;
                }
                ((N)object0).D(s0.g);
                ((N)object0).A(s0.h);
                ((N)object0).f(s0.i);
                ((N)object0).h(null);
                ((N)object0).d(s0.j);
                ((N)object0).C(s0.k);
                ((N)object0).g(s0.l);
                return ie.H.a;
            }
        }
    }
}

