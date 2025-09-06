package i.n.i.b.a.s.e;

import android.net.Uri;
import java.util.Collections;

public final class h {
    public Object a;
    public Object b;
    public e c;
    public Object d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;
    public boolean j;
    public c k;
    public boolean l;
    public long m;
    public long n;
    public int o;
    public int p;
    public long q;
    public static final Object r;
    public static final e s;

    static {
        h.r = new Object();
        d d0 = Uri.EMPTY == null ? null : new d(Uri.EMPTY, Collections.EMPTY_MAP, null, null, Collections.EMPTY_LIST, Collections.EMPTY_LIST);
        h.s = new e("com.google.android.exoplayer2.Timeline", new b(0x8000000000000000L), d0, new c(0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L, -3.402823E+38f, -3.402823E+38f), M.e);
    }

    public h() {
        this.a = h.r;
        this.c = h.s;
    }

    public final void a(e e0, Object object0, long v, long v1, long v2, boolean z, boolean z1, c c0, long v3, long v4, int v5, long v6) {
        this.a = h.r;
        this.c = e0 == null ? h.s : e0;
        this.b = null;
        this.d = object0;
        this.e = v;
        this.f = v1;
        this.g = v2;
        this.h = z;
        this.i = z1;
        this.j = c0 != null;
        this.k = c0;
        this.m = v3;
        this.n = v4;
        this.o = 0;
        this.p = v5;
        this.q = v6;
        this.l = false;
    }

    public final boolean b() {
        M7.J(this.j == (this.k != null));
        return this.k != null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                return h.class.equals(class0) && L7.p(this.a, ((h)object0).a) && L7.p(this.c, ((h)object0).c) && L7.p(this.d, ((h)object0).d) && L7.p(this.k, ((h)object0).k) && this.e == ((h)object0).e && this.f == ((h)object0).f && this.g == ((h)object0).g && this.h == ((h)object0).h && this.i == ((h)object0).i && this.l == ((h)object0).l && this.m == ((h)object0).m && this.n == ((h)object0).n && this.o == ((h)object0).o && this.p == ((h)object0).p && this.q == ((h)object0).q;
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = this.c.hashCode();
        int v2 = 0;
        int v3 = this.d == null ? 0 : this.d.hashCode();
        c c0 = this.k;
        if(c0 != null) {
            v2 = c0.hashCode();
        }
        return (((((((((((((v1 + (v + 0xD9) * 0x1F) * 0x1F + v3) * 0x1F + v2) * 0x1F + ((int)(this.e ^ this.e >>> 0x20))) * 0x1F + ((int)(this.f ^ this.f >>> 0x20))) * 0x1F + ((int)(this.g ^ this.g >>> 0x20))) * 0x1F + this.h) * 0x1F + this.i) * 0x1F + this.l) * 0x1F + ((int)(this.m ^ this.m >>> 0x20))) * 0x1F + ((int)(this.n ^ this.n >>> 0x20))) * 0x1F + this.o) * 0x1F + this.p) * 0x1F + ((int)(this.q ^ this.q >>> 0x20));
    }
}

