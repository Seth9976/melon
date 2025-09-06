package x1;

import B1.c;
import B1.g;
import B1.h;
import java.util.ArrayList;
import kotlin.jvm.internal.I;
import r0.q;
import wa.a;
import we.k;

public final class j {
    public final g a;
    public int b;
    public final int c;
    public int d;
    public a e;
    public int f;
    public final ArrayList g;

    public j() {
        new ArrayList();
        this.a = new g(new char[0]);  // 初始化器: LB1/b;-><init>([C)V
        this.c = 1000;
        this.d = 1000;
        this.f = 0;
        this.g = new ArrayList();
    }

    public final g a(o o0) {
        String s = o0.a().toString();
        g g0 = this.a;
        c c0 = g0.u(s);
        if((c0 instanceof g ? ((g)c0) : null) == null) {
            g0.A(s, new g(new char[0]));  // 初始化器: LB1/b;-><init>([C)V
        }
        c c1 = g0.p(s);
        if(c1 instanceof g) {
            return (g)c1;
        }
        StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("no object found for key <", s, ">, found [");
        stringBuilder0.append(c1.g());
        stringBuilder0.append("] : ");
        stringBuilder0.append(c1);
        throw new h(stringBuilder0.toString(), g0);
    }

    public static q b(q q0, e e0, k k0) {
        return q0.then(new i(e0, k0));
    }

    public final x1.g c(float f) {
        int v = this.d;
        this.d = v + 1;
        Integer integer0 = v;
        p p0 = new p(integer0);  // 初始化器: Lx1/o;-><init>(Ljava/lang/Object;)V
        B1.a a0 = new B1.a(new char[0]);  // 初始化器: LB1/b;-><init>([C)V
        a0.k(B1.i.k("start"));
        a0.k(new B1.e(f));
        g g0 = this.a(p0);
        g0.C("type", "vGuideline");
        g0.A("percent", a0);
        this.i(3);
        this.i(Float.hashCode(f));
        return new x1.g(integer0, 0, p0);
    }

    public final f d(float f) {
        int v = this.d;
        this.d = v + 1;
        Integer integer0 = v;
        p p0 = new p(integer0);  // 初始化器: Lx1/o;-><init>(Ljava/lang/Object;)V
        g g0 = this.a(p0);
        g0.C("type", "hGuideline");
        g0.A("percent", new B1.e(f));
        this.i(8);
        this.i(Float.hashCode(f));
        return new f(integer0, 0, p0);
    }

    public final e e() {
        int v = this.f;
        this.f = v + 1;
        ArrayList arrayList0 = this.g;
        e e0 = (e)je.p.n0(v, arrayList0);
        if(e0 == null) {
            e0 = new e(this.f);
            arrayList0.add(e0);
        }
        return e0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof j ? kotlin.jvm.internal.q.b(this.a, ((j)object0).a) : false;
    }

    public final a f() {
        a a0 = this.e;
        if(a0 == null) {
            a0 = new a(this);
            this.e = a0;
        }
        return a0;
    }

    public final void g(o[] arr_o) {
        int v = this.d;
        this.d = v + 1;
        p p0 = new p(v);  // 初始化器: Lx1/o;-><init>(Ljava/lang/Object;)V
        B1.a a0 = new B1.a(new char[0]);  // 初始化器: LB1/b;-><init>([C)V
        for(int v2 = 0; v2 < arr_o.length; ++v2) {
            o o0 = arr_o[v2];
            String s = I.a.b(x1.a.class).m();
            o0.b.get(s);
            a0.k(B1.i.k(o0.a().toString()));
        }
        B1.a a1 = new B1.a(new char[0]);  // 初始化器: LB1/b;-><init>([C)V
        a1.k(B1.i.k("packed"));
        a1.k(new B1.e(0.5f));
        g g0 = this.a(p0);
        g0.C("type", "vChain");
        g0.A("contains", a0);
        g0.A("style", a1);
        this.i(17);
        for(int v1 = 0; v1 < arr_o.length; ++v1) {
            this.i(arr_o[v1].hashCode());
        }
        this.i(b.a.hashCode());
    }

    public final void h() {
        this.a.e.clear();
        this.d = this.c;
        this.b = 0;
        this.f = 0;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    public final void i(int v) {
        this.b = (this.b * 1009 + v) % 1000000007;
    }
}

