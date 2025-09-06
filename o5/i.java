package o5;

import E9.g;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.memory.MemoryCache.Key;
import d5.m;
import e1.G;
import i.n.i.b.a.s.e.M3;
import i5.b;
import i5.n;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import k5.h;
import k5.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import n5.e;
import ne.a;
import oe.c;
import t5.o;
import x5.k;
import x5.l;

public final class i implements j {
    public final n a;
    public final l b;
    public final m c;
    public final k d;
    public final g e;

    public i(n n0, l l0, m m0, k k0) {
        this.a = n0;
        this.b = l0;
        this.c = m0;
        this.d = k0;
        g g0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.a = n0;
        g0.b = k0;
        this.e = g0;
    }

    @Override  // o5.j
    public final Object a(o5.l l0, Continuation continuation0) {
        o5.l l1;
        Object object3;
        f f0;
        g g0 = this.e;
        if(continuation0 instanceof f) {
            f0 = (f)continuation0;
            int v = f0.E;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, ((c)continuation0));
            }
            else {
                f0.E = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, ((c)continuation0));
        }
        Object object0 = f0.B;
        a a0 = a.a;
        switch(f0.E) {
            case 0: {
                d5.n.D(object0);
                try {
                    t5.j j0 = l0.d;
                    Object object1 = j0.b;
                    u5.g g1 = l0.e;
                    i5.c c0 = l0.f;
                    o o0 = this.c.s(j0, g1);
                    u5.f f1 = o0.e;
                    List list0 = this.a.j.b;
                    int v1 = list0.size();
                    for(int v2 = 0; v2 < v1; ++v2) {
                        ie.m m0 = (ie.m)list0.get(v2);
                        q5.a a1 = (q5.a)m0.a;
                        Class class0 = object1.getClass();
                        if(((Class)m0.b).isAssignableFrom(class0)) {
                            q.e(a1, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                            Object object2 = a1.a(object1, o0);
                            if(object2 != null) {
                                object1 = object2;
                            }
                        }
                    }
                    MemoryCache.Key memoryCache$Key0 = g0.w(j0, object1, o0, c0);
                    r5.a a2 = memoryCache$Key0 == null ? null : g0.j(j0, memoryCache$Key0, g1, f1);
                    if(a2 != null) {
                        return g.x(l0, j0, memoryCache$Key0, a2);
                    }
                    o5.g g2 = new o5.g(this, j0, object1, o0, c0, memoryCache$Key0, l0, null);
                    f0.r = this;
                    f0.w = l0;
                    f0.E = 1;
                    object3 = BuildersKt.withContext(j0.u, g2, f0);
                }
                catch(Throwable throwable0) {
                    goto label_55;
                }
                return object3 == a0 ? a0 : object3;
            }
            case 1: {
                try {
                    l1 = f0.w;
                    d5.n.D(object0);
                    return object0;
                }
                catch(Throwable throwable0) {
                    l0 = l1;
                }
            label_55:
                if(throwable0 instanceof CancellationException) {
                    throw throwable0;
                }
                return m.g(l0.d, throwable0);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static final Object b(i i0, n5.m m0, b b0, t5.j j0, Object object0, o o0, i5.c c0, c c1) {
        ie.m m2;
        int v3;
        int v1;
        o5.b b1;
        i0.getClass();
        if(c1 instanceof o5.b) {
            b1 = (o5.b)c1;
            int v = b1.T;
            if((v & 0x80000000) == 0) {
                b1 = new o5.b(i0, c1);
            }
            else {
                b1.T = v ^ 0x80000000;
            }
        }
        else {
            b1 = new o5.b(i0, c1);
        }
        Object object1 = b1.N;
        a a0 = a.a;
        String s = null;
        switch(b1.T) {
            case 0: {
                d5.n.D(object1);
                v1 = 0;
                goto label_45;
            }
            case 1: {
                int v2 = b1.M;
                i5.c c2 = b1.I;
                o o1 = b1.G;
                Object object2 = b1.E;
                t5.j j1 = b1.D;
                b b2 = b1.B;
                n5.m m1 = b1.w;
                i i1 = b1.r;
                d5.n.D(object1);
                v3 = v2;
                i0 = i1;
                c0 = c2;
                m0 = m1;
                o0 = o1;
                b0 = b2;
                object0 = object2;
                j0 = j1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            c0.getClass();
            if(((h)object1) != null) {
                Drawable drawable0 = ((h)object1).a;
                boolean z = ((h)object1).b;
                k5.g g0 = m0.c;
                p p0 = m0.a instanceof p ? ((p)m0.a) : null;
                if(p0 != null) {
                    s = p0.c;
                }
                return new o5.a(drawable0, z, g0, s);
            }
            v1 = v3;
        label_45:
            List list0 = b0.e;
            int v4 = list0.size();
            while(true) {
                m2 = null;
                if(v1 < v4) {
                    k5.j j2 = ((k5.i)list0.get(v1)).a(m0, o0);
                    if(j2 == null) {
                        ++v1;
                        continue;
                    }
                    else {
                        m2 = new ie.m(j2, v1);
                    }
                }
                break;
            }
            if(m2 == null) {
                break;
            }
            v3 = ((Number)m2.b).intValue() + 1;
            c0.getClass();
            b1.r = i0;
            b1.w = m0;
            b1.B = b0;
            b1.D = j0;
            b1.E = object0;
            b1.G = o0;
            b1.I = c0;
            b1.M = v3;
            b1.T = 1;
            object1 = ((k5.j)m2.a).a(b1);
            if(object1 != a0) {
                continue;
            }
            return a0;
        }
        throw new IllegalStateException(("Unable to create a decoder that supports: " + object0).toString());
    }

    public static final Object c(i i0, t5.j j0, Object object0, o o0, i5.c c0, c c1) {
        H h9;
        o5.a a2;
        i5.c c5;
        t5.j j2;
        i i4;
        t5.j j1;
        H h6;
        H h5;
        H h4;
        i5.c c3;
        Object object1;
        i i2;
        H h3;
        o5.c c2;
        if(c1 instanceof o5.c) {
            c2 = (o5.c)c1;
            int v = c2.T;
            if((v & 0x80000000) == 0) {
                c2 = new o5.c(i0, c1);
            }
            else {
                c2.T = v ^ 0x80000000;
            }
        }
        else {
            c2 = new o5.c(i0, c1);
        }
        o5.a a0 = c2.N;
        a a1 = a.a;
        n5.m m0 = null;
        switch(c2.T) {
            case 0: {
                H h0 = H0.b.p(a0);
                h0.a = o0;
                H h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                h1.a = i0.a.j;
                H h2 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                try {
                    h0.a = i0.c.x(((o)h0.a));
                    j0.getClass();
                    k5.i i1 = j0.h;
                    if(i1 != null) {
                        b b0 = (b)h1.a;
                        b0.getClass();
                        ArrayList arrayList0 = je.p.Q0(b0.a);
                        ArrayList arrayList1 = je.p.Q0(b0.b);
                        ArrayList arrayList2 = je.p.Q0(b0.c);
                        ArrayList arrayList3 = je.p.Q0(b0.d);
                        ArrayList arrayList4 = je.p.Q0(b0.e);
                        if(i1 != null) {
                            arrayList4.add(0, i1);
                        }
                        h1.a = new b(G.H(arrayList0), G.H(arrayList1), G.H(arrayList2), G.H(arrayList3), G.H(arrayList4));
                    }
                    c2.r = i0;
                    c2.w = j0;
                    c2.B = object0;
                    c2.D = c0;
                    c2.E = h0;
                    c2.G = h1;
                    c2.I = h2;
                    c2.M = h2;
                    c2.T = 1;
                    a0 = i0.d(((b)h1.a), j0, object0, ((o)h0.a), c0, c2);
                }
                catch(Throwable throwable0) {
                    h3 = h2;
                    goto label_137;
                }
                if(a0 == a1) {
                    return a1;
                }
                i2 = i0;
                object1 = object0;
                c3 = c0;
                h4 = h0;
                h5 = h1;
                h6 = h2;
                h3 = h6;
                j1 = j0;
                goto label_71;
            }
            case 1: {
                h6 = c2.M;
                h3 = c2.I;
                H h7 = c2.G;
                H h8 = c2.E;
                i5.c c4 = (i5.c)c2.D;
                Object object2 = c2.B;
                j1 = c2.w;
                i i3 = c2.r;
                try {
                    d5.n.D(a0);
                    h5 = h7;
                    h4 = h8;
                    c3 = c4;
                    object1 = object2;
                    i2 = i3;
                label_71:
                    h6.a = a0;
                    Object object3 = h3.a;
                    if(((e)object3) instanceof n5.m) {
                        d d0 = new d(i2, h3, h5, j1, object1, h4, c3, null);
                        i4 = i2;
                        j2 = j1;
                        c5 = c3;
                        c2.r = i4;
                        c2.w = j2;
                        c2.B = c5;
                        c2.D = h4;
                        c2.E = h3;
                        c2.G = null;
                        c2.I = null;
                        c2.M = null;
                        c2.T = 2;
                        a0 = BuildersKt.withContext(j1.v, d0, c2);
                        if(a0 == a1) {
                            return a1;
                        }
                        a2 = a0;
                        h9 = h4;
                    }
                    else {
                        j2 = j1;
                        i4 = i2;
                        h9 = h4;
                        c5 = c3;
                        if(!(((e)object3) instanceof n5.d)) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        a2 = new o5.a(((n5.d)object3).a, ((n5.d)object3).b, ((n5.d)object3).c, null);
                    }
                    goto label_108;
                }
                catch(Throwable throwable0) {
                    goto label_137;
                }
            }
            case 2: {
                h3 = c2.E;
                H h10 = (H)c2.D;
                c5 = (i5.c)c2.B;
                j2 = c2.w;
                i4 = c2.r;
                try {
                    d5.n.D(a0);
                    a2 = a0;
                    h9 = h10;
                }
                catch(Throwable throwable0) {
                    goto label_137;
                }
            label_108:
                n5.m m1 = h3.a instanceof n5.m ? ((n5.m)h3.a) : null;
                if(m1 != null) {
                    x5.g.a(m1.a);
                }
                o o1 = (o)h9.a;
                c2.r = null;
                c2.w = null;
                c2.B = null;
                c2.D = null;
                c2.E = null;
                c2.G = null;
                c2.I = null;
                c2.M = null;
                c2.T = 3;
                i4.getClass();
                List list0 = j2.i;
                if(list0.isEmpty()) {
                    a0 = a2;
                }
                else {
                    Drawable drawable0 = a2.a;
                    if(drawable0 instanceof BitmapDrawable || j2.m) {
                        o5.h h11 = new o5.h(i4, a2, o1, list0, c5, j2, null);
                        a0 = BuildersKt.withContext(j2.w, h11, c2);
                    }
                    else {
                        if(i4.d != null) {
                            k.a("EngineInterceptor", 4, H0.b.c('.', "allowConversionToBitmap=false, skipping transformations for type ", drawable0.getClass().getCanonicalName()), null);
                        }
                        a0 = a2;
                    }
                }
                if(a0 == a1) {
                    try {
                        return a1;
                    }
                    catch(Throwable throwable0) {
                    }
                label_137:
                    Object object4 = h3.a;
                    if(object4 instanceof n5.m) {
                        m0 = (n5.m)object4;
                    }
                    if(m0 != null) {
                        x5.g.a(m0.a);
                    }
                    throw throwable0;
                }
                goto label_144;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d5.n.D(a0);
    label_144:
        Drawable drawable1 = a0.a;
        if(drawable1 instanceof BitmapDrawable) {
            m0 = (BitmapDrawable)drawable1;
        }
        if(m0 != null) {
            Bitmap bitmap0 = ((BitmapDrawable)m0).getBitmap();
            if(bitmap0 != null) {
                bitmap0.prepareToDraw();
            }
        }
        return a0;
    }

    public final Object d(b b0, t5.j j0, Object object0, o o0, i5.c c0, c c1) {
        ie.m m1;
        b b2;
        t5.j j1;
        b b1;
        i i0;
        o5.e e1;
        int v1;
        i5.c c2;
        o o1;
        Object object2;
        o5.e e0;
        if(c1 instanceof o5.e) {
            e0 = (o5.e)c1;
            int v = e0.S;
            if((v & 0x80000000) == 0) {
                e0 = new o5.e(this, c1);
            }
            else {
                e0.S = v ^ 0x80000000;
            }
        }
        else {
            e0 = new o5.e(this, c1);
        }
        Object object1 = e0.M;
        a a0 = a.a;
        switch(e0.S) {
            case 0: {
                d5.n.D(object1);
                object2 = object0;
                o1 = o0;
                c2 = c0;
                v1 = 0;
                e1 = e0;
                i0 = this;
                b1 = b0;
                j1 = j0;
                goto label_47;
            }
            case 1: {
                int v2 = e0.I;
                i5.c c3 = e0.G;
                o o2 = e0.E;
                Object object3 = e0.D;
                t5.j j2 = e0.B;
                b2 = e0.w;
                i0 = e0.r;
                d5.n.D(object1);
                e1 = e0;
                j1 = j2;
                v1 = v2;
                object2 = object3;
                c2 = c3;
                o1 = o2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            try {
                c2.getClass();
            }
            catch(Throwable throwable0) {
                n5.m m0 = ((e)object1) instanceof n5.m ? ((n5.m)(((e)object1))) : null;
                if(m0 != null) {
                    x5.g.a(m0.a);
                }
                throw throwable0;
            }
            if(((e)object1) != null) {
                return (e)object1;
            }
            b1 = b2;
        label_47:
            List list0 = b1.d;
            int v3 = list0.size();
            while(true) {
                m1 = null;
                if(v1 >= v3) {
                    break;
                }
                ie.m m2 = (ie.m)list0.get(v1);
                n5.f f0 = (n5.f)m2.a;
                Class class0 = object2.getClass();
                if(((Class)m2.b).isAssignableFrom(class0)) {
                    q.e(f0, "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>");
                    n5.g g0 = f0.a(object2, o1);
                    if(g0 != null) {
                        m1 = new ie.m(g0, v1);
                        break;
                    }
                }
                ++v1;
            }
            if(m1 == null) {
                break;
            }
            v1 = ((Number)m1.b).intValue() + 1;
            c2.getClass();
            e1.r = i0;
            e1.w = b1;
            e1.B = j1;
            e1.D = object2;
            e1.E = o1;
            e1.G = c2;
            e1.I = v1;
            e1.S = 1;
            Object object4 = ((n5.g)m1.a).a(e1);
            if(object4 == a0) {
                return a0;
            }
            b2 = b1;
            object1 = object4;
        }
        throw new IllegalStateException(("Unable to create a fetcher that supports: " + object2).toString());
    }
}

