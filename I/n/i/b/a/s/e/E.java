package i.n.i.b.a.s.e;

import java.util.Collections;

public final class e {
    public final String a;
    public final d b;
    public final c c;
    public final M d;
    public final b e;

    public e(String s, b b0, d d0, c c0, M m0) {
        this.a = s;
        this.b = d0;
        this.c = c0;
        this.d = m0;
        this.e = b0;
    }

    public final a a() {
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.c = Collections.EMPTY_MAP;
        a0.e = Collections.EMPTY_LIST;
        a0.d = Collections.EMPTY_MAP;
        a0.f = Collections.EMPTY_LIST;
        a0.g = Collections.EMPTY_LIST;
        a0.a = this.a;
        a0.h = this.d;
        a0.i = this.c.a;
        a0.j = this.c.b;
        a0.k = this.c.c;
        a0.l = this.c.d;
        a0.m = this.c.e;
        d d0 = this.b;
        if(d0 != null) {
            a0.b = d0.a;
            a0.c = d0.b;
            a0.f = d0.c;
            a0.g = d0.d;
        }
        return a0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof e ? L7.p(this.a, ((e)object0).a) && this.e.equals(((e)object0).e) && L7.p(this.b, ((e)object0).b) && L7.p(this.c, ((e)object0).c) && L7.p(this.d, ((e)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? this.d.hashCode() + (this.e.hashCode() + (this.c.hashCode() + v * 961) * 0x1F) * 0x1F : this.d.hashCode() + (this.e.hashCode() + (this.c.hashCode() + (v * 0x1F + this.b.hashCode()) * 0x1F) * 0x1F) * 0x1F;
    }
}

