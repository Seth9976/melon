package androidx.media3.session;

import E9.g;
import I6.V;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseBooleanArray;
import b3.E;
import b3.N;
import b3.S;
import b3.m;
import e3.b;
import e3.x;
import java.util.ArrayList;
import java.util.List;

public abstract class h1 {
    public static final g a;

    static {
        h1.a = new g("androidx.media3.session.MediaLibraryService", null);
    }

    public static boolean a(v1 v10, v1 v11) {
        return v10.a.b == v11.a.b && v10.a.e == v11.a.e && v10.a.h == v11.a.h && v10.a.i == v11.a.i;
    }

    public static int b(long v, long v1) {
        if(Long.compare(v, 0x8000000000000001L) != 0 && v1 != 0x8000000000000001L) {
            return Long.compare(v1, 0L) == 0 ? 100 : x.h(((int)(v * 100L / v1)), 0, 100);
        }
        return 0;
    }

    public static long c(k1 k10, long v, long v1, long v2) {
        v1 v10 = k10.c;
        boolean z = k10.c.equals(v1.l) || v1 < v10.c;
        if(!k10.v) {
            return !z && v != 0x8000000000000001L ? v : v10.a.f;
        }
        if(!z && v != 0x8000000000000001L) {
            return v;
        }
        if(v2 == 0x8000000000000001L) {
            v2 = SystemClock.elapsedRealtime() - v10.c;
        }
        long v3 = v10.a.f + ((long)(((float)v2) * k10.g.a));
        return v10.d == 0x8000000000000001L ? v3 : Math.min(v3, v10.d);
    }

    public static N d(N n0, N n1) {
        if(n0 != null) {
            m m0 = n0.a;
            if(n1 != null) {
                SparseBooleanArray sparseBooleanArray0 = new SparseBooleanArray();
                for(int v = 0; v < m0.a.size(); ++v) {
                    if(n1.a(m0.b(v))) {
                        int v1 = m0.b(v);
                        b.j(((boolean)1));
                        sparseBooleanArray0.append(v1, true);
                    }
                }
                b.j(((boolean)1));
                return new N(new m(sparseBooleanArray0));
            }
        }
        return N.b;
    }

    public static Pair e(k1 k10, i1 i10, k1 k11, i1 i11, N n0) {
        boolean z = i11.b;
        if(i11.a && n0.a(17) && !i10.a) {
            k11 = k11.l(k10.j);
            i11 = new i1(false, z);
        }
        if(z && n0.a(30) && !i10.b) {
            k11 = k11.b(k10.D);
            i11 = new i1(i11.a, false);
        }
        return new Pair(k11, i11);
    }

    public static void f(S s0, x0 x00) {
        long v = x00.c;
        V v1 = x00.a;
        if(x00.b == -1) {
            if(s0.Y(20)) {
                s0.U(v1);
                return;
            }
            if(!v1.isEmpty()) {
                s0.G(((E)v1.get(0)));
            }
        }
        else {
            if(s0.Y(20)) {
                s0.D(v1, x00.b, v);
                return;
            }
            if(!v1.isEmpty()) {
                s0.g(((E)v1.get(0)), v);
            }
        }
    }

    public static ArrayList g(List list0) {
        ArrayList arrayList0 = new ArrayList();
        Parcel parcel0 = Parcel.obtain();
        try {
            for(int v = 0; v < list0.size(); ++v) {
                Parcelable parcelable0 = (Parcelable)list0.get(v);
                parcel0.writeParcelable(parcelable0, 0);
                if(parcel0.dataSize() >= 0x40000) {
                    break;
                }
                arrayList0.add(parcelable0);
            }
            return arrayList0;
        }
        finally {
            parcel0.recycle();
        }
    }
}

