package d5;

import U4.D;
import U4.d;
import U4.i;
import U4.x;
import androidx.appcompat.app.o;
import com.iloen.melon.fragments.musicmessage.e;
import e0.b;
import k8.Y;

public final class q {
    public final String a;
    public D b;
    public final String c;
    public final String d;
    public i e;
    public final i f;
    public long g;
    public final long h;
    public final long i;
    public d j;
    public final int k;
    public final int l;
    public final long m;
    public long n;
    public final long o;
    public final long p;
    public boolean q;
    public final int r;
    public final int s;
    public final int t;
    public final long u;
    public final int v;
    public final int w;
    public String x;
    public static final e y;

    static {
        kotlin.jvm.internal.q.f("WM-WorkSpec", "tagWithPrefix(\"WorkSpec\")");
        q.y = new e(26);
    }

    public q(String s, D d0, String s1, String s2, i i0, i i1, long v, long v1, long v2, d d1, int v3, int v4, long v5, long v6, long v7, long v8, boolean z, int v9, int v10, int v11, long v12, int v13, int v14, String s3) {
        kotlin.jvm.internal.q.g(s, "id");
        kotlin.jvm.internal.q.g(d0, "state");
        kotlin.jvm.internal.q.g(s1, "workerClassName");
        kotlin.jvm.internal.q.g(s2, "inputMergerClassName");
        kotlin.jvm.internal.q.g(i0, "input");
        kotlin.jvm.internal.q.g(i1, "output");
        kotlin.jvm.internal.q.g(d1, "constraints");
        Y.r(v4, "backoffPolicy");
        Y.r(v9, "outOfQuotaPolicy");
        super();
        this.a = s;
        this.b = d0;
        this.c = s1;
        this.d = s2;
        this.e = i0;
        this.f = i1;
        this.g = v;
        this.h = v1;
        this.i = v2;
        this.j = d1;
        this.k = v3;
        this.l = v4;
        this.m = v5;
        this.n = v6;
        this.o = v7;
        this.p = v8;
        this.q = z;
        this.r = v9;
        this.s = v10;
        this.t = v11;
        this.u = v12;
        this.v = v13;
        this.w = v14;
        this.x = s3;
    }

    public q(String s, D d0, String s1, String s2, i i0, i i1, long v, long v1, long v2, d d1, int v3, int v4, long v5, long v6, long v7, long v8, boolean z, int v9, int v10, long v11, int v12, int v13, String s3, int v14) {
        this(s, ((v14 & 2) == 0 ? d0 : D.a), s1, ((v14 & 8) == 0 ? s2 : "androidx.work.OverwritingInputMerger"), ((v14 & 16) == 0 ? i0 : i.b), ((v14 & 0x20) == 0 ? i1 : i.b), ((v14 & 0x40) == 0 ? v : 0L), ((v14 & 0x80) == 0 ? v1 : 0L), ((v14 & 0x100) == 0 ? v2 : 0L), ((v14 & 0x200) == 0 ? d1 : d.j), ((v14 & 0x400) == 0 ? v3 : 0), ((v14 & 0x800) == 0 ? v4 : 1), ((v14 & 0x1000) == 0 ? v5 : 30000L), ((v14 & 0x2000) == 0 ? v6 : -1L), ((v14 & 0x4000) == 0 ? v7 : 0L), ((0x8000 & v14) == 0 ? v8 : -1L), ((0x10000 & v14) == 0 ? z : false), ((0x20000 & v14) == 0 ? v9 : 1), ((0x40000 & v14) == 0 ? v10 : 0), 0, ((0x100000 & v14) == 0 ? v11 : 0x7FFFFFFFFFFFFFFFL), ((0x200000 & v14) == 0 ? v12 : 0), ((0x400000 & v14) == 0 ? v13 : 0xFFFFFF00), ((v14 & 0x800000) == 0 ? s3 : null));
    }

    public final long a() {
        boolean z = this.b == D.a && this.k > 0;
        long v = this.n;
        boolean z1 = this.c();
        return n.m(z, this.k, this.l, this.m, v, this.s, z1, this.g, this.i, this.h, this.u);
    }

    public final boolean b() {
        return !kotlin.jvm.internal.q.b(d.j, this.j);
    }

    public final boolean c() {
        return this.h != 0L;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof q) {
                q q0 = (q)object0;
                return kotlin.jvm.internal.q.b(this.a, q0.a) && this.b == q0.b && kotlin.jvm.internal.q.b(this.c, q0.c) && kotlin.jvm.internal.q.b(this.d, q0.d) && kotlin.jvm.internal.q.b(this.e, q0.e) && kotlin.jvm.internal.q.b(this.f, q0.f) && this.g == q0.g && this.h == q0.h && this.i == q0.i && kotlin.jvm.internal.q.b(this.j, q0.j) && this.k == q0.k && this.l == q0.l && this.m == q0.m && this.n == q0.n && this.o == q0.o && this.p == q0.p && this.q == q0.q && this.r == q0.r && this.s == q0.s && this.t == q0.t && this.u == q0.u && this.v == q0.v && this.w == q0.w && kotlin.jvm.internal.q.b(this.x, q0.x);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = A7.d.b(this.k, (this.j.hashCode() + A7.d.c(A7.d.c(A7.d.c((this.f.hashCode() + (this.e.hashCode() + x.b(x.b((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c), 0x1F, this.d)) * 0x1F) * 0x1F, 0x1F, this.g), 0x1F, this.h), 0x1F, this.i)) * 0x1F, 0x1F);
        int v1 = A7.d.e(A7.d.c(A7.d.c(A7.d.c(A7.d.c((b.b(this.l) + v) * 0x1F, 0x1F, this.m), 0x1F, this.n), 0x1F, this.o), 0x1F, this.p), 0x1F, this.q);
        int v2 = b.b(this.r);
        int v3 = A7.d.b(this.w, A7.d.b(this.v, A7.d.c(A7.d.b(this.t, A7.d.b(this.s, (v2 + v1) * 0x1F, 0x1F), 0x1F), 0x1F, this.u), 0x1F), 0x1F);
        return this.x == null ? v3 : v3 + this.x.hashCode();
    }

    @Override
    public final String toString() {
        return o.r(new StringBuilder("{WorkSpec: "), this.a, '}');
    }
}

