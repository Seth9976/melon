package androidx.media3.session;

import U4.x;
import android.os.Bundle;
import b3.Q;
import e3.b;
import java.util.Arrays;

public final class v1 {
    public final Q a;
    public final boolean b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public static final Q k;
    public static final v1 l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;

    static {
        Q q0 = new Q(null, 0, null, null, 0, 0L, 0L, -1, -1);
        v1.k = q0;
        v1.l = new v1(q0, false, 0x8000000000000001L, 0x8000000000000001L, 0L, 0, 0L, 0x8000000000000001L, 0x8000000000000001L, 0L);
        v1.m = "0";
        v1.n = "1";
        v1.o = "2";
        v1.p = "3";
        v1.q = "4";
        v1.r = "5";
        v1.s = "6";
        v1.t = "7";
        v1.u = "8";
        v1.v = "9";
    }

    public v1(Q q0, boolean z, long v, long v1, long v2, int v3, long v4, long v5, long v6, long v7) {
        b.c(z == (q0.h != -1));
        this.a = q0;
        this.b = z;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = v4;
        this.h = v5;
        this.i = v6;
        this.j = v7;
    }

    public final v1 a(boolean z, boolean z1) {
        if(z && z1) {
            return this;
        }
        Q q0 = this.a.b(z, z1);
        int v = 0;
        boolean z2 = z && this.b;
        long v1 = z ? this.d : 0x8000000000000001L;
        long v2 = z ? this.e : 0L;
        if(z) {
            v = this.f;
        }
        long v3 = z ? this.g : 0L;
        long v4 = z ? this.h : 0x8000000000000001L;
        long v5 = z ? this.i : 0x8000000000000001L;
        return z ? new v1(q0, z2, this.c, v1, v2, v, v3, v4, v5, this.j) : new v1(q0, z2, this.c, v1, v2, v, v3, v4, v5, 0L);
    }

    public static v1 b(Bundle bundle0) {
        Bundle bundle1 = bundle0.getBundle(v1.m);
        return bundle1 == null ? new v1(v1.k, bundle0.getBoolean(v1.n, false), bundle0.getLong(v1.o, 0x8000000000000001L), bundle0.getLong(v1.p, 0x8000000000000001L), bundle0.getLong(v1.q, 0L), bundle0.getInt(v1.r, 0), bundle0.getLong(v1.s, 0L), bundle0.getLong(v1.t, 0x8000000000000001L), bundle0.getLong(v1.u, 0x8000000000000001L), bundle0.getLong(v1.v, 0L)) : new v1(Q.c(bundle1), bundle0.getBoolean(v1.n, false), bundle0.getLong(v1.o, 0x8000000000000001L), bundle0.getLong(v1.p, 0x8000000000000001L), bundle0.getLong(v1.q, 0L), bundle0.getInt(v1.r, 0), bundle0.getLong(v1.s, 0L), bundle0.getLong(v1.t, 0x8000000000000001L), bundle0.getLong(v1.u, 0x8000000000000001L), bundle0.getLong(v1.v, 0L));
    }

    public final Bundle c(int v) {
        Bundle bundle0 = new Bundle();
        Q q0 = this.a;
        if(v < 3 || !v1.k.a(q0)) {
            bundle0.putBundle("0", q0.d(v));
        }
        if(this.b) {
            bundle0.putBoolean("1", true);
        }
        long v1 = this.c;
        if(v1 != 0x8000000000000001L) {
            bundle0.putLong("2", v1);
        }
        long v2 = this.d;
        if(v2 != 0x8000000000000001L) {
            bundle0.putLong("3", v2);
        }
        long v3 = this.e;
        if(v < 3 || v3 != 0L) {
            bundle0.putLong("4", v3);
        }
        int v4 = this.f;
        if(v4 != 0) {
            bundle0.putInt("5", v4);
        }
        long v5 = this.g;
        if(v5 != 0L) {
            bundle0.putLong("6", v5);
        }
        long v6 = this.h;
        if(v6 != 0x8000000000000001L) {
            bundle0.putLong("7", v6);
        }
        long v7 = this.i;
        if(v7 != 0x8000000000000001L) {
            bundle0.putLong("8", v7);
        }
        long v8 = this.j;
        if(v >= 3 && v8 == 0L) {
            return bundle0;
        }
        bundle0.putLong("9", v8);
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return v1.class == class0 && this.c == ((v1)object0).c && this.a.equals(((v1)object0).a) && this.b == ((v1)object0).b && this.d == ((v1)object0).d && this.e == ((v1)object0).e && this.f == ((v1)object0).f && this.g == ((v1)object0).g && this.h == ((v1)object0).h && this.i == ((v1)object0).i && this.j == ((v1)object0).j;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Boolean.valueOf(this.b)});
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SessionPositionInfo {PositionInfo {mediaItemIndex=");
        stringBuilder0.append(this.a.b);
        stringBuilder0.append(", periodIndex=");
        stringBuilder0.append(this.a.e);
        stringBuilder0.append(", positionMs=");
        stringBuilder0.append(this.a.f);
        stringBuilder0.append(", contentPositionMs=");
        stringBuilder0.append(this.a.g);
        stringBuilder0.append(", adGroupIndex=");
        stringBuilder0.append(this.a.h);
        stringBuilder0.append(", adIndexInAdGroup=");
        stringBuilder0.append(this.a.i);
        stringBuilder0.append("}, isPlayingAd=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", eventTimeMs=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", durationMs=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", bufferedPositionMs=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", bufferedPercentage=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", totalBufferedDurationMs=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", currentLiveOffsetMs=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", contentDurationMs=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", contentBufferedPositionMs=");
        return x.h(this.j, "}", stringBuilder0);
    }
}

