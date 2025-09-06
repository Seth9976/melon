package d5;

import U4.D;
import U4.d;
import U4.i;
import e0.b;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;

public final class p {
    public final String a;
    public final D b;
    public final i c;
    public final long d;
    public final long e;
    public final long f;
    public final d g;
    public final int h;
    public final int i;
    public final long j;
    public final long k;
    public final int l;
    public final int m;
    public final long n;
    public final int o;
    public final List p;
    public final List q;

    public p(String s, D d0, i i0, long v, long v1, long v2, d d1, int v3, int v4, long v5, long v6, int v7, int v8, long v9, int v10, ArrayList arrayList0, ArrayList arrayList1) {
        q.g(s, "id");
        q.g(i0, "output");
        Y.r(v4, "backoffPolicy");
        q.g(arrayList0, "tags");
        q.g(arrayList1, "progress");
        super();
        this.a = s;
        this.b = d0;
        this.c = i0;
        this.d = v;
        this.e = v1;
        this.f = v2;
        this.g = d1;
        this.h = v3;
        this.i = v4;
        this.j = v5;
        this.k = v6;
        this.l = v7;
        this.m = v8;
        this.n = v9;
        this.o = v10;
        this.p = arrayList0;
        this.q = arrayList1;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof p && q.b(this.a, ((p)object0).a) && this.b == ((p)object0).b && q.b(this.c, ((p)object0).c) && this.d == ((p)object0).d && this.e == ((p)object0).e && this.f == ((p)object0).f && this.g.equals(((p)object0).g) && this.h == ((p)object0).h && this.i == ((p)object0).i && this.j == ((p)object0).j && this.k == ((p)object0).k && this.l == ((p)object0).l && this.m == ((p)object0).m && this.n == ((p)object0).n && this.o == ((p)object0).o && q.b(this.p, ((p)object0).p) && q.b(this.q, ((p)object0).q);
    }

    @Override
    public final int hashCode() {
        int v = A7.d.c(A7.d.c((b.b(this.i) + A7.d.b(this.h, (this.g.hashCode() + A7.d.c(A7.d.c(A7.d.c((this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F) * 0x1F, 0x1F, this.d), 0x1F, this.e), 0x1F, this.f)) * 0x1F, 0x1F)) * 0x1F, 0x1F, this.j), 0x1F, this.k);
        return this.q.hashCode() + A7.d.d(A7.d.b(this.o, A7.d.c(A7.d.b(this.m, A7.d.b(this.l, v, 0x1F), 0x1F), 0x1F, this.n), 0x1F), 0x1F, this.p);
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("WorkInfoPojo(id=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", state=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", output=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", initialDelay=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", intervalDuration=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", flexDuration=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", constraints=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", runAttemptCount=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", backoffPolicy=");
        switch(this.i) {
            case 1: {
                s = "EXPONENTIAL";
                break;
            }
            case 2: {
                s = "LINEAR";
                break;
            }
            default: {
                s = "null";
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(", backoffDelayDuration=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", lastEnqueueTime=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", periodCount=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(", generation=");
        stringBuilder0.append(this.m);
        stringBuilder0.append(", nextScheduleTimeOverride=");
        stringBuilder0.append(this.n);
        stringBuilder0.append(", stopReason=");
        stringBuilder0.append(this.o);
        stringBuilder0.append(", tags=");
        stringBuilder0.append(this.p);
        stringBuilder0.append(", progress=");
        stringBuilder0.append(this.q);
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

