package androidx.compose.foundation.lazy.layout;

import B3.v;
import I0.h;
import L.a;
import N0.h0;
import N0.j0;
import Uf.d;
import Uf.e;
import android.os.Trace;
import androidx.appcompat.app.o;
import i.n.i.b.a.s.e.M3;
import java.util.List;
import kotlin.jvm.internal.q;
import o9.b;
import we.k;
import we.n;
import y8.s;

public final class a0 implements H {
    public final int a;
    public final long b;
    public final b c;
    public h0 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public Z h;
    public boolean i;
    public long j;
    public long k;
    public long l;
    public final s m;

    public a0(s s0, int v, long v1, b b0) {
        this.m = s0;
        this.a = v;
        this.b = v1;
        this.c = b0;
        this.l = System.nanoTime() - e.a;
    }

    @Override  // androidx.compose.foundation.lazy.layout.H
    public final void a() {
        this.i = true;
    }

    public final boolean b(v v0) {
        b b1;
        b b3;
        long v9;
        long v1 = v0.a;
        s s0 = this.m;
        androidx.compose.foundation.lazy.layout.v v2 = (androidx.compose.foundation.lazy.layout.v)((u)s0.a).b.invoke();
        if(!this.f) {
            int v3 = v2.getItemCount();
            int v4 = this.a;
            if(v4 >= 0 && v4 < v3) {
                Object object0 = v2.a(v4);
                this.j = Math.max(0L, v1 - System.nanoTime());
                this.l = System.nanoTime() - e.a;
                this.k = 0L;
                b b0 = this.c;
                if(this.d == null) {
                    long v5 = this.j;
                    long v6 = b0.q(object0).a;
                    if((!this.i || v5 <= 0L) && v6 >= v5) {
                        return true;
                    }
                    Trace.beginSection("compose:lazy:prefetch:compose");
                    try {
                        if(this.d != null) {
                            a.a("Request was already composed!");
                        }
                        Object object1 = v2.c(v4);
                        n n0 = ((u)s0.a).a(v4, object1, object0);
                        this.d = ((j0)s0.b).a().g(object1, n0);
                    }
                    catch(Throwable throwable0) {
                        Trace.endSection();
                        throw throwable0;
                    }
                    Trace.endSection();
                    this.e();
                    long v7 = this.k;
                    androidx.compose.foundation.lazy.layout.b b2 = (androidx.compose.foundation.lazy.layout.b)b0.a;
                    long v8 = b2.a;
                    if(v8 == 0L) {
                        v9 = v7;
                        b3 = b0;
                    }
                    else {
                        b3 = b0;
                        v9 = v7 / 4L + v8 / 4L * 3L;
                    }
                    b2.a = v9;
                    b1 = b3;
                    androidx.compose.foundation.lazy.layout.b b4 = b1.q(object0);
                    long v10 = b4.a;
                    if(v10 != 0L) {
                        v7 = v7 / 4L + v10 / 4L * 3L;
                    }
                    b4.a = v7;
                }
                else {
                    b1 = b0;
                }
                if(!this.i) {
                    if(!this.g) {
                        if(this.j > 0L) {
                            Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                            try {
                                this.h = this.d();
                                this.g = true;
                            }
                            catch(Throwable throwable1) {
                                Trace.endSection();
                                throw throwable1;
                            }
                            Trace.endSection();
                            goto label_59;
                        }
                        return true;
                    }
                label_59:
                    Z z0 = this.h;
                    if(z0 != null) {
                        List[] arr_list = (List[])z0.d;
                        int v11 = z0.a;
                        List list0 = (List)z0.c;
                        if(v11 < list0.size()) {
                            if(((a0)z0.e).f) {
                                a.c("Should not execute nested prefetch on canceled request");
                            }
                            Trace.beginSection("compose:lazy:prefetch:nested");
                            while(z0.a < list0.size()) {
                                try {
                                    if(arr_list[z0.a] == null) {
                                        goto label_70;
                                    }
                                    goto label_78;
                                }
                                catch(Throwable throwable2) {
                                    Trace.endSection();
                                    throw throwable2;
                                }
                            label_70:
                                if(Math.max(0L, v1 - System.nanoTime()) <= 0L) {
                                    Trace.endSection();
                                    return true;
                                }
                                try {
                                    int v12 = z0.a;
                                    I i0 = (I)list0.get(v12);
                                    G g0 = new G(i0);
                                    ((k)i0.a).invoke(g0);
                                    arr_list[v12] = g0.a;
                                label_78:
                                    List list1 = arr_list[z0.a];
                                    q.d(list1);
                                label_80:
                                    if(z0.b >= list1.size()) {
                                        z0.b = 0;
                                        ++z0.a;
                                        continue;
                                    }
                                    if(!((a0)list1.get(z0.b)).b(v0)) {
                                        ++z0.b;
                                        goto label_80;
                                    }
                                }
                                catch(Throwable throwable2) {
                                    Trace.endSection();
                                    throw throwable2;
                                }
                                Trace.endSection();
                                return true;
                            }
                            Trace.endSection();
                        }
                    }
                    this.e();
                }
                if(!this.e) {
                    long v13 = this.b;
                    if(!r1.a.k(v13)) {
                        long v14 = this.j;
                        long v15 = b1.q(object0).b;
                        if(this.i && v14 > 0L || v15 < v14) {
                            Trace.beginSection("compose:lazy:prefetch:measure");
                            try {
                                this.c(v13);
                            }
                            catch(Throwable throwable3) {
                                Trace.endSection();
                                throw throwable3;
                            }
                            Trace.endSection();
                            this.e();
                            long v16 = this.k;
                            androidx.compose.foundation.lazy.layout.b b5 = (androidx.compose.foundation.lazy.layout.b)b1.a;
                            b5.b = b5.b == 0L ? v16 : v16 / 4L + b5.b / 4L * 3L;
                            androidx.compose.foundation.lazy.layout.b b6 = b1.q(object0);
                            long v17 = b6.b;
                            if(v17 != 0L) {
                                v16 = v16 / 4L + v17 / 4L * 3L;
                            }
                            b6.b = v16;
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void c(long v) {
        if(this.f) {
            a.a("Callers should check whether the request is still valid before calling performMeasure()");
        }
        if(this.e) {
            a.a("Request was already measured!");
        }
        this.e = true;
        h0 h00 = this.d;
        if(h00 != null) {
            int v1 = h00.a();
            for(int v2 = 0; v2 < v1; ++v2) {
                h00.c(v2, v);
            }
            return;
        }
        a.b("performComposition() must be called before performMeasure()");
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // androidx.compose.foundation.lazy.layout.H
    public final void cancel() {
        if(!this.f) {
            this.f = true;
            h0 h00 = this.d;
            if(h00 != null) {
                h00.dispose();
            }
            this.d = null;
        }
    }

    public final Z d() {
        h0 h00 = this.d;
        if(h00 != null) {
            kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
            h00.b(new h(5, h0));
            List list0 = (List)h0.a;
            if(list0 != null) {
                Z z0 = new Z();  // 初始化器: Ljava/lang/Object;-><init>()V
                z0.e = this;
                z0.c = list0;
                z0.d = new List[list0.size()];
                if(list0.isEmpty()) {
                    a.a("NestedPrefetchController shouldn\'t be created with no states");
                }
                return z0;
            }
            return null;
        }
        a.b("Should precompose before resolving nested prefetch states");
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    public final void e() {
        long v = System.nanoTime() - e.a;
        long v1 = this.l;
        d d0 = d.b;
        q.g(d0, "unit");
        long v2 = 0L;
        if(Long.compare(v1 - 1L | 1L, 0x7FFFFFFFFFFFFFFFL) != 0) {
            if((v - 1L | 1L) == 0x7FFFFFFFFFFFFFFFL) {
                v2 = v >= 0L ? Uf.b.c : Uf.b.d;
            }
            else {
                long v3 = v - v1;
                if(((v3 ^ v) & ~(v3 ^ v1)) < 0L) {
                    d d1 = d.c;
                    if(d0.compareTo(d1) < 0) {
                        long v4 = y5.a.u(1L, d1, d0);
                        v2 = Uf.b.h(x1.a.Q(v / v4 - v1 / v4, d1), x1.a.Q(v % v4 - v1 % v4, d0));
                    }
                    else {
                        v2 = Uf.b.k((v3 >= 0L ? Uf.b.c : Uf.b.d));
                    }
                }
                else {
                    v2 = x1.a.Q(v3, d0);
                }
            }
        }
        else if(v != v1) {
            v2 = Uf.b.k((v1 >= 0L ? Uf.b.c : Uf.b.d));
        }
        long v5 = Uf.b.e(v2);
        this.k = v5;
        this.j -= v5;
        this.l = v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("HandleAndRequestImpl { index = ");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", constraints = ");
        stringBuilder0.append(r1.a.l(this.b));
        stringBuilder0.append(", isComposed = ");
        stringBuilder0.append(this.d != null);
        stringBuilder0.append(", isMeasured = ");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isCanceled = ");
        return o.s(stringBuilder0, this.f, " }");
    }
}

