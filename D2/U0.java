package D2;

import B2.n;
import J2.a;
import J2.b;
import J2.o;
import J2.u;
import O2.c;
import O2.e;
import O2.f;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.RemoteViews;
import i.n.i.b.a.s.e.M3;
import ie.m;
import java.util.ArrayList;
import java.util.Map;
import je.C;
import je.D;
import je.x;

public abstract class u0 {
    public static final Object a;
    public static final int b;
    public static final int c;

    static {
        u0.a = C.S(new m[]{new m(x0.d, 0x7F0D03C7), new m(x0.e, 0x7F0D0385), new m(x0.f, 0x7F0D02F9), new m(x0.g, 0x7F0D02FA), new m(x0.h, 0x7F0D02ED), new m(x0.B, 0x7F0D03AF), new m(x0.D, 0x7F0D03B0), new m(x0.i, 0x7F0D0324), new m(x0.E, 0x7F0D0330), new m(x0.M, 0x7F0D0334), new m(x0.G, 0x7F0D0360), new m(x0.N, 0x7F0D0364), new m(x0.I, 0x7F0D0348), new m(x0.S, 0x7F0D034C), new m(x0.j, 0x7F0D0379), new m(x0.k, 0x7F0D0314), new m(x0.l, 0x7F0D03F7), new m(x0.m, 0x7F0D040F), new m(x0.n, 0x7F0D0403), new m(x0.o, 0x7F0D03EB), new m(x0.r, 0x7F0D03DF), new m(x0.w, 0x7F0D03D3), new m(x0.T, 0x7F0D0392), new m(x0.V, 0x7F0D0393)});  // layout:glance_text
        int v = ((Map)N.f).size();
        u0.b = v;
        u0.c = Build.VERSION.SDK_INT < 0x1F ? N.h / v : N.h;
    }

    public static final F0 a(U0 u00, n n0, int v) {
        int v1 = Build.VERSION.SDK_INT;
        if(v1 >= 0x1F) {
            int v2 = N.h;
            if(v >= v2) {
                throw new IllegalArgumentException(("Index of the root view cannot be more than " + v2 + ", currently " + v).toString());
            }
            R0 r00 = new R0(1, 1);
            RemoteViews remoteViews0 = new RemoteViews("com.iloen.melon", N.g + v);
            u u0 = (u)n0.foldIn(null, d.m);
            if(u0 != null) {
                V4.u.k(remoteViews0, u0, 0x7F0A0A09);  // id:rootView
            }
            o o0 = (o)n0.foldIn(null, d.n);
            if(o0 != null) {
                V4.u.j(remoteViews0, o0, 0x7F0A0A09);  // id:rootView
            }
            if(v1 >= 33) {
                remoteViews0.removeAllViews(0x7F0A0A09);  // id:rootView
            }
            return v1 < 33 ? new F0(remoteViews0, new o0(0x7F0A0A09, 0, D.O(new m(0, D.O(new m(r00, 0x7F0A0A08)))), 2)) : new F0(remoteViews0, new o0(0x7F0A0A09, 0, x.a, 2));  // id:rootView
        }
        int v3 = u0.b * v;
        int v4 = N.h;
        int v5 = 4;
        if(v3 >= v4) {
            throw new IllegalArgumentException(("Index of the root view cannot be more than " + v4 / 4 + ", currently " + v).toString());
        }
        u u1 = (u)n0.foldIn(null, d.k);
        f f0 = e.a;
        f f1 = u1 == null ? f0 : u1.a;
        o o1 = (o)n0.foldIn(null, d.l);
        if(o1 != null) {
            f0 = o1.a;
        }
        int v6 = f1.equals(O2.d.a) ? 4 : 1;
        if(!f0.equals(O2.d.a)) {
            v5 = 1;
        }
        R0 r01 = new R0(v6, v5);
        Integer integer0 = (Integer)((Map)N.f).get(r01);
        if(integer0 == null) {
            throw new IllegalStateException("Cannot find root element for size [" + A7.d.y(v6) + ", " + A7.d.y(v5) + ']');
        }
        return new F0(new RemoteViews("com.iloen.melon", v3 + N.g + ((int)integer0)), new o0(0, 0, D.O(new m(0, D.O(new m(r01, 0x7F0A0A08)))), 3));  // id:rootStubId
    }

    public static final o0 b(RemoteViews remoteViews0, U0 u00, x0 x00, int v, n n0, a a0, b b0) {
        int v2;
        int v1 = 10;
        if(v > 10) {
            Log.e("GlanceAppWidget", "Truncated " + x00 + " container from " + v + " to 10 elements", new IllegalArgumentException(x00 + " container cannot have more than 10 elements"));
        }
        if(v <= 10) {
            v1 = v;
        }
        Integer integer0 = u0.f(x00, n0);
        if(integer0 == null) {
            B b1 = new B(x00, v1, a0, b0);
            A a1 = (A)N.a.get(b1);
            Integer integer1 = a1 == null ? null : a1.a;
            if(integer1 == null) {
                throw new IllegalArgumentException("Cannot find container " + x00 + " with " + v + " children");
            }
            v2 = (int)integer1;
        }
        else {
            v2 = (int)integer0;
        }
        Map map0 = (Map)N.b.get(x00);
        if(map0 == null) {
            throw new IllegalArgumentException("Cannot find generated children for " + x00);
        }
        o0 o00 = u0.d(remoteViews0, u00, v2, n0);
        int v3 = o00.a;
        o0 o01 = new o0(v3, o00.b, map0);
        if(Build.VERSION.SDK_INT >= 33) {
            remoteViews0.removeAllViews(v3);
        }
        return o01;
    }

    public static final o0 c(RemoteViews remoteViews0, U0 u00, x0 x00, n n0) {
        Integer integer0 = u0.f(x00, n0);
        if(integer0 == null) {
            integer0 = (Integer)((Map)u0.a).get(x00);
            if(integer0 == null) {
                throw new IllegalArgumentException("Cannot use `insertView` with a container like " + x00);
            }
        }
        return u0.d(remoteViews0, u00, ((int)integer0), n0);
    }

    public static final o0 d(RemoteViews remoteViews0, U0 u00, int v, n n0) {
        Integer integer0;
        int v1 = u00.e;
        u u0 = (u)n0.foldIn(null, d.o);
        f f0 = e.a;
        f f1 = u0 == null ? f0 : u0.a;
        o o0 = (o)n0.foldIn(null, d.r);
        if(o0 != null) {
            f0 = o0.a;
        }
        int v2 = 1;
        if(n0.a()) {
            integer0 = null;
        }
        else if(!u00.i.getAndSet(true)) {
            integer0 = 0x1020000;
        }
        else {
            throw new IllegalStateException("At most one view can be set as AppWidgetBackground.");
        }
        int v3 = Build.VERSION.SDK_INT;
        if(v3 >= 33) {
            int v4 = integer0 == null ? u00.g.incrementAndGet() : ((int)integer0);
            RemoteViews remoteViews1 = t0.a.a("com.iloen.melon", v, v4);
            I0.a.a(remoteViews0, u00.h.a, remoteViews1, v1);
            return new o0(v4, 0, null, 6);
        }
        if(v3 >= 0x1F) {
            int v5 = f1.equals(c.a) ? 3 : 1;
            if(f0.equals(c.a)) {
                v2 = 3;
            }
            return new o0(B.a.R(remoteViews0, u00, u0.e(remoteViews0, u00, v1, v5, v2), v, integer0), 0, null, 6);
        }
        int v6 = u0.g(f1);
        int v7 = u0.g(f0);
        int v8 = u0.e(remoteViews0, u00, v1, v6, v7);
        if(v6 != 2 && v7 != 2) {
            return new o0(B.a.R(remoteViews0, u00, v8, v, integer0), 0, null, 6);
        }
        R0 r00 = new R0(v6, v7);
        s0 s00 = (s0)((Map)N.e).get(r00);
        if(s00 == null) {
            throw new IllegalArgumentException("Could not find complex layout for width=" + A7.d.y(v6) + ", height=" + A7.d.y(v7));
        }
        int v9 = B.a.R(remoteViews0, u00, v8, s00.a, null);
        return new o0(B.a.R(remoteViews0, u00, 0x7F0A04F3, v, integer0), v9, null, 4);  // id:glanceViewStub
    }

    public static final int e(RemoteViews remoteViews0, U0 u00, int v, int v1, int v2) {
        R0 r00 = new R0((v1 == 2 ? 1 : v1), (v2 == 2 ? 1 : v2));
        Map map0 = (Map)u00.h.c.get(v);
        if(map0 == null) {
            throw new IllegalStateException("Parent doesn\'t have child position " + v);
        }
        Integer integer0 = (Integer)map0.get(r00);
        if(integer0 != null) {
            int v3 = (int)integer0;
            Iterable iterable0 = map0.values();
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: iterable0) {
                if(((Number)object0).intValue() != v3) {
                    arrayList0.add(object0);
                }
            }
            for(Object object1: arrayList0) {
                B.a.R(remoteViews0, u00, ((Number)object1).intValue(), 0x7F0D0322, 0x7F0A039F);  // layout:glance_deleted_view
            }
            return v3;
        }
        StringBuilder stringBuilder0 = U4.x.n(v, "No child for position ", " and size ");
        stringBuilder0.append(A7.d.y(v1));
        stringBuilder0.append(" x ");
        stringBuilder0.append(A7.d.y(v2));
        throw new IllegalStateException(stringBuilder0.toString());
    }

    public static final Integer f(x0 x00, n n0) {
        if(Build.VERSION.SDK_INT >= 33) {
            D2.a a0 = (D2.a)n0.foldIn(null, d.w);
            u u0 = (u)n0.foldIn(null, d.B);
            boolean z = false;
            c c0 = c.a;
            boolean z1 = u0 == null ? false : u0.a.equals(c0);
            o o0 = (o)n0.foldIn(null, d.D);
            if(o0 != null) {
                z = o0.a.equals(c0);
            }
            if(a0 != null) {
                J2.c c1 = a0.a;
                w w0 = new w(x00, c1.a, c1.b);
                s0 s00 = (s0)((Map)N.c).get(w0);
                if(s00 == null) {
                    throw new IllegalArgumentException("Cannot find " + x00 + " with alignment " + c1);
                }
                return s00.a;
            }
            if(z1 || z) {
                J0 j00 = new J0(x00, z1, z);
                s0 s01 = (s0)((Map)N.d).get(j00);
                if(s01 == null) {
                    throw new IllegalArgumentException("Cannot find " + x00 + " with defaultWeight set");
                }
                return s01.a;
            }
        }
        return null;
    }

    public static final int g(f f0) {
        if(f0 instanceof e) {
            return 1;
        }
        if(f0 instanceof c) {
            return 3;
        }
        if(f0 instanceof O2.d) {
            return 4;
        }
        if(!(f0 instanceof O2.b)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return 2;
    }
}

