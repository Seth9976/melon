package b3;

import I6.Q;
import I6.V;
import android.util.Pair;
import e3.b;
import java.util.Objects;

public final class b0 {
    public final Object a;
    public final w0 b;
    public final E c;
    public final G d;
    public final Object e;
    public final y f;
    public final long g;
    public final long h;
    public final long i;
    public final boolean j;
    public final boolean k;
    public final long l;
    public final long m;
    public final long n;
    public final boolean o;
    public final V p;
    public final long[] q;

    public b0(a0 a00) {
        if(a00.f == null) {
            b.d(a00.g == 0x8000000000000001L, "presentationStartTimeMs can only be set if liveConfiguration != null");
            b.d(a00.h == 0x8000000000000001L, "windowStartTimeMs can only be set if liveConfiguration != null");
            b.d(a00.i == 0x8000000000000001L, "elapsedRealtimeEpochOffsetMs can only be set if liveConfiguration != null");
        }
        else {
            long v1 = a00.g;
            if(v1 != 0x8000000000000001L) {
                long v2 = a00.h;
                if(v2 != 0x8000000000000001L) {
                    b.d(v2 >= v1, "windowStartTimeMs can\'t be less than presentationStartTimeMs");
                }
            }
        }
        int v3 = a00.p.size();
        long v4 = a00.m;
        if(v4 != 0x8000000000000001L) {
            b.d(a00.l <= v4, "defaultPositionUs can\'t be greater than durationUs");
        }
        this.a = a00.a;
        this.b = a00.b;
        this.c = a00.c;
        this.d = a00.d;
        this.e = a00.e;
        this.f = a00.f;
        this.g = a00.g;
        this.h = a00.h;
        this.i = a00.i;
        this.j = a00.j;
        this.k = a00.k;
        this.l = a00.l;
        this.m = a00.m;
        long v5 = a00.n;
        this.n = v5;
        this.o = a00.o;
        V v6 = a00.p;
        this.p = v6;
        long[] arr_v = new long[v6.size()];
        this.q = arr_v;
        if(!v6.isEmpty()) {
            arr_v[0] = -v5;
            for(int v = 0; v < v3 - 1; ++v) {
                this.q[v + 1] = this.q[v] + ((d0)this.p.get(v)).b;
            }
        }
    }

    public static b0 a(i0 i00, int v, m0 m00, o0 o00) {
        p0 p00 = i00.t;
        boolean z = (i00.x == -1 ? 0 : i00.x) == v;
        p00.n(v, o00);
        Q q0 = V.o();
        for(int v1 = o00.n; v1 <= o00.o; ++v1) {
            p00.f(v1, m00, true);
            Object object0 = m00.b;
            object0.getClass();
            c0 c00 = new c0();  // 初始化器: Ljava/lang/Object;-><init>()V
            c00.a = object0;
            c00.b = 0L;
            c00.d = false;
            c00.c = m00.g;
            long v2 = m00.d;
            b.c(v2 == 0x8000000000000001L || v2 >= 0L);
            c00.b = v2;
            c00.d = m00.f;
            q0.a(new d0(c00));
        }
        a0 a00 = new a0(o00.a);
        long v3 = o00.l;
        b.c(v3 >= 0L);
        a00.l = v3;
        long v4 = o00.m;
        b.c(v4 == 0x8000000000000001L || v4 >= 0L);
        a00.m = v4;
        a00.i = o00.g;
        a00.k = o00.i;
        a00.o = o00.k;
        a00.j = o00.h;
        a00.f = o00.j;
        a00.e = o00.d;
        a00.c = o00.c;
        a00.d = z ? i00.v : null;
        I6.p0 p01 = q0.g();
        int v5 = p01.d;
        for(int v6 = 0; v6 < v5 - 1; ++v6) {
            b.d(((d0)p01.get(v6)).b != 0x8000000000000001L, "Periods other than last need a duration");
            for(int v7 = v6 + 1; v7 < v5; ++v7) {
                b.d(!((d0)p01.get(v6)).a.equals(((d0)p01.get(v7)).a), "Duplicate PeriodData UIDs in period list");
            }
        }
        a00.p = V.p(p01);
        long v8 = o00.p;
        b.c(v8 >= 0L);
        a00.n = v8;
        a00.g = o00.e;
        a00.b = z ? i00.u : w0.b;
        a00.h = o00.f;
        return new b0(a00);
    }

    public static Object b(b0 b00, int v) {
        Object object0 = b00.a;
        V v1 = b00.p;
        return v1.isEmpty() ? object0 : Pair.create(object0, ((d0)v1.get(v)).a);
    }

    public final a0 c() {
        a0 a00 = new a0();  // 初始化器: Ljava/lang/Object;-><init>()V
        a00.a = this.a;
        a00.b = this.b;
        a00.c = this.c;
        a00.d = this.d;
        a00.e = this.e;
        a00.f = this.f;
        a00.g = this.g;
        a00.h = this.h;
        a00.i = this.i;
        a00.j = this.j;
        a00.k = this.k;
        a00.l = this.l;
        a00.m = this.m;
        a00.n = this.n;
        a00.o = this.o;
        a00.p = this.p;
        return a00;
    }

    // 去混淆评级： 低(26)
    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b0 ? this.a.equals(((b0)object0).a) && this.b.equals(((b0)object0).b) && this.c.equals(((b0)object0).c) && Objects.equals(this.d, ((b0)object0).d) && Objects.equals(this.e, ((b0)object0).e) && Objects.equals(this.f, ((b0)object0).f) && this.g == ((b0)object0).g && this.h == ((b0)object0).h && this.i == ((b0)object0).i && this.j == ((b0)object0).j && this.k == ((b0)object0).k && this.l == ((b0)object0).l && this.m == ((b0)object0).m && this.n == ((b0)object0).n && this.o == ((b0)object0).o && this.p.equals(((b0)object0).p) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = this.b.a.hashCode();
        int v2 = this.c.hashCode();
        int v3 = 0;
        int v4 = this.d == null ? 0 : this.d.hashCode();
        int v5 = this.e == null ? 0 : this.e.hashCode();
        y y0 = this.f;
        if(y0 != null) {
            v3 = y0.hashCode();
        }
        return this.p.hashCode() + (((((((((((((v2 + (v1 + (v + 0xD9) * 0x1F) * 0x1F) * 0x1F + v4) * 0x1F + v5) * 0x1F + v3) * 0x1F + ((int)(this.g ^ this.g >>> 0x20))) * 0x1F + ((int)(this.h ^ this.h >>> 0x20))) * 0x1F + ((int)(this.i ^ this.i >>> 0x20))) * 0x1F + this.j) * 0x1F + this.k) * 0x1F + ((int)(this.l ^ this.l >>> 0x20))) * 0x1F + ((int)(this.m ^ this.m >>> 0x20))) * 0x1F + ((int)(this.n ^ this.n >>> 0x20))) * 0x1F + this.o) * 0x1F;
    }
}

