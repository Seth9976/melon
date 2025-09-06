package a1;

import android.util.Log;
import e1.y;
import h1.b;
import h1.c;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.r;
import l1.a;
import l1.d;
import l1.e;
import l1.f;
import l1.i;
import l1.l;
import l1.m;
import l1.q;
import l1.t;
import r1.o;
import r1.p;
import we.k;
import y0.P;
import y0.s;

public final class h extends r implements k {
    public static final h B;
    public static final h D;
    public static final h E;
    public static final h G;
    public static final h I;
    public static final h M;
    public static final h N;
    public static final h S;
    public static final h T;
    public static final h V;
    public static final h W;
    public static final h X;
    public static final h Y;
    public static final h Z;
    public static final h b0;
    public static final h c0;
    public static final h d0;
    public final int f;
    public static final h g;
    public static final h h;
    public static final h i;
    public static final h j;
    public static final h k;
    public static final h l;
    public static final h m;
    public static final h n;
    public static final h o;
    public static final h r;
    public static final h w;

    static {
        h.g = new h(1, 0);
        h.h = new h(1, 1);
        h.i = new h(1, 2);
        h.j = new h(1, 3);
        h.k = new h(1, 4);
        h.l = new h(1, 5);
        h.m = new h(1, 6);
        h.n = new h(1, 7);
        h.o = new h(1, 8);
        h.r = new h(1, 9);
        h.w = new h(1, 10);
        h.B = new h(1, 11);
        h.D = new h(1, 12);
        h.E = new h(1, 13);
        h.G = new h(1, 14);
        h.I = new h(1, 15);
        h.M = new h(1, 16);
        h.N = new h(1, 17);
        h.S = new h(1, 18);
        h.T = new h(1, 19);
        h.V = new h(1, 20);
        h.W = new h(1, 21);
        h.X = new h(1, 22);
        h.Y = new h(1, 23);
        h.Z = new h(1, 24);
        h.b0 = new h(1, 25);
        h.c0 = new h(1, 26);
        h.d0 = new h(1, 27);
    }

    public h(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        M m4;
        M m3;
        M m2;
        o o4;
        o o3;
        l l22;
        s s10;
        b b1;
        q q0;
        a a1;
        o o2;
        y y0;
        o o1;
        s s7;
        x0.b b0;
        s s6;
        e e1;
        i i0;
        G g0;
        l1.r r0;
        o o0;
        u u0;
        v v5;
        V v4;
        W w0;
        M m0;
        D d0;
        List list0;
        int v = 0;
        switch(this.f) {
            case 0: {
                return Boolean.valueOf(!(((a1.b)object0) instanceof D));
            }
            case 1: {
                StringBuilder stringBuilder0 = new StringBuilder("[");
                stringBuilder0.append(((A)object0).b);
                stringBuilder0.append(", ");
                return androidx.appcompat.app.o.q(stringBuilder0, ((A)object0).c, ')');
            }
            case 2: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object object3 = ((List)object0).get(1);
                d5.l l0 = K.b;
                if(kotlin.jvm.internal.q.b(object3, Boolean.FALSE)) {
                    list0 = null;
                }
                else if(object3 != null) {
                    list0 = (List)((k)l0.c).invoke(object3);
                }
                else {
                    list0 = null;
                }
                Object object4 = ((List)object0).get(0);
                String s1 = object4 == null ? null : ((String)object4);
                kotlin.jvm.internal.q.d(s1);
                return new g(list0, s1);
            }
            case 3: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                ArrayList arrayList0 = new ArrayList(((List)object0).size());
                int v1 = ((List)object0).size();
                while(v < v1) {
                    Object object5 = ((List)object0).get(v);
                    d5.l l1 = K.c;
                    a1.e e0 = kotlin.jvm.internal.q.b(object5, Boolean.FALSE) || object5 == null ? null : ((a1.e)((k)l1.c).invoke(object5));
                    kotlin.jvm.internal.q.d(e0);
                    arrayList0.add(e0);
                    ++v;
                }
                return arrayList0;
            }
            case 4: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                Object object6 = ((List)object0).get(0);
                a1.l l2 = object6 == null ? null : ((a1.l)object6);
                kotlin.jvm.internal.q.d(l2);
                Object object7 = ((List)object0).get(2);
                Integer integer0 = object7 == null ? null : ((Integer)object7);
                kotlin.jvm.internal.q.d(integer0);
                int v2 = integer0.intValue();
                Object object8 = ((List)object0).get(3);
                Integer integer1 = object8 == null ? null : ((Integer)object8);
                kotlin.jvm.internal.q.d(integer1);
                int v3 = integer1.intValue();
                Object object9 = ((List)object0).get(4);
                String s2 = object9 == null ? null : ((String)object9);
                kotlin.jvm.internal.q.d(s2);
                switch(l2.ordinal()) {
                    case 0: {
                        Object object10 = ((List)object0).get(1);
                        d5.l l3 = K.h;
                        if(kotlin.jvm.internal.q.b(object10, Boolean.FALSE)) {
                            d0 = null;
                        }
                        else if(object10 != null) {
                            d0 = (D)((k)l3.c).invoke(object10);
                        }
                        else {
                            d0 = null;
                        }
                        kotlin.jvm.internal.q.d(d0);
                        return new a1.e(s2, v2, v3, d0);
                    }
                    case 1: {
                        Object object11 = ((List)object0).get(1);
                        d5.l l4 = K.i;
                        if(kotlin.jvm.internal.q.b(object11, Boolean.FALSE)) {
                            m0 = null;
                        }
                        else if(object11 != null) {
                            m0 = (M)((k)l4.c).invoke(object11);
                        }
                        else {
                            m0 = null;
                        }
                        kotlin.jvm.internal.q.d(m0);
                        return new a1.e(s2, v2, v3, m0);
                    }
                    case 2: {
                        Object object12 = ((List)object0).get(1);
                        d5.l l5 = K.d;
                        if(kotlin.jvm.internal.q.b(object12, Boolean.FALSE)) {
                            w0 = null;
                        }
                        else if(object12 != null) {
                            w0 = (W)((k)l5.c).invoke(object12);
                        }
                        else {
                            w0 = null;
                        }
                        kotlin.jvm.internal.q.d(w0);
                        return new a1.e(s2, v2, v3, w0);
                    }
                    case 3: {
                        Object object13 = ((List)object0).get(1);
                        d5.l l6 = K.e;
                        if(kotlin.jvm.internal.q.b(object13, Boolean.FALSE)) {
                            v4 = null;
                        }
                        else if(object13 != null) {
                            v4 = (V)((k)l6.c).invoke(object13);
                        }
                        else {
                            v4 = null;
                        }
                        kotlin.jvm.internal.q.d(v4);
                        return new a1.e(s2, v2, v3, v4);
                    }
                    case 4: {
                        Object object14 = ((List)object0).get(1);
                        d5.l l7 = K.f;
                        if(kotlin.jvm.internal.q.b(object14, Boolean.FALSE)) {
                            v5 = null;
                        }
                        else if(object14 != null) {
                            v5 = (v)((k)l7.c).invoke(object14);
                        }
                        else {
                            v5 = null;
                        }
                        kotlin.jvm.internal.q.d(v5);
                        return new a1.e(s2, v2, v3, v5);
                    }
                    case 5: {
                        Object object15 = ((List)object0).get(1);
                        d5.l l8 = K.g;
                        if(kotlin.jvm.internal.q.b(object15, Boolean.FALSE)) {
                            u0 = null;
                        }
                        else if(object15 != null) {
                            u0 = (u)((k)l8.c).invoke(object15);
                        }
                        else {
                            u0 = null;
                        }
                        kotlin.jvm.internal.q.d(u0);
                        return new a1.e(s2, v2, v3, u0);
                    }
                    case 6: {
                        Object object16 = ((List)object0).get(1);
                        String s3 = object16 == null ? null : ((String)object16);
                        kotlin.jvm.internal.q.d(s3);
                        return new a1.e(s2, v2, v3, new O(s3));
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            case 5: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.Float");
                return new a(((float)(((Float)object0))));
            }
            case 6: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object object17 = ((List)object0).get(0);
                String s4 = object17 == null ? null : ((String)object17);
                kotlin.jvm.internal.q.d(s4);
                Object object18 = ((List)object0).get(1);
                d5.l l9 = K.j;
                if(kotlin.jvm.internal.q.b(object18, Boolean.FALSE)) {
                    return new u(s4, null);
                }
                return object18 == null ? new u(s4, null) : new u(s4, ((S)((k)l9.c).invoke(object18)));
            }
            case 7: {
                if(kotlin.jvm.internal.q.b(object0, Boolean.FALSE)) {
                    return new s(s.g);
                }
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.Int");
                return new s(y0.M.c(((int)(((Integer)object0)))));
            }
            case 8: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.Int");
                return new y(((int)(((Integer)object0))));
            }
            case 9: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                Object object19 = ((List)object0).get(0);
                f f0 = object19 == null ? null : ((f)object19);
                kotlin.jvm.internal.q.d(f0);
                Object object20 = ((List)object0).get(1);
                l1.h h0 = object20 == null ? null : ((l1.h)object20);
                kotlin.jvm.internal.q.d(h0);
                Object object21 = ((List)object0).get(2);
                kotlin.jvm.internal.q.d((object21 == null ? null : ((l1.g)object21)));
                return new i(f0.a, h0.a);
            }
            case 10: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object object22 = ((List)object0).get(0);
                String s5 = object22 == null ? null : ((String)object22);
                kotlin.jvm.internal.q.d(s5);
                Object object23 = ((List)object0).get(1);
                d5.l l10 = K.j;
                if(kotlin.jvm.internal.q.b(object23, Boolean.FALSE)) {
                    return new v(s5, null);
                }
                return object23 == null ? new v(s5, null) : new v(s5, ((S)((k)l10.c).invoke(object23)));
            }
            case 11: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                ArrayList arrayList1 = new ArrayList(((List)object0).size());
                int v6 = ((List)object0).size();
                while(v < v6) {
                    Object object24 = ((List)object0).get(v);
                    d5.l l11 = K.v;
                    h1.a a0 = kotlin.jvm.internal.q.b(object24, Boolean.FALSE) || object24 == null ? null : ((h1.a)((k)l11.c).invoke(object24));
                    kotlin.jvm.internal.q.d(a0);
                    arrayList1.add(a0);
                    ++v;
                }
                return new b(arrayList1);
            }
            case 12: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.String");
                c.a.getClass();
                Locale locale0 = Locale.forLanguageTag(((String)object0));
                if(kotlin.jvm.internal.q.b(locale0.toLanguageTag(), "und")) {
                    Log.e("Locale", "The language tag " + ((String)object0) + " is not well-formed. Locale is resolved to Undetermined. Note that underscore \'_\' is not a valid subtag delimiter and must be replaced with \'-\'.");
                }
                return new h1.a(locale0);
            }
            case 13: {
                if(kotlin.jvm.internal.q.b(object0, Boolean.FALSE)) {
                    return new x0.b(0x7FC000007FC00000L);
                }
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object object25 = ((List)object0).get(0);
                Float float0 = object25 == null ? null : ((Float)object25);
                kotlin.jvm.internal.q.d(float0);
                Object object26 = ((List)object0).get(1);
                Float float1 = object26 == null ? null : ((Float)object26);
                kotlin.jvm.internal.q.d(float1);
                return new x0.b(((long)Float.floatToRawIntBits(float0.floatValue())) << 0x20 | ((long)Float.floatToRawIntBits(float1.floatValue())) & 0xFFFFFFFFL);
            }
            case 14: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object object27 = ((List)object0).get(0);
                l1.k k0 = object27 == null ? null : ((l1.k)object27);
                kotlin.jvm.internal.q.d(k0);
                int v7 = k0.a;
                Object object28 = ((List)object0).get(1);
                m m1 = object28 == null ? null : ((m)object28);
                kotlin.jvm.internal.q.d(m1);
                int v8 = m1.a;
                Object object29 = ((List)object0).get(2);
                J j0 = K.s;
                if(kotlin.jvm.internal.q.b(object29, Boolean.FALSE) && j0 == null) {
                    o0 = null;
                }
                else if(object29 != null) {
                    o0 = (o)((k)j0.b).invoke(object29);
                }
                else {
                    o0 = null;
                }
                kotlin.jvm.internal.q.d(o0);
                long v9 = o0.a;
                Object object30 = ((List)object0).get(3);
                d5.l l12 = K.m;
                if(kotlin.jvm.internal.q.b(object30, Boolean.FALSE)) {
                    r0 = null;
                }
                else if(object30 != null) {
                    r0 = (l1.r)((k)l12.c).invoke(object30);
                }
                else {
                    r0 = null;
                }
                Object object31 = ((List)object0).get(4);
                d5.l l13 = L.a;
                if(kotlin.jvm.internal.q.b(object31, Boolean.FALSE)) {
                    g0 = null;
                }
                else if(object31 != null) {
                    g0 = (G)((k)l13.c).invoke(object31);
                }
                else {
                    g0 = null;
                }
                Object object32 = ((List)object0).get(5);
                d5.l l14 = K.w;
                if(kotlin.jvm.internal.q.b(object32, Boolean.FALSE)) {
                    i0 = null;
                }
                else if(object32 != null) {
                    i0 = (i)((k)l14.c).invoke(object32);
                }
                else {
                    i0 = null;
                }
                Object object33 = ((List)object0).get(6);
                d5.l l15 = L.b;
                if(kotlin.jvm.internal.q.b(object33, Boolean.FALSE)) {
                    e1 = null;
                }
                else if(object33 != null) {
                    e1 = (e)((k)l15.c).invoke(object33);
                }
                else {
                    e1 = null;
                }
                kotlin.jvm.internal.q.d(e1);
                int v10 = e1.a;
                Object object34 = ((List)object0).get(7);
                d d1 = object34 == null ? null : ((d)object34);
                kotlin.jvm.internal.q.d(d1);
                int v11 = d1.a;
                Object object35 = ((List)object0).get(8);
                d5.l l16 = L.c;
                if(kotlin.jvm.internal.q.b(object35, Boolean.FALSE)) {
                    return new D(v7, v8, v9, r0, g0, i0, v10, v11, null);
                }
                return object35 == null ? new D(v7, v8, v9, r0, g0, i0, v10, v11, null) : new D(v7, v8, v9, r0, g0, i0, v10, v11, ((t)((k)l16.c).invoke(object35)));
            }
            case 15: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                Object object36 = ((List)object0).get(0);
                J j1 = K.r;
                if(kotlin.jvm.internal.q.b(object36, Boolean.FALSE) && j1 == null) {
                    s6 = null;
                }
                else if(object36 != null) {
                    s6 = (s)((k)j1.b).invoke(object36);
                }
                else {
                    s6 = null;
                }
                kotlin.jvm.internal.q.d(s6);
                long v12 = s6.a;
                Object object37 = ((List)object0).get(1);
                J j2 = K.t;
                if(kotlin.jvm.internal.q.b(object37, Boolean.FALSE) && j2 == null) {
                    b0 = null;
                }
                else if(object37 != null) {
                    b0 = (x0.b)((k)j2.b).invoke(object37);
                }
                else {
                    b0 = null;
                }
                kotlin.jvm.internal.q.d(b0);
                Object object38 = ((List)object0).get(2);
                Float float2 = object38 == null ? null : ((Float)object38);
                kotlin.jvm.internal.q.d(float2);
                return new P(v12, b0.a, float2.floatValue());
            }
            case 16: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object object39 = ((List)object0).get(0);
                J j3 = K.r;
                if(kotlin.jvm.internal.q.b(object39, Boolean.FALSE) && j3 == null) {
                    s7 = null;
                }
                else if(object39 != null) {
                    s7 = (s)((k)j3.b).invoke(object39);
                }
                else {
                    s7 = null;
                }
                kotlin.jvm.internal.q.d(s7);
                long v13 = s7.a;
                Object object40 = ((List)object0).get(1);
                J j4 = K.s;
                if(kotlin.jvm.internal.q.b(object40, Boolean.FALSE) && j4 == null) {
                    o1 = null;
                }
                else if(object40 != null) {
                    o1 = (o)((k)j4.b).invoke(object40);
                }
                else {
                    o1 = null;
                }
                kotlin.jvm.internal.q.d(o1);
                long v14 = o1.a;
                Object object41 = ((List)object0).get(2);
                d5.l l17 = K.n;
                if(kotlin.jvm.internal.q.b(object41, Boolean.FALSE)) {
                    y0 = null;
                }
                else if(object41 != null) {
                    y0 = (y)((k)l17.c).invoke(object41);
                }
                else {
                    y0 = null;
                }
                Object object42 = ((List)object0).get(3);
                e1.s s8 = object42 == null ? null : ((e1.s)object42);
                Object object43 = ((List)object0).get(4);
                e1.t t0 = object43 == null ? null : ((e1.t)object43);
                Object object44 = ((List)object0).get(6);
                String s9 = object44 == null ? null : ((String)object44);
                Object object45 = ((List)object0).get(7);
                if(kotlin.jvm.internal.q.b(object45, Boolean.FALSE) && j4 == null) {
                    o2 = null;
                }
                else if(object45 != null) {
                    o2 = (o)((k)j4.b).invoke(object45);
                }
                else {
                    o2 = null;
                }
                kotlin.jvm.internal.q.d(o2);
                long v15 = o2.a;
                Object object46 = ((List)object0).get(8);
                d5.l l18 = K.o;
                if(kotlin.jvm.internal.q.b(object46, Boolean.FALSE)) {
                    a1 = null;
                }
                else if(object46 != null) {
                    a1 = (a)((k)l18.c).invoke(object46);
                }
                else {
                    a1 = null;
                }
                Object object47 = ((List)object0).get(9);
                d5.l l19 = K.l;
                if(kotlin.jvm.internal.q.b(object47, Boolean.FALSE)) {
                    q0 = null;
                }
                else if(object47 != null) {
                    q0 = (q)((k)l19.c).invoke(object47);
                }
                else {
                    q0 = null;
                }
                Object object48 = ((List)object0).get(10);
                d5.l l20 = K.u;
                if(kotlin.jvm.internal.q.b(object48, Boolean.FALSE)) {
                    b1 = null;
                }
                else if(object48 != null) {
                    b1 = (b)((k)l20.c).invoke(object48);
                }
                else {
                    b1 = null;
                }
                Object object49 = ((List)object0).get(11);
                if(kotlin.jvm.internal.q.b(object49, Boolean.FALSE) && j3 == null) {
                    s10 = null;
                }
                else if(object49 != null) {
                    s10 = (s)((k)j3.b).invoke(object49);
                }
                else {
                    s10 = null;
                }
                kotlin.jvm.internal.q.d(s10);
                long v16 = s10.a;
                Object object50 = ((List)object0).get(12);
                d5.l l21 = K.k;
                if(kotlin.jvm.internal.q.b(object50, Boolean.FALSE)) {
                    l22 = null;
                }
                else if(object50 != null) {
                    l22 = (l)((k)l21.c).invoke(object50);
                }
                else {
                    l22 = null;
                }
                Object object51 = ((List)object0).get(13);
                d5.l l23 = K.q;
                if(kotlin.jvm.internal.q.b(object51, Boolean.FALSE)) {
                    return new M(v13, v14, y0, s8, t0, null, s9, v15, a1, q0, b1, v16, l22, null, 0xC020);
                }
                return object51 == null ? new M(v13, v14, y0, s8, t0, null, s9, v15, a1, q0, b1, v16, l22, null, 0xC020) : new M(v13, v14, y0, s8, t0, null, s9, v15, a1, q0, b1, v16, l22, ((P)((k)l23.c).invoke(object51)), 0xC020);
            }
            case 17: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.Int");
                return new l(((int)(((Integer)object0))));
            }
            case 18: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
                return new q(((Number)((List)object0).get(0)).floatValue(), ((Number)((List)object0).get(1)).floatValue());
            }
            case 19: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                Object object52 = ((List)object0).get(0);
                J j5 = K.s;
                if(kotlin.jvm.internal.q.b(object52, Boolean.FALSE) && j5 == null) {
                    o3 = null;
                }
                else if(object52 != null) {
                    o3 = (o)((k)j5.b).invoke(object52);
                }
                else {
                    o3 = null;
                }
                kotlin.jvm.internal.q.d(o3);
                long v17 = o3.a;
                Object object53 = ((List)object0).get(1);
                if(kotlin.jvm.internal.q.b(object53, Boolean.FALSE) && j5 == null) {
                    o4 = null;
                }
                else if(object53 != null) {
                    o4 = (o)((k)j5.b).invoke(object53);
                }
                else {
                    o4 = null;
                }
                kotlin.jvm.internal.q.d(o4);
                return new l1.r(v17, o4.a);
            }
            case 20: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object object54 = ((List)object0).get(0);
                d5.l l24 = K.i;
                if(kotlin.jvm.internal.q.b(object54, Boolean.FALSE)) {
                    m2 = null;
                }
                else if(object54 != null) {
                    m2 = (M)((k)l24.c).invoke(object54);
                }
                else {
                    m2 = null;
                }
                Object object55 = ((List)object0).get(1);
                if(kotlin.jvm.internal.q.b(object55, Boolean.FALSE)) {
                    m3 = null;
                }
                else if(object55 != null) {
                    m3 = (M)((k)l24.c).invoke(object55);
                }
                else {
                    m3 = null;
                }
                Object object56 = ((List)object0).get(2);
                if(kotlin.jvm.internal.q.b(object56, Boolean.FALSE)) {
                    m4 = null;
                }
                else if(object56 != null) {
                    m4 = (M)((k)l24.c).invoke(object56);
                }
                else {
                    m4 = null;
                }
                Object object57 = ((List)object0).get(3);
                if(kotlin.jvm.internal.q.b(object57, Boolean.FALSE)) {
                    return new S(m2, m3, m4, null);
                }
                return object57 == null ? new S(m2, m3, m4, null) : new S(m2, m3, m4, ((M)((k)l24.c).invoke(object57)));
            }
            case 21: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                Object object58 = ((List)object0).get(0);
                Integer integer2 = object58 == null ? null : ((Integer)object58);
                kotlin.jvm.internal.q.d(integer2);
                Object object59 = ((List)object0).get(1);
                Integer integer3 = object59 == null ? null : ((Integer)object59);
                kotlin.jvm.internal.q.d(integer3);
                return new T(a1.t.b(integer2.intValue(), integer3.intValue()));
            }
            case 22: {
                if(kotlin.jvm.internal.q.b(object0, Boolean.FALSE)) {
                    return new o(o.c);
                }
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                Object object60 = ((List)object0).get(0);
                Float float3 = object60 == null ? null : ((Float)object60);
                kotlin.jvm.internal.q.d(float3);
                Object object61 = ((List)object0).get(1);
                p p0 = object61 == null ? null : ((p)object61);
                kotlin.jvm.internal.q.d(p0);
                return new o(e1.u.M(p0.a, float3.floatValue()));
            }
            case 23: {
                String s11 = object0 == null ? null : ((String)object0);
                kotlin.jvm.internal.q.d(s11);
                return new V(s11);
            }
            case 24: {
                String s12 = object0 == null ? null : ((String)object0);
                kotlin.jvm.internal.q.d(s12);
                return new W(s12);
            }
            case 25: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.Int");
                return new e(((int)(((Integer)object0))));
            }
            case 26: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                Object object62 = ((List)object0).get(0);
                Boolean boolean1 = object62 == null ? null : ((Boolean)object62);
                kotlin.jvm.internal.q.d(boolean1);
                Object object63 = ((List)object0).get(1);
                kotlin.jvm.internal.q.d((object63 == null ? null : ((a1.q)object63)));
                return new G(boolean1.booleanValue());
            }
            default: {
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                Object object1 = ((List)object0).get(0);
                l1.s s0 = object1 == null ? null : ((l1.s)object1);
                kotlin.jvm.internal.q.d(s0);
                Object object2 = ((List)object0).get(1);
                Boolean boolean0 = object2 == null ? null : ((Boolean)object2);
                kotlin.jvm.internal.q.d(boolean0);
                return new t(s0.a, boolean0.booleanValue());
            }
        }
    }
}

