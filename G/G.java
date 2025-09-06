package G;

import B7.b;
import Cc.E0;
import J0.d;
import L2.s;
import Mc.I;
import Mc.v;
import N0.Y;
import P.F;
import P.i;
import P0.A0;
import P0.G;
import P0.M;
import P0.O;
import P0.P;
import P0.Q;
import P0.V;
import P0.d0;
import P0.f;
import P0.j0;
import P0.u;
import P0.v0;
import P0.z0;
import Q.K;
import Q.w;
import Q0.C;
import Q0.O0;
import Q0.Q0;
import Q0.X0;
import Q0.Z0;
import U.J0;
import U.L0;
import U.S;
import U.f0;
import U.q0;
import X0.l;
import X0.x;
import a1.T;
import a1.e;
import a1.y;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.collection.L;
import androidx.compose.foundation.U;
import androidx.compose.foundation.lazy.layout.D;
import androidx.compose.foundation.lazy.layout.X;
import androidx.compose.foundation.w0;
import androidx.compose.runtime.E;
import androidx.compose.runtime.b0;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.lifecycle.n;
import androidx.lifecycle.o0;
import androidx.lifecycle.r0;
import androidx.lifecycle.t;
import androidx.work.impl.WorkDatabase;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.j;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import r0.p;
import u1.o;
import we.a;
import we.k;
import x0.c;

public final class g extends r implements a {
    public final int f;
    public final Object g;
    public final Object h;

    public g(int v, Object object0, Object object1) {
        this.f = v;
        this.g = object0;
        this.h = object1;
        super(0);
    }

    public g(L0 l00, e e0, AndroidUriHandler androidUriHandler0) {
        this.f = 19;
        this.g = e0;
        this.h = androidUriHandler0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        long v24;
        a1.g g0;
        Object object0 = null;
        int v = 0;
        switch(this.f) {
            case 0: {
                ((Channel)this.g).trySend-JP2dKIU(this.h);
                return H.a;
            }
            case 1: {
                ((d)this.g).g(((p)this.h));
                return H.a;
            }
            case 2: {
                L2.d d0 = new L2.d(((s)this.h), null);
                BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)this.g), null, null, d0, 3, null);
                return H.a;
            }
            case 3: {
                r0 r00 = (r0)((j)this.h).getValue();
                if(r00 instanceof n) {
                    object0 = (n)r00;
                }
                if(object0 != null) {
                    o0 o00 = ((n)object0).getDefaultViewModelProviderFactory();
                    return o00 == null ? ((v)this.g).getDefaultViewModelProviderFactory() : o00;
                }
                return ((v)this.g).getDefaultViewModelProviderFactory();
            }
            case 4: {
                r0 r01 = (r0)((j)this.h).getValue();
                if(r01 instanceof n) {
                    object0 = (n)r01;
                }
                if(object0 != null) {
                    o0 o01 = ((n)object0).getDefaultViewModelProviderFactory();
                    return o01 == null ? ((I)this.g).getDefaultViewModelProviderFactory() : o01;
                }
                return ((I)this.g).getDefaultViewModelProviderFactory();
            }
            case 5: {
                i i0 = (i)((E)this.g).getValue();
                b b0 = new b(((Ce.g)((F)this.h).d.f.getValue()), i0);
                return new P.j(((F)this.h), i0, b0);
            }
            case 6: {
                d0 d00 = ((P0.I)this.g).b0;
                kotlin.jvm.internal.H h0 = (kotlin.jvm.internal.H)this.h;
                if((((p)d00.f).getAggregateChildKindSet$ui_release() & 8) != 0) {
                    p p0 = (A0)d00.e;
                    while(p0 != null) {
                        if((p0.getKindSet$ui_release() & 8) != 0) {
                            p p1 = p0;
                            g0.e e0 = null;
                            while(p1 != null) {
                                if(p1 instanceof z0) {
                                    if(((z0)p1).o()) {
                                        l l0 = new l();
                                        h0.a = l0;
                                        l0.d = true;
                                    }
                                    if(((z0)p1).l0()) {
                                        ((l)h0.a).c = true;
                                    }
                                    ((z0)p1).l(((x)h0.a));
                                }
                                else if((p1.getKindSet$ui_release() & 8) != 0 && p1 instanceof P0.n) {
                                    p p2 = ((P0.n)p1).b;
                                    int v1 = 0;
                                    while(p2 != null) {
                                        if((p2.getKindSet$ui_release() & 8) != 0) {
                                            ++v1;
                                            if(v1 == 1) {
                                                p1 = p2;
                                            }
                                            else {
                                                if(e0 == null) {
                                                    e0 = new g0.e(new p[16]);
                                                }
                                                if(p1 != null) {
                                                    e0.b(p1);
                                                    p1 = null;
                                                }
                                                e0.b(p2);
                                            }
                                        }
                                        p2 = p2.getChild$ui_release();
                                    }
                                    if(v1 != 1) {
                                        goto label_64;
                                    }
                                    continue;
                                }
                            label_64:
                                p1 = f.f(e0);
                            }
                        }
                        p0 = p0.getParent$ui_release();
                    }
                }
                return H.a;
            }
            case 7: {
                k k0 = ((v0)this.g).a.c();
                if(k0 != null) {
                    k0.invoke(new O(((P)this.h)));
                }
                return H.a;
            }
            case 8: {
                V v2 = (V)this.g;
                M m0 = v2.f;
                m0.h = 0;
                g0.e e1 = m0.a.y();
                Object[] arr_object = e1.a;
                int v3 = e1.c;
                for(int v4 = 0; v4 < v3; ++v4) {
                    V v5 = ((P0.I)arr_object[v4]).c0.q;
                    q.d(v5);
                    v5.h = v5.i;
                    v5.i = 0x7FFFFFFF;
                    if(v5.j == G.b) {
                        v5.j = G.c;
                    }
                }
                P0.I i1 = m0.a;
                g0.e e2 = m0.a.y();
                Object[] arr_object1 = e2.a;
                int v6 = e2.c;
                for(int v7 = 0; v7 < v6; ++v7) {
                    V v8 = ((P0.I)arr_object1[v7]).c0.q;
                    q.d(v8);
                    v8.B.d = false;
                }
                u u0 = v2.I().i0;
                if(u0 != null) {
                    boolean z = u0.h;
                    List list0 = i1.o();
                    int v9 = list0.size();
                    for(int v10 = 0; v10 < v9; ++v10) {
                        Q q0 = ((j0)((P0.I)((g0.b)list0).get(v10)).b0.d).P0();
                        if(q0 != null) {
                            q0.h = z;
                        }
                    }
                }
                ((Q)this.h).A0().b();
                if(v2.I().i0 != null) {
                    List list1 = i1.o();
                    int v11 = list1.size();
                    for(int v12 = 0; v12 < v11; ++v12) {
                        Q q1 = ((j0)((P0.I)((g0.b)list1).get(v12)).b0.d).P0();
                        if(q1 != null) {
                            q1.h = false;
                        }
                    }
                }
                g0.e e3 = i1.y();
                Object[] arr_object2 = e3.a;
                int v13 = e3.c;
                for(int v14 = 0; v14 < v13; ++v14) {
                    V v15 = ((P0.I)arr_object2[v14]).c0.q;
                    q.d(v15);
                    if(v15.h != v15.i && v15.i == 0x7FFFFFFF) {
                        v15.u0(true);
                    }
                }
                g0.e e4 = i1.y();
                Object[] arr_object3 = e4.a;
                int v16 = e4.c;
                while(v < v16) {
                    V v17 = ((P0.I)arr_object3[v]).c0.q;
                    q.d(v17);
                    v17.B.e = v17.B.d;
                    ++v;
                }
                return H.a;
            }
            case 9: {
                w w0 = (w)((E)this.g).getValue();
                b b1 = new b(((Ce.g)((D)((K)this.h).d.f).getValue()), w0);
                return new Q.x(((K)this.h), w0, b1);
            }
            case 10: {
                return Boolean.valueOf(((Q0.u)this.g).super.dispatchKeyEvent(((KeyEvent)this.h)));
            }
            case 11: {
                return Boolean.valueOf(((Q0.u)this.g).super.dispatchGenericMotionEvent(((MotionEvent)this.h)));
            }
            case 12: {
                ((Q0.u)this.g).getAndroidViewsHandler$ui_release().removeViewInLayout(((o)this.h));
                ((Q0.u)this.g).getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().remove(((Q0.u)this.g).getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(((o)this.h)));
                ((o)this.h).setImportantForAccessibility(0);
                return H.a;
            }
            case 13: {
                C c0 = (C)this.h;
                O0 o02 = (O0)this.g;
                X0.j j0 = o02.e;
                X0.j j1 = o02.f;
                Float float0 = o02.c;
                Float float1 = o02.d;
                if((j0 == null || float0 == null ? 0.0f : ((Number)((a)j0.a).invoke()).floatValue() - ((float)float0)) != 0.0f || (j1 == null || float1 == null ? 0.0f : ((Number)((a)j1.a).invoke()).floatValue() - ((float)float1)) != 0.0f) {
                    int v18 = c0.q(o02.a);
                    Q0 q00 = (Q0)c0.j().b(c0.k);
                    if(q00 != null) {
                        d2.d d1 = c0.m;
                        if(d1 != null) {
                            try {
                                d1.k(c0.b(q00));
                            }
                            catch(IllegalStateException unused_ex) {
                            }
                        }
                    }
                    Q0 q01 = (Q0)c0.j().b(c0.l);
                    if(q01 != null) {
                        d2.d d2 = c0.n;
                        if(d2 != null) {
                            try {
                                d2.k(c0.b(q01));
                            }
                            catch(IllegalStateException unused_ex) {
                            }
                        }
                    }
                    c0.a.invalidate();
                    Q0 q02 = (Q0)c0.j().b(v18);
                    if(q02 != null) {
                        X0.p p3 = q02.a;
                        if(p3 != null) {
                            P0.I i2 = p3.c;
                            if(i2 != null) {
                                if(j0 != null) {
                                    c0.p.h(v18, j0);
                                }
                                if(j1 != null) {
                                    c0.q.h(v18, j1);
                                }
                                c0.m(i2);
                            }
                        }
                    }
                }
                if(j0 != null) {
                    o02.c = (Float)((a)j0.a).invoke();
                }
                if(j1 != null) {
                    o02.d = (Float)((a)j1.a).invoke();
                }
                return H.a;
            }
            case 14: {
                ((AbstractComposeView)this.g).removeOnAttachStateChangeListener(((X0)this.h));
                return H.a;
            }
            case 15: {
                ((AbstractComposeView)this.g).removeOnAttachStateChangeListener(((Z0)this.h));
                return H.a;
            }
            case 16: {
                ((t)this.g).c(((E0)this.h));
                return H.a;
            }
            case 17: {
                f1.x x0 = (f1.x)this.g;
                b0 b00 = (b0)this.h;
                long v19 = ((f1.x)b00.getValue()).b;
                if(T.a(x0.b, v19)) {
                    T t0 = ((f1.x)b00.getValue()).c;
                    if(!q.b(x0.c, t0)) {
                        b00.setValue(x0);
                        return H.a;
                    }
                }
                else {
                    b00.setValue(x0);
                }
                return H.a;
            }
            case 18: {
                L0 l00 = (L0)this.g;
                if(l00 != null) {
                    p0.p p4 = l00.c;
                    if(p4.isEmpty()) {
                        g0 = l00.b;
                    }
                    else {
                        q0 q03 = new q0(l00.b);
                        int v20 = p4.size();
                        while(v < v20) {
                            ((k)p4.get(v)).invoke(q03);
                            ++v;
                        }
                        g0 = q03.b;
                    }
                    l00.b = g0;
                    return g0 == null ? ((a1.g)this.h) : g0;
                }
                return (a1.g)this.h;
            }
            case 19: {
                a1.w w1 = (a1.w)((e)this.g).a;
                AndroidUriHandler androidUriHandler0 = (AndroidUriHandler)this.h;
                if(w1 instanceof a1.v) {
                    w1.getClass();
                    try {
                        String s = ((a1.v)w1).a;
                        androidUriHandler0.getClass();
                        try {
                            Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(s));
                            androidUriHandler0.a.startActivity(intent0);
                        }
                        catch(ActivityNotFoundException unused_ex) {
                        }
                        return H.a;
                    }
                    catch(IllegalArgumentException unused_ex) {
                    }
                }
                else if(w1 instanceof a1.u) {
                    w1.getClass();
                }
                return H.a;
            }
            case 20: {
                a a0 = (a)this.g;
                if(a0 != null) {
                    c c1 = (c)a0.invoke();
                    if(c1 != null) {
                        return c1;
                    }
                }
                j0 j00 = (j0)this.h;
                if(!j00.h()) {
                    j00 = null;
                }
                return j00 != null ? e.k.d(0L, e1.n.E(j00.c)) : null;
            }
            case 21: {
                Y.Q q2 = (Y.Q)this.g;
                long v21 = ((r1.l)((b0)this.h).getValue()).a;
                x0.b b2 = q2.i();
                if(b2 != null) {
                    long v22 = b2.a;
                    f0 f00 = q2.d;
                    if(f00 != null) {
                        object0 = f00.a.a;
                    }
                    if(object0 != null && object0.b.length() != 0) {
                        S s1 = (S)((androidx.compose.runtime.O0)q2.r).getValue();
                        int v23 = s1 == null ? -1 : Y.T.a[s1.ordinal()];
                        if(v23 != -1) {
                            if(v23 == 1 || v23 == 2) {
                                v24 = q2.m().b >> 0x20;
                            }
                            else {
                                if(v23 != 3) {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                                v24 = q2.m().b & 0xFFFFFFFFL;
                            }
                            f0 f01 = q2.d;
                            if(f01 != null) {
                                J0 j01 = f01.d();
                                if(j01 != null) {
                                    f0 f02 = q2.d;
                                    if(f02 != null) {
                                        a1.g g1 = f02.a.a;
                                        if(g1 != null) {
                                            int v25 = P4.a.j(q2.b.t(((int)v24)), 0, g1.b.length());
                                            float f = Float.intBitsToFloat(((int)(j01.d(v22) >> 0x20)));
                                            y y0 = j01.a.b;
                                            int v26 = y0.d(v25);
                                            float f1 = j01.a.e(v26);
                                            float f2 = j01.a.f(v26);
                                            float f3 = P4.a.i(f, Math.min(f1, f2), Math.max(f1, f2));
                                            if(r1.l.b(v21, 0L) || Math.abs(f - f3) <= ((float)(((int)(v21 >> 0x20)) / 2))) {
                                                float f4 = y0.f(v26);
                                                return new x0.b(((long)Float.floatToRawIntBits(f3)) << 0x20 | ((long)Float.floatToRawIntBits((y0.b(v26) - f4) / 2.0f + f4)) & 0xFFFFFFFFL);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return new x0.b(0x7FC000007FC00000L);
            }
            case 22: {
                b5.e e5 = ((a5.c)this.g).a;
                e5.getClass();
                synchronized(e5.c) {
                    if(e5.d.remove(((a5.a)this.h)) && e5.d.isEmpty()) {
                        e5.d();
                    }
                    return H.a;
                }
            }
            case 23: {
                ((androidx.compose.foundation.r)this.g).i = ((androidx.compose.foundation.r)this.g).d.i(((P0.K)this.h).a.c(), ((P0.K)this.h).getLayoutDirection(), ((P0.K)this.h));
                return H.a;
            }
            case 24: {
                ((kotlin.jvm.internal.H)this.g).a = f.i(((U)this.h), Y.a);
                return H.a;
            }
            case 25: {
                r1.c c2 = f.v(((androidx.compose.foundation.v0)this.h)).S;
                ((androidx.compose.foundation.v0)this.h).n0();
                int v28 = ((androidx.compose.foundation.v0)this.h).m0();
                return ((w0)this.g).a(c2, v28);
            }
            case 26: {
                return new X(((o0.i)this.g), je.x.a, ((o0.f)this.h));
            }
            case 27: {
                androidx.compose.runtime.v v29 = (androidx.compose.runtime.v)this.h;
                Object[] arr_object4 = ((L)this.g).b;
                long[] arr_v = ((L)this.g).a;
                int v30 = arr_v.length - 2;
                if(v30 >= 0) {
                    int v31 = 0;
                    while(true) {
                        long v32 = arr_v[v31];
                        if((~v32 << 7 & v32 & 0x8080808080808080L) != 0x8080808080808080L) {
                            int v33 = 8 - (~(v31 - v30) >>> 0x1F);
                            for(int v34 = 0; v34 < v33; ++v34) {
                                if((0xFFL & v32) < 0x80L) {
                                    v29.y(arr_object4[(v31 << 3) + v34]);
                                }
                                v32 >>= 8;
                            }
                            if(v33 == 8) {
                                goto label_318;
                            }
                            break;
                        }
                    label_318:
                        if(v31 == v30) {
                            break;
                        }
                        ++v31;
                    }
                }
                return H.a;
            }
            case 28: {
                q.f(((V4.s)this.g).j, "workManagerImpl.workDatabase");
                b.l l1 = new b.l(25, ((V4.s)this.g), ((UUID)this.h));
                ((V4.s)this.g).j.runInTransaction(l1);
                V4.j.b(((V4.s)this.g).i, ((V4.s)this.g).j, ((V4.s)this.g).l);
                return H.a;
            }
            default: {
                return ((B2.s)this.g).invoke(((WorkDatabase)this.h));
            }
        }
    }
}

