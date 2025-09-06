package t5;

import android.content.Context;
import android.graphics.Bitmap.Config;
import coil.memory.MemoryCache.Key;
import coil.request.ImageRequest.Builder;
import java.util.List;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Headers;
import u5.f;
import u5.h;
import v5.b;
import w5.e;

public final class j {
    public final q A;
    public final MemoryCache.Key B;
    public final d C;
    public final c D;
    public final Context a;
    public final Object b;
    public final b c;
    public final i d;
    public final MemoryCache.Key e;
    public final Bitmap.Config f;
    public final u5.c g;
    public final k5.i h;
    public final List i;
    public final e j;
    public final Headers k;
    public final t l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final t5.b q;
    public final t5.b r;
    public final t5.b s;
    public final CoroutineDispatcher t;
    public final CoroutineDispatcher u;
    public final CoroutineDispatcher v;
    public final CoroutineDispatcher w;
    public final androidx.lifecycle.t x;
    public final h y;
    public final f z;

    public j(Context context0, Object object0, b b0, i i0, MemoryCache.Key memoryCache$Key0, Bitmap.Config bitmap$Config0, u5.c c0, k5.i i1, List list0, e e0, Headers headers0, t t0, boolean z, boolean z1, boolean z2, boolean z3, t5.b b1, t5.b b2, t5.b b3, CoroutineDispatcher coroutineDispatcher0, CoroutineDispatcher coroutineDispatcher1, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, androidx.lifecycle.t t1, h h0, f f0, q q0, MemoryCache.Key memoryCache$Key1, d d0, c c1) {
        this.a = context0;
        this.b = object0;
        this.c = b0;
        this.d = i0;
        this.e = memoryCache$Key0;
        this.f = bitmap$Config0;
        this.g = c0;
        this.h = i1;
        this.i = list0;
        this.j = e0;
        this.k = headers0;
        this.l = t0;
        this.m = z;
        this.n = z1;
        this.o = z2;
        this.p = z3;
        this.q = b1;
        this.r = b2;
        this.s = b3;
        this.t = coroutineDispatcher0;
        this.u = coroutineDispatcher1;
        this.v = coroutineDispatcher2;
        this.w = coroutineDispatcher3;
        this.x = t1;
        this.y = h0;
        this.z = f0;
        this.A = q0;
        this.B = memoryCache$Key1;
        this.C = d0;
        this.D = c1;
    }

    public static ImageRequest.Builder a(j j0) {
        j0.getClass();
        return new ImageRequest.Builder(j0, j0.a);
    }

    // 去混淆评级： 低(35)
    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof j) {
                j j0 = (j)object0;
                return kotlin.jvm.internal.q.b(this.a, j0.a) && this.b.equals(j0.b) && kotlin.jvm.internal.q.b(this.c, j0.c) && kotlin.jvm.internal.q.b(this.d, j0.d) && kotlin.jvm.internal.q.b(this.e, j0.e) && this.f == j0.f && this.g == j0.g && kotlin.jvm.internal.q.b(this.h, j0.h) && kotlin.jvm.internal.q.b(this.i, j0.i) && kotlin.jvm.internal.q.b(this.j, j0.j) && kotlin.jvm.internal.q.b(this.k, j0.k) && this.l.equals(j0.l) && this.m == j0.m && this.n == j0.n && this.o == j0.o && this.p == j0.p && this.q == j0.q && this.r == j0.r && this.s == j0.s && kotlin.jvm.internal.q.b(this.t, j0.t) && kotlin.jvm.internal.q.b(this.u, j0.u) && kotlin.jvm.internal.q.b(this.v, j0.v) && kotlin.jvm.internal.q.b(this.w, j0.w) && kotlin.jvm.internal.q.b(this.B, j0.B) && kotlin.jvm.internal.q.b(this.x, j0.x) && this.y.equals(j0.y) && this.z == j0.z && this.A.equals(j0.A) && this.C.equals(j0.C) && kotlin.jvm.internal.q.b(this.D, j0.D);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = A7.d.e(A7.d.e(A7.d.e(A7.d.e((this.l.a.hashCode() + (this.k.hashCode() + (this.j.hashCode() + A7.d.d(((this.g.hashCode() + (this.f.hashCode() + ((((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F + (this.d == null ? 0 : this.d.hashCode())) * 0x1F + (this.e == null ? 0 : this.e.hashCode())) * 961) * 961) * 961 + (this.h == null ? 0 : this.h.hashCode())) * 0x1F, 0x1F, this.i)) * 0x1F) * 0x1F) * 0x1F, 0x1F, this.m), 0x1F, this.n), 0x1F, this.o), 0x1F, this.p);
        int v2 = this.q.hashCode();
        int v3 = this.r.hashCode();
        int v4 = this.s.hashCode();
        int v5 = this.t.hashCode();
        int v6 = this.u.hashCode();
        int v7 = this.v.hashCode();
        int v8 = this.w.hashCode();
        int v9 = this.x.hashCode();
        int v10 = this.y.hashCode();
        int v11 = this.z.hashCode();
        int v12 = this.A.a.hashCode();
        MemoryCache.Key memoryCache$Key0 = this.B;
        if(memoryCache$Key0 != null) {
            v = memoryCache$Key0.hashCode();
        }
        return this.D.hashCode() + (this.C.hashCode() + ((v12 + (v11 + (v10 + (v9 + (v8 + (v7 + (v6 + (v5 + (v4 + (v3 + (v2 + v1) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F + v) * 0x67E12CDF) * 0x1F;
    }
}

